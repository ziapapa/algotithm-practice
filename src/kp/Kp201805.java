package kp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kp201805 {
	/*
	Merge two sorted arrays of numbers. Find your optimall solution.

	Notice. Don't use native sort method.
	주의. 언어에서 제공하는 기본 정렬(Sort) 함수를 사용하지 마세요.

	최적의 알고리즘은 O(n) 복잡도로 정답을 찾을 수 있습니다.


	Input:
	5
	19 21 31 42 44
	12
	1 2 3 4 15 16 17 28 29 30 41 43

	Output
	1 2 3 4 15 16 17 19 21 28 29 30 31 41 42 43 44
	*/

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputCnt1 = br.readLine();
		int s1 = Integer.parseInt(inputCnt1.trim());
		String inputArray1 = br.readLine();

		String inputCnt2 = br.readLine();
		int s2 = Integer.parseInt(inputCnt2.trim());
		String inputArray2 = br.readLine();

		String[] str = (inputArray1.trim() + " " + inputArray2.trim()).split(" ");

		int len = str.length;

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (Integer.parseInt(str[i]) > Integer.parseInt(str[j])) {
					String temp = str[i];
					str[i] = str[j];
					str[j] = temp;
				}
			}
		}

		for (int x = 0; x < len; x++) {
			System.out.print(str[x] + " ");
		}

	}

}
