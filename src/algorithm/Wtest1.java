package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 * algorithm
 * Wtest1.java
 *
 * 설명 : 숫자 조합의 합
 * </pre>
 *
 * @since : 2018. 8. 22.
 * @author : jdh79
 * @version : v1.0
 */
public class Wtest1 {

	/*입/출력 예시
	⋇ 입출력 형식을 잘 지켜주세요.
	␣ : 공백
	↵ : 줄바꿈
	−⇥ : 탭
	보기 입력 1
	1 2 3 4 5
	8
	출력 1
	1 2 5
	1 3 4

	보기 입력 2
	1 2 3 4 5
	3
	출력 2
	NO*/

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputNumber = "1 2 3 4 5";// br.readLine();
		int inputSum = 8;// Integer.parseInt(br.readLine());

		String[] numbers = inputNumber.split(" ");
		List<Integer> list = new ArrayList<>();

		for (String s : numbers)
			list.add(Integer.parseInt(s));

		Collections.sort(list);

		System.out.println(list);

		Set<String> resultList = new TreeSet<>();
		choice(list, inputSum, resultList);

		// Collections.sort(resultList);
		// System.out.println(resultList);

		if (resultList.size() > 0) {
			for (String s : resultList) {
				System.out.println(s);
			}
		} else {
			System.out.println("NO");
		}
	}

	public static void choice(List<Integer> list, int inputSum, Set<String> resultList) {

		for (int i = 0; i < list.size(); i++) {

			int first = list.get(i);
			for (int j = 1; j < list.size(); j++) {
				// System.out.println("list:"+list);
				int second = 0;
				if (i != j && i < j) {
					second = list.get(j);

					for (int z = 2; z < list.size(); z++) {
						// System.out.println("list:"+list);

						int third = 0;
						if (j != z && j < z) {
							third = list.get(z);

							if (first + second + third == inputSum) {
								resultList.add(first + " " + second + " " + third);

								// int[] num = {first, second, third};
								// resultList.add(num);
							}
						}
					}
				}
			}
		}
	}
}