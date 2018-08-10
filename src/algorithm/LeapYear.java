package algorithm;

import java.util.Scanner;

public class LeapYear {

	// 윤년여부
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		if ((0 == (n % 4) && 0 != (n % 100)) || 0 == n % 400) {
			System.out.println("Leap Year");
		} else {
			System.out.println("Not Leap Year");
		}
	}
}
