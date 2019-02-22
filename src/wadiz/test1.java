package wadiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class test1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String input = "";
		List<String> inputList = new ArrayList<>();
		inputList.add("TTTHTHHT,3");
		//inputList.add("HHHHH,4");
		//inputList.add("THTHT,4");
		/*do {
			input = br.readLine();
			if (input != null && !"".equals(input))
				inputList.add(input);
		} while (input != null && !"".equals(input));*/

		System.out.println(inputList);

		for(String line : inputList) {

			String[] lines = line.split(",");

			String N_STR = lines[0];
			int K = Integer.parseInt(lines[1]);

			char[] charArray = N_STR.toCharArray();
			int len = charArray.length;



			int changeCnt = K;
			int resultCnt = 0;
			for (int i = 0 ; i < len   ; i++) {

				if (charArray[i] == 'T' || changeCnt != 3 ) {

					//System.out.print(i + "-" + charArray[i + j] );
					if (charArray[i] == 'H')
						charArray[i] = 'T';
					else
						charArray[i] = 'H';

					changeCnt--;
					System.out.println(i + "-" + charArray[i] + "    "+ changeCnt);
				}

				if (changeCnt == 0) {
					changeCnt = K;
					resultCnt++;
				}

				if (i + K + 1 > len) {
					i = 0;
				}

				System.out.println(charArray);
			}

			System.out.println("result : "+ resultCnt);

			String aaa = new String(charArray, 0, charArray.length);

			System.out.println(aaa.indexOf("T"));
		}

	}

}
