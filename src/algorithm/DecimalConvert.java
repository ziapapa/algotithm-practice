package algorithm;

import java.util.Scanner;

public class DecimalConvert {

	//10진수를 16진수로 표현
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		System.out.println(Integer.toHexString(n));

	}
}
