package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class DivideNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DivideNumber dn = new DivideNumber();
		int[] arr = {2, 36, 1, 3};
		dn.solution(arr, 1);

	}

	public int[] solution(int[] arr, int divisor) {
		int[] answer = {};

		int temp = 0;
		ArrayList<Integer> tempList = new ArrayList<>();
		for (int i = 0, size = arr.length; i < size ; i++){
			if (arr[i] % divisor == 0)
				tempList.add(arr[i]);
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
