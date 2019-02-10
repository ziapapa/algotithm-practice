package cremalab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test2 {

	public static void main(String[] args) {

		List<Integer> startingPos = new ArrayList<>(Arrays.asList(4, 15, 15, 12, 18, 3, 8));
		List<Integer> speed = new ArrayList<>(Arrays.asList(2,5,3,2,3,3,2));
		//List<Integer> startingPos = new ArrayList<>(Arrays.asList(4,3,1));
		//List<Integer> speed = new ArrayList<>(Arrays.asList(3,2,1));
		
		List<Integer> nextPos = new ArrayList<>();
		nextPos.addAll(startingPos);

		int cnt = startingPos.size();
		int sec = 0;
		
		for (int i = 0 ; i < cnt ; i++) {
			System.out.println("====== i:" + i);
			if(!listMinusSpeed(startingPos, speed, nextPos)) break;
			listMinRemove(startingPos, speed, nextPos); 
			sec++;
			System.out.println("sec :" + sec + "  startingPos size :" + startingPos.size());
		}
		System.out.println("sec :" + sec);
	}
	
	static void listMinRemove(List<Integer> startingPos, List<Integer> speed, List<Integer> nextPos) {
		Integer min = Collections.min(nextPos);
		int index = nextPos.indexOf(min);
		System.out.println("min:" + min + " index:"+ index);
		startingPos.remove(index);
		nextPos.remove(index);
		speed.remove(index);
	}
	
	static boolean listMinusSpeed(List<Integer> startingPos, List<Integer> speed, List<Integer> nextPos) {
		int cnt = startingPos.size();
		startingPos = nextPos;
		
		Integer min = Collections.min(startingPos);
		if (min <= 0) {
			return false;
		} else {
			for (int j = 0 ; j < cnt ; j++) {
				//System.out.println("startingPos.get(" + j + ") " + startingPos.get(j));
				nextPos.set(j, nextPos.get(j) - speed.get(j));
				System.out.println("nextPos.get(" + j + ") " + nextPos.get(j));
			}
		}
		return true;
	}
}
