package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <pre>
 * algorithm
 * Wtest2.java
 *
 * 설명 : 데이터 그룹화
 * </pre>
 *
 * @since : 2018. 8. 22.
 * @author : jdh79
 * @version : v1.0
 */
public class Wtest2 {

	/*보기 입력 1
	2018-08-03|10001|A02
	2018-08-01|10004|A09
	2018-08-02|10001|A02
	2018-08-05|10001|A05
	2018-08-09|10001|A07
	2018-08-10|10007|A09
	2018-08-08|10001|A05
	2018-08-08|10001|A02
	2018-08-04|10003|A01
	2018-08-02|10003|A04
	2018-08-04|10003|A01
	2018-08-04|10003|A06
	2018-08-03|10006|A01
	2018-08-02|10006|A02
	2018-08-03|10006|A04
	2018-08-10|10007|A09
	출력 1
	10001:6=>A02:3,A05:2,A07:1
	10003:4=>A01:2,A04:1,A06:1
	10006:3=>A01:1,A02:1,A04:1

	보기 입력 2
	2018-08-03|10001|A02
	2018-08-01|10004|A09
	2018-08-02|10001|A02
	2018-08-05|10001|A05
	2018-08-09|10001|A07
	2018-08-10|10007|A09
	2018-08-08|10001|A05
	2018-08-08|10001|A02
	2018-08-04|10003|A01
	2018-08-02|10003|A04
	2018-08-04|10003|A01
	2018-08-04|10003|A06
	2018-08-10|10007|A09
	2018-08-08|10001|A05
	2018-08-08|10001|A05
	출력 2
	10001:8=>A05:4,A02:3,A07:1
	10003:4=>A01:2,A04:1,A06:1

	보기 입력 3
	2018-08-01|10004|A09
	2018-08-10|10007|A09
	2018-08-01|10007|A04
	2018-08-10|10007|A09
	2018-08-01|10001|A05
	출력 3
	NO RESULT*/

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<String> inputList = new ArrayList<>();
		String tempStr;
		do {
			tempStr = br.readLine();
			if (tempStr != null && !"".equals(tempStr))
				inputList.add(tempStr);
		} while (tempStr != null && !"".equals(tempStr));

		// System.out.println(inputList.size());

		List<OrderInfo> orderList = new ArrayList<>();

		for (String s : inputList) {
			String[] str = s.split("\\|");
			orderList.add(new OrderInfo(str[0], str[1], str[2]));
		}

		Map<String,Long> grouping1 = inputList.stream().map(line -> {
			String[] str = line.split("\\|");
			return new OrderInfo(str[0], str[1], str[2]);
		}).filter(p -> !(p.getDate().equals("2018-08-10") || p.getDate().equals("2018-08-01")))
		//.collect(Collectors.groupingBy(x -> new ArrayList<String>(Arrays.asList(x.getNumber(), x.getCode())), Collectors.counting()));
		//.collect(Collectors.groupingBy(x -> x.getNumber()+x.getCode(), Collectors.counting()));
		.collect(Collectors.groupingBy(p -> p.getNumber(), Collectors.counting()));

		Map<String, Map<String, Long>> grouping2 = inputList.stream().map(line -> {
			String[] str = line.split("\\|");
			return new OrderInfo(str[0], str[1], str[2]);
		}).filter(p -> !(p.getDate().equals("2018-08-10") || p.getDate().equals("2018-08-01")))
		//.collect(Collectors.groupingBy(x -> new ArrayList<String>(Arrays.asList(x.getNumber(), x.getCode())), Collectors.counting()));
		//.collect(Collectors.groupingBy(x -> x.getNumber()+x.getCode(), Collectors.counting()));
		.collect(Collectors.groupingBy(p -> p.getNumber(),
				Collectors.groupingBy(p -> p.getCode(), Collectors.counting())));

		if (grouping1.isEmpty()) {
			System.out.print("NO RESULT");
		} else {
			grouping1.entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().reversed()).limit(3)
			.forEachOrdered(e -> {
				System.out.print(e.getKey()+":"+e.getValue()+"=>");
				System.out.println(grouping2.get(e.getKey()).entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().reversed())
				.map(c -> c.getKey()+":"+c.getValue())
				.collect(Collectors.joining(",")));
			});
		}

		//System.out.println(grouping1.entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().reversed()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue)));
		//System.out.println(grouping1.toString().replace("{", "\n{\n").replace("}", "\n}\n"));
		//System.out.println(grouping2.toString().replace("{", "\n{\n").replace("}", "\n}\n"));
	}

	static class OrderInfo {

		OrderInfo(String date, String number, String code) {
			this.date = date;
			this.number = number;
			this.code = code;
		}

		String date;
		String number;
		String code;

		public String getDate() {
			return date;
		}

		public String getNumber() {
			return number;
		}

		public String getCode() {
			return code;
		}

		@Override
		public String toString() {
			return "OrderInfo [date=" + date + ", number=" + number + ", code=" + code + "]";
		}
	}
}
