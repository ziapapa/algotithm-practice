package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Wtest3 {

	public static void main(String[] args) throws Exception {
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

		
		/*String aaa = extractDate("2018/7/3 배민은행의 구조도를 손에 넣었다. 필요한 장비는 이런거 저런거 해서 각자 준비해야한다.");
		String bbb = extractDate("타깃 은행은 잠실에 있는 배민은행으로 한다. 18년06월13일");
		String ccc = extractDate("배민은행앞 별다방에서 18-06-12에 만나기로 함");
		System.out.println("1"+aaa);
		System.out.println("2"+bbb);
		System.out.println("3"+ccc);*/
	}

	public static String extractDate(String str) {

		String dateStr = ""; 

		Pattern pattern;
		Matcher matcher;

		if (str.isEmpty()) {
			matcher = null;
		} else {
			String patternStr1 = "^([0-9]{4})/([0-9]+)/([0-9]+)[ \t].+";
			pattern = Pattern.compile(patternStr1);
			matcher = pattern.matcher(str);

			if (matcher.find()) {
				String year = matcher.group(1).length() == 4 ? matcher.group(1) : "20"+matcher.group(1);
				String mon = matcher.group(2).length() == 2 ? matcher.group(2) : "0"+matcher.group(2);
				String day = matcher.group(3).length() == 2 ? matcher.group(3) : "0"+matcher.group(3);
				return dateStr = year + mon + day;
			}
			
			String patternStr2 = ".+[ \t]([0-9]+)년([0-9]+)월([0-9]+)일";
			pattern = Pattern.compile(patternStr2);
			matcher = pattern.matcher(str);

			if (matcher.find()) {
				String year = matcher.group(1).length() == 4 ? matcher.group(1) : "20"+matcher.group(1);
				String mon = matcher.group(2).length() == 2 ? matcher.group(2) : "0"+matcher.group(2);
				String day = matcher.group(3).length() == 2 ? matcher.group(3) : "0"+matcher.group(3);
				return dateStr = year + mon + day;
			}
			
			String patternStr3 = ".+[ \t]([0-9]{2}+)-([0-9]+)-([0-9]+).+";
			pattern = Pattern.compile(patternStr3);
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