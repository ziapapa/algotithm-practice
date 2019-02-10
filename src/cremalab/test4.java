package cremalab;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class test4 {
	/*
	 * n = 4 time = [0, 0, 1, 5] direction = [0, 1, 1, 0]
	 * 
	 * 2, 0, 1, 5
	 * 
	 * 
	 * 
	 * n = 5 time = [0, 1, 1, 3, 3] direction = [0, 1, 0, 0, 1]
	 * 
	 * 0, 2, 1, 4, 3
	 */

	public static void main(String[] args) {

		//List<Integer> time      = new ArrayList<>(Arrays.asList(0, 0, 1, 5));
		//List<Integer> direction = new ArrayList<>(Arrays.asList(0, 1, 1, 0));
		List<Integer> time      = new ArrayList<>(Arrays.asList(1));
		List<Integer> direction = new ArrayList<>(Arrays.asList(0));

		List<Integer> result = getTimes(time, direction);

		System.out.println(result.stream().map(Object::toString).collect(joining("\n")) + "\n");
	}

	// Convert prefix to Postfix expression
	static List<Integer> getTimes(List<Integer> time, List<Integer> direction) {

		List<Integer> times = time;
		List<Integer> directions = direction;

		int arraySize = times.size();
		int timeMax = Collections.max(times);
		int loopCnt = timeMax > arraySize ? timeMax : arraySize;
		List<Integer> list = new ArrayList<Integer>(Collections.nCopies(arraySize, 0));

		int turnstileDirection = 1; // default - leave
		// HashMap<Integer, Integer> leftMap = new HashMap<>();
		// HashMap<Integer, Integer> rightMap = new HashMap<>();
		LinkedList<ArrayList<Integer>> templist = new LinkedList<>();

		for (int personTime = 0; personTime <= loopCnt; personTime++) {
			System.out.println("personTime : " + personTime);
			Integer index = 0;
			for (Integer value : times) {
				System.out.println("value : " + value);
				if (personTime == value) {
					System.out.println(directions.get(index) + " / " + index);

					templist.addLast(new ArrayList<>(Arrays.asList(directions.get(index), index)));
					System.out.println("templist.size() : " + templist.size());
					if (templist.size() == 2)
						break;
				}
				index++;
			}

			System.out.println(templist.peekFirst());
			System.out.println(templist.peekLast());

			if (!templist.isEmpty()) {

				if (templist.size() == 1) {
					int onlyIndex = templist.getFirst().get(1);
					list.set(onlyIndex, personTime);
					System.out.println("onlyIndex, personTime : " + onlyIndex + "," + personTime);
					turnstileDirection = templist.getFirst().get(0);
					templist.pollFirst();
				} else if (turnstileDirection == templist.getFirst().get(0)) {
					int firstIndex = templist.getFirst().get(1);
					list.set(firstIndex, personTime);
					System.out.println("firstIndex, personTime : " + firstIndex + "," + personTime);
					templist.pollFirst();
				} else if (turnstileDirection == templist.getLast().get(0)) {
					int LastIndex = templist.getLast().get(1);
					list.set(LastIndex, personTime);
					System.out.println("LastIndex, personTime : " + LastIndex + "," + personTime);
					templist.pollLast();
				}
			}
		}
		return list;
	}
}
