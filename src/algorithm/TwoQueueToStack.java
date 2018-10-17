package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueToStack {
	static Queue<Integer> Q1 = new LinkedList<Integer>();
	static Queue<Integer> Q2 = new LinkedList<Integer>();
	public static void main(String args[]) {

		push(24);
		push(34);
		push(4);
		push(10);
		push(1);
		push(43);
		push(21);
		System.out.println("Popped element is  " + pop());
		System.out.println("Popped element is  " + pop());
		System.out.println("Popped element is  " + pop());

	}

	public static void push(int data) {

		Q1.add(data);

	}

	public static int pop() {

		if (Q1.isEmpty()) {
			System.out.println("Cannot pop elements ,  Stack is Empty !!");
			return -1;
		} else {
			while (Q1.size() > 1) {
				Q2.add(Q1.poll());
			}
			int element = Q1.poll();
			Queue<Integer> temp = new LinkedList<Integer>();
			temp = Q1;
			Q1 = Q2;
			Q2 = temp;
			return element;
		}
	}
}
