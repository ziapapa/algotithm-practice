package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class ArithmeticOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArithmeticOperation dn = new ArithmeticOperation();
		String[] arr = {"1", "-", "3", "+", "5", "-", "8"};
		dn.solution(arr);

	}

	//작성중
	public int[] solution(String[] arr) {
		int[] answer = {};

		int index = 0;
		ArrayList<Integer> tempList = new ArrayList<>();

		for (String str : arr){

		}

		if (tempList.size() == 0)
			tempList.add(-1);

		int[] tempArr = new int[tempList.size()];
		for (int j = 0 ; j < tempList.size() ; j++){
			tempArr[j] = tempList.get(j);
		}

		answer = tempArr;
		Arrays.sort(answer);
		System.out.println(tempList);
		return answer;
	}

}
