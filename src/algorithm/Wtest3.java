package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * algorithm
 * Wtest3.java
 *
 * 설명 : 날짜 정규식 추출 정렬
 * </pre>
 *
 * @since : 2018. 8. 20.
 * @author : jdh79
 * @version : v1.0
 */
public class Wtest3 {

	public static void main(String[] args) throws Exception {

		/*보기 입력 1
		"2018/7/3 테스트."
		"테스트. 18년06월13일"
		"테스트 18-06-12테스트"
		END

		출력 1
		"테스트 18-06-12테스트"
		"테스트. 18년06월13일"
		"2018/7/3 테스트."*/

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<String> inputList = new ArrayList<>();
		String tempStr = "END";
		do {
			tempStr = br.readLine();
			if (!"END".equals(tempStr))
				inputList.add(tempStr);
		} while (!"END".equals(tempStr));

		System.out.println(inputList.size());

		TreeMap <String, String> tm = new TreeMap<>();
		for (String s : inputList) {
			System.out.println(extractDate(s));
			tm.put(extractDate(s), s);
		}

		Iterator<String> itr= tm.keySet().iterator();
		while (itr.hasNext()) {
			String key = (String)itr.next();
			System.out.println("***" + key + " " +tm.get(key));
		}
	}

	public static String extractDate(String str) {
		String dateStr = "";

		Pattern pattern;
		Matcher matcher;

		if (str.isEmpty()) {
			matcher = null;
		} else {
			String patternStr1 = ".*([0-9]{2,4})[^0-9]([0-9]{1,2})[^0-9]([0-9]{1,2}).*";
			pattern = Pattern.compile(patternStr1);
			matcher = pattern.matcher(str);

			if (matcher.find()) {
				String year = matcher.group(1).length() == 4 ? matcher.group(1) : "20"+matcher.group(1);
				String mon = matcher.group(2).length() == 2 ? matcher.group(2) : "0"+matcher.group(2);
				String day = matcher.group(3).length() == 2 ? matcher.group(3) : "0"+matcher.group(3);
				return dateStr = year + mon + day;
			}
		}

		return dateStr;
	}
}