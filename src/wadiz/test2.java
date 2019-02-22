package wadiz;

import static java.util.stream.Collectors.joining;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class test2 {

	public static void main(String[] args) {

		String input1 = "wadizian, wadiz, wadiz, reward, equity";
		String input2 = "wa";

		StringTokenizer tokens = new StringTokenizer(input1, ",");

		Map<String, Integer> hmap = new HashMap<>();

		for (int x = 1; tokens.hasMoreElements(); x++) {
			String key = tokens.nextToken().replace(" ", "");
			hmap.put(key, (hmap.containsKey(key) ? hmap.get(key) : 0) + 1);
		}

		System.out.println(hmap);

		String resultStr = hmap.entrySet().stream().filter(entry -> entry.getKey().startsWith(input2))
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.map(entry -> entry.getKey()).collect(joining(" "));

		System.out.println(resultStr);

		/*Pattern p = Pattern.compile(input2 + "*");

		List<String> matchingKeys = new ArrayList<>();
		for (String key : map.keySet()) {
			if (p.matcher(key).matches()) {
				matchingKeys.add(key);
			}
		}*/
		//System.out.println(matchingKeys);
	}

}
