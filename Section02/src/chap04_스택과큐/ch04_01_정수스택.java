package section02.chap04_스택과큐;

import java.util.Scanner;

import section01.ch04.IntStack.EmptyIntStackException;
import section01.ch04.IntStack.OverflowIntStackException;

class IntStack {
	private int[] stk;
	private int capacity;
	private int ptr;
	
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() { }
	}
	
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}
	
	// 생성자
	public IntStack(int maxlen) {
		ptr = 0;  // 데이터가 하나도 쌓여있지 않은 상태
		capacity = maxlen;
		try {
			stk = new int[capacity];  // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) {  // 생성할 수 없음
			capacity = 0;
		}
	}
	
	public int push(int x) throws OverflowIntStackException {
		if (ptr >= capacity) {  // 스택이 가득 참
			throw new OverflowIntStackException();
		} return stk[ptr++] = x;
	}
	
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0) {
			throw new EmptyIntStackException();
		} return stk[--ptr];
	}
	
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[ptr - 1];
	}
	
	public void clear() {
		ptr = 0;
	}
	
	public int indexOf(int x) {
		for (int i=ptr-1; i>=0; i--) {
			if (stk[i] == x) return i;
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return ptr <=0;
	}
	
	public void dump() {
		if (isEmpty())
			System.out.println("Stack이 비어있습니다.");
		else {
			for (int i=0; i<ptr; i++) {
				System.out.println(stk[i] + " ");
			}
			System.out.println();
		}
	}
	
	public int size() {
		return ptr;
	}
	
	public int getCapacity() {
		return capacity;
	}
}

public class ch04_01_정수스택 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack s = new IntStack(64);
		
		while (true) {
			System.out.println();
			System.out.printf("현재 데이터 개수 : %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push (2)pop (3)peek (4)dump (5)indexOf (6)clear (0)종료: ");
			
			int menu = stdIn.nextInt();
			if (menu == 0) break;
			
			int x;
			switch (menu) {
			
			case 1:
				System.out.print("데이터: ");
				x = stdIn.nextInt();
				try {
					s.push(x);
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
				
			case 2:
			}
		}

	}

}
