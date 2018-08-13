package algorithm;

public class ForecastBattleTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		solution(8, 4, 7);
	}

	public static int solution(int n, int a, int b) {
		int answer = 3;

		//System.out.println("Hello Java");
		
		int groupA = a;
		int groupB = b;
		int groupCnt = n;
		int topCnt = 0;
		
		while (groupA != groupB) {
			topCnt++;
			groupA = (groupCnt - (groupCnt - groupA) + 1)/ 2;
			groupB = (groupCnt - (groupCnt - groupB) + 1)/ 2;
			groupCnt = groupCnt / 2;
			System.out.println("A:" + groupA+ "/B:" + groupB);
		}
		System.out.println("topCnt:"+ topCnt);
		answer = topCnt;
		return answer;
	}
}
