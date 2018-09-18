package kp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Kp201801 {
	/*
	Input:
	첫번째 줄에서는 N과 M의 값을 입력받습니다. N은 두번째 줄에서 입력받을 숫자의 개수, M은 세번째 줄부터 나올 문제의 개수입니다.
	두번째 줄에서는 N개만큼의 정수가 나열됩니다.
	세번째 줄부터 입력받은 정수에 따라 결과값을 출력해주면 됩니다.

	Output:
	M개의 개수만큼 'True' 또는 'False'를 출력합니다.

	Input
	4 2
	99 12 10 23
	23
	25

	Output
	True
	False
	*/

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();

		String[] str1 = input1.split(" ");
		int n = Integer.parseInt(str1[0]);
		int m = Integer.parseInt(str1[1]);

		String input2 = br.readLine();
		String[] input3 = new String[m];

		for (int j = 0; j < m; j++) {
			input3[j] = br.readLine();
		}

		String[] str2 = input2.split(" ");

		for (int i = 0; i < m; i++) {
			String result = "False";
			for (String s : str2) {
				if (s.equals(input3[i])) {
					result = "True";
					break;
				}
			}
			System.out.println(result);
		}
	}

}
