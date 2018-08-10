package algorithm;

import java.util.*;

public class DiffNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DiffNumber dn = new DiffNumber();
		int[] arr = {4,4,4,3,3};
		dn.solution(arr);

	}

	public int[] solution(int[] arr) {
		int[] answer = {};

		int temp = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0, size = arr.length; i < size ; i++){

			if (i == 0) {
				temp = arr[i];
				list.add(arr[i]);
			} else if (temp != arr[i]){
				temp = arr[i];
				list.add(arr[i]);
			}
		}

		int[] tempArr = new int[list.size()];
		for (int j = 0 ; j < list.size() ; j++){
			tempArr[j] = list.get(j);
		}

		answer = tempArr;
		System.out.println(answer);
		return answer;
	}

}
