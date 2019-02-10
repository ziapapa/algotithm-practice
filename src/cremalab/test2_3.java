package cremalab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test2_3 {

	public static void main(String[] args) {

		List<Integer> startingPos = new ArrayList<>(Arrays.asList(4, 15, 15, 12, 18, 3, 8));
		List<Integer> speed = new ArrayList<>(Arrays.asList(2, 5, 3, 2, 3, 3, 2));
		//List<Integer> startingPos = new ArrayList<>(Arrays.asList(4,3,1));
		//List<Integer> speed = new ArrayList<>(Arrays.asList(3,2,1));

		//List<Integer> startingPos = new ArrayList<>(Arrays.asList(4, 3));
		//List<Integer> speed = new ArrayList<>(Arrays.asList(2, 2));

		int[] intStartingPos = startingPos.stream().mapToInt(Integer::intValue).toArray();
		int[] intSpeed = speed.stream().mapToInt(Integer::intValue).toArray();

		int cnt = startingPos.size();

		int mid = 0;
		int left = 0;
		int right = cnt;

		while (right >= left) {
			mid = (right + left) / 2;

			int attackCnt = 0;
			for (int j = 0; j < cnt; j++) {
				int nextValue = intStartingPos[j] - (intSpeed[j] * mid);
				if (nextValue <= 0) {
					attackCnt++;
				}

				System.out.println("====== i:" + mid + "  attackCnt : " + attackCnt + " nextValue : " + nextValue);
			}
			
			if (attackCnt == mid) break;

			if (attackCnt < mid) {
				right = mid - 1;
			} else if (attackCnt > mid){
				left = mid + 1;
			}
			mid++;
		}
		System.out.println("sec :" + mid);
	}
}
