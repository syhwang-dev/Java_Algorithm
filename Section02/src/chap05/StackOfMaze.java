package chap05;

import java.util.ArrayList;
import java.util.List;

public class StackOfMaze {
	private List<Items> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	public class EmptyGenericStackException extends RuntimeException {
		public EmptyGenericStackException() {

		}
	}

	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException() {
		}
	}

	public StackOfMaze(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<>(capacity);
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	public Items push(Items p) throws OverflowGenericStackException {
		if (top >= capacity)
			throw new OverflowGenericStackException();
		data.add(p);
		return data.get(top++);
	}

	public Items pop() throws EmptyGenericStackException {
		if (top <= 0)
			throw new EmptyGenericStackException();
		Items p = data.remove(--top);
		return p;
	}

	public Items peek() throws EmptyGenericStackException {
		if (top <= 0)
			throw new EmptyGenericStackException();
		return data.get(top - 1);
	}

	public void clear() {
		top = 0;
	}

	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--) {
			if (data.get(i).equals(x))
				return i;
		}
		return -1;
	}

	public boolean isEmpty() {
		return top <= 0;
	}

	public void dump() {
		if (isEmpty())
			System.out.println("stack이 비어있습니다.");
		else {
			for (int i = 0; i < top; i++) {
				System.out.println(data.get(i) + " ");
			}
			System.out.println();
		}
	}
	
	public int size() {
		return top;
	}
	
	public int getCapacity() {
		return capacity;
	}
}
