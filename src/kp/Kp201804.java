package kp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kp201804 {

	/*
	Example

	input
	3
	Hello World
	Bye World
	Useless World

	output
	World Hello
	World Bye
	World Useless
	*/

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int m = Integer.parseInt(input.trim());

		String[] input2 = new String[m];

		for (int i = 0; i < m; i++) {
			input2[i] = br.readLine();
		}

		for (int j = 0; j < m; j++) {
			String[] str = input2[j].split(" ");
			List<String> list = Arrays.asList(str);

			Collections.reverse(list);

			str = list.toArray(new String[list.size()]);

			String s = String.join(" ", str);
			System.out.println(s);
		}

	}

}
