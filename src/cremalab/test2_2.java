package cremalab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test2_2 {

	public static void main(String[] args) {

		List<Integer> startingPos = new ArrayList<>(Arrays.asList(4, 15, 15, 12, 18, 3, 8));
		List<Integer> speed = new ArrayList<>(Arrays.asList(2, 5, 3, 2, 3, 3, 2));
		//List<Integer> startingPos = new ArrayList<>(Arrays.asList(4,3,1));
		//List<Integer> speed = new ArrayList<>(Arrays.asList(3,2,1));
		
		//List<Integer> startingPos = new ArrayList<>(Arrays.asList(4,3));
		//List<Integer> speed = new ArrayList<>(Arrays.asList(2,2));
		
		int[] intStartingPos = startingPos.stream().mapToInt(Integer::intValue).toArray();
		int[] intSpeed = speed.stream().mapToInt(Integer::intValue).toArray();


		int cnt = startingPos.size();
		int sec = 0;

		for (int i = 0; i < cnt; i++) {
			int attackCnt = 0;
			for (int j = 0; j < cnt; j++) {
				int nextValue = intStartingPos[j] - (intSpeed[j] * i);
				if (nextValue <= 0) {
					attackCnt++;
				}
				
				System.out.println("====== i:" + i + "  sec : " + sec + "  attackCnt : " + attackCnt +" nextValue : " + nextValue) ;
			}
			
			if ( attackCnt > sec) break;
			sec++;
		}
		System.out.println("sec :" + sec);
	}
}
