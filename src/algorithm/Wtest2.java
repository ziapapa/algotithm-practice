package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

public class Wtest2 {

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

		Map<String, Map<String, List<OrderInfo>>> grouping = orderList.stream()
				.collect(Collectors.groupingBy(OrderInfo::getNumber, Collectors.groupingBy(OrderInfo::getCode)));
		
		System.out.println(grouping.toString());
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
