package algorithm;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {

	static int cnt = 0;

	static List<int[]> list = new ArrayList<int[]>();
	public static void main(String[] args) {
		// 하노이탑
		solution(2);
	}

	static public int[][] solution(int n) {
		int[][] answer = {};

		Hanoi(n, 1, 2, 3);

		int size = list.size();
		answer = new int[size][2];
		
		for (int i = 0; i < size ; i++) {
			answer[i] = list.get(i);
		}
		
		//System.out.println("cnt:"+cnt);
		return answer;
	}

	static public void Hanoi(int n, int from, int by, int to) {

		if (n == 1) {
			Move(from, to, n);
		} else {
			Hanoi(n - 1, from, to, by);
			Move(from, to, n);
			Hanoi(n - 1, by, from, to);
		}
	}

	static public void Move(int a, int b, int n) {
		
		System.out.println(n + "이동" + a + "->" + b);
		int[] array = {a,b};
		list.add(array);
		cnt++;
	}
}
