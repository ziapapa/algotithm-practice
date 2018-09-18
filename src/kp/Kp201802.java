package kp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Kp201802 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int m = Integer.parseInt(input);

		int[] inputInt = new int[m];
		for (int j = 0; j < m; j++) {
			inputInt[j] = Integer.parseInt(br.readLine().trim());
		}

		String[] splitStrs = fibonacci(60).split(",");

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < splitStrs.length; j++) {
				if (inputInt[i] < Long.parseLong(splitStrs[j])) {
					System.out.println(splitStrs[j]);
					break;
				}
			}
		}
	}

	private static String fibonacci(int n) {

		long a1 = 0;
		long a2 = 1;
		long a3;

		StringBuffer sb = new StringBuffer();
		sb.append(1);
		for (int i = 1; i < n; i++) {
			a3 = a1 + a2;

			sb.append(",");
			sb.append(a3);

			a1 = a2;
			a2 = a3;
		}

		return sb.toString();
	}

}
