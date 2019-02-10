package cremalab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test2_1 {

	public static void main(String[] args) {

		List<Integer> startingPos = new ArrayList<>(Arrays.asList(4, 15, 15, 12, 18, 3, 8));
		List<Integer> speed = new ArrayList<>(Arrays.asList(2,5,3,2,3,3,2));
		//List<Integer> startingPos = new ArrayList<>(Arrays.asList(4,3,1));
		//List<Integer> speed = new ArrayList<>(Arrays.asList(3,2,1));

		int cnt = startingPos.size();
		int sec = 0;
		
		for (int i = 0 ; i < cnt ; i++) {
			System.out.println("====== i:" + i);
			listAddSpeed(startingPos, speed);
			if (!listMinRemove(startingPos, speed)) break; 
			sec++;
			System.out.println("sec :" + sec + "  startingPos size :" + startingPos.size());
		}
		System.out.println("sec :" + sec);
	}
	
	static boolean listMinRemove(List<Integer> startingPos, List<Integer> speed) {
		Integer min = Collections.min(startingPos);
		System.out.println("min:" + min);
		if ( min < 0 ) {
			return false; 
		} else {
			int index = startingPos.indexOf(min);
			//System.out.println(index);
			startingPos.remove(index);
			speed.remove(index);
			return true;
		}
	}
	
	static void listAddSpeed(List<Integer> startingPos, List<Integer> speed) {
		int cnt = startingPos.size();
		for (int j = 0 ; j < cnt ; j++) {
			//System.out.println("startingPos.get(" + j + ") " + startingPos.get(j));
			startingPos.set(j, startingPos.get(j) - speed.get(j));
			System.out.println("startingPos.get(" + j + ") " + startingPos.get(j));
		}
	}
	
}
