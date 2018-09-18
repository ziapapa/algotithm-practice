package kp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kp201803 {

	/*Example :
		첫 줄의 숫자는 문제의 개수 입니다. The number at first line is total number of following input lines.

		Input :
		2
		http://page.kakao.com/store
		abc123@is.my.id

		Output:
		http page kakao com store.
		abc123 is my id
	 */

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int m = Integer.parseInt(input);

		String[] input2 = new String[m];

		for (int i = 0; i < m; i++) {
			input2[i] = br.readLine();
		}

		for (int j = 0; j < m; j++) {
			char ch[] = input2[j].toCharArray();
			for (int k = 0; k < ch.length ; k++){
				int c = (int)ch[k];
				if (!((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)))
					ch[k] = ' ';

			}

			String chg = new String(ch, 0, ch.length);
			StringTokenizer st = new StringTokenizer(chg, " ");
			StringBuffer sb = new StringBuffer();
			while(st.hasMoreElements()){
				sb.append(st.nextElement()).append(" ");
			}

			System.out.println(sb.toString().trim());
		}

	}

}
