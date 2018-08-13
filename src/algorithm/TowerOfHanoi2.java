package algorithm;

public class TowerOfHanoi2 {

	public static void main(String[] args) {
		// 하노이탑
		solution(2);
	}

	static public int[][] solution(int n) {
		int[][] answer = new int[(int)Math.pow(2, n)-1][2];
		int cnt = 0;
		
		Hanoi(answer, n, 1, 2, 3, cnt);
		
		//System.out.println("cnt:"+cnt);
		return answer;
	}

	static public void Hanoi(int[][] answer, int n, int from, int by, int to, int cnt) {

		if (n == 1) {
			System.out.println("0cnt:" + cnt + "/" + n + "이동" + from + "->" + to);
			answer[cnt][0] = from;
			answer[cnt][1] = to;
			cnt++;
		} else {
			Hanoi(answer, n - 1, from, to, by, cnt);
			System.out.println("1cnt:" + cnt + "/" + n + "이동" + from + "->" + to);
			answer[cnt][0] = from;
			answer[cnt][1] = to;
			cnt++;
			Hanoi(answer, n - 1, by, from, to, cnt);
		}
	}
}
