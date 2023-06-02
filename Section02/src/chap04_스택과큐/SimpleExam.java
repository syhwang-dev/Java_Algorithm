package section02.chap04_스택과큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class IntStk {
	int max;
	int ptr;
	int[] stk;
}
public class SimpleExam {

	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		stack.push("0");
		stack.push("1");
		stack.push("2");
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer("3");
		queue.offer("4");
		queue.offer("5");
		
		System.out.println("Stack: Start");
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
		System.out.println("Stack: Empty\n");
		
		System.out.println("Queue: Start");
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		System.out.println("Queue: Empty");
		
	}

}

