package algorithm;

import java.util.Stack;

public class TwoStackToQueue {

    private Stack inBox = new Stack();
    private Stack outBox = new Stack();

    public void enQueue(Object item) {
        inBox.add(item);
    }

    public Object deQueue() {

        if (outBox.isEmpty()) {
            while(!inBox.isEmpty()) {
                outBox.push(inBox.pop());
            }
        }
        return outBox.pop();
    }

    public static void main(String[] args) {
    	TwoStackToQueue queue = new TwoStackToQueue();
        queue.enQueue("A");
        queue.enQueue("B");
        queue.enQueue("C");

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }

}
