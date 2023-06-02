package section02.chap04_스택과큐;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class ObjectStack {
	// 배열을 사용하지 않고 list 사용
	private List<Point> data;  // 스택용 배열
	private int capacity;  // 스택의 크기
	private int top;  // 스택 포인터
	
	public class EmptyGenericStackException extends RuntimeException {
		public EmptyGenericStackException() {
		}
	}
	
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException() {
		}
	}
	
	// 셍성자
	public ObjectStack(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<Point>();  // 스택 본체용 배열 생성
//			data = new ArrayList<>(capacity);
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	
	public int push(Point x) throws OverflowGenericStackException {  // stack에 x를 push
		if (top >= capacity) {  // 스택이 가득찼을 때
			throw new OverflowGenericStackException();
		}
		data.add(x);
		top++;
		return 1;
	}
	
//	public Point push(Point p) throws OverflowGenericStackException {
//		if (top >= capacity) {
//			throw new OverflowGenericStackException();
//		}
//		data.add(p);
//		return data.get(top++);
//	}
	
	public Point pop() throws EmptyGenericStackException {
		if (top <= 0) {
			throw new EmptyGenericStackException();
		}
//		Point p = data.remove(--top);  // 정수일 때만 가능?
		Point p = data.remove(top - 1);
		return p;
	}
	
	// 최상위 값 확인
	public Point peek() throws EmptyGenericStackException {
		if (top <= 0) {
//		if (data.equals(0))  // object형 객체를 비교할 때 사용
			throw new EmptyGenericStackException();
		}
//		Point p = data.get(top - 1);
//		return p;
		return data.get(top - 1);
	}
	
	public void clear() {
		top = 0;
	}
	
	// 왜 위에서부터?
	// 스택의 위에서부터 검색해 인덱스를 반환
	public int indexOf(Point x) {
		for (int i=top-1; i>=0; i--) {  
			if (data.get(i).equals(x)) return i;
		}
		return -1;  // 검색이 안 될 경우
	}
	
	// top이 0과 같다면 false 아닌가?
	public boolean isEmpty() {
		return top <= 0;
	}
	
	public void dump() {
		if (isEmpty()) {
//		if (top <= 0) { 
			System.out.println("Stack이 비어있습니다.");
		}
		else {
			for (int i=0; i<top; i++) {
				System.out.println(data.get(i) + " ");  // 스택정수에서는 print
			}
		}
	}
	
	public int size() {
		return top;
	}
	
	public int getCapacity() {
		return capacity;
	}
}

class Point {
	private int ix;
	private int iy;
	
	public Point(int ix, int iy) {
		this.ix = ix;
		this.iy = iy;
	}
	
	@Override
	public boolean equals(Object p) {  // Object p와 Point px를 비교?
		Point px = (Point)p;
		if (this.ix == px.ix && this.iy == px.iy) return true;
		return false;
	}
	
	@Override
	public String toString() {
//		return this.hashCode() + " : ix = " + ix + ", iy = " + iy;
		return "("+ix+", "+iy+")" ;
	}
}

public class 스택객체 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		ObjectStack s = new ObjectStack(8);  // 최대 8개를 push 할 수 있는 Stack
		Random rand = new Random();
		
		int randx = 0, randy = 0;
		Point p = null;  // p 변수 초기화
		
		while (true) {
			System.out.println();  // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push (2)pop (3)peek (4)dump (5)indexOf (6)clear (0)Exit: ");
			
			int menu = stdIn.nextInt();
			if (menu == 0) break;
			
			switch (menu) {
			case 1:  // push
				System.out.println("랜덤 데이터가 입력되었습니다.");
//				randx = random.nextInt() % 20;
				randx = rand.nextInt(20);
				randy = rand.nextInt(20);
				p = new Point(randx, randy);
				try {
					s.push(p);
				} catch (ObjectStack.OverflowGenericStackException e) {
					System.out.println("Stack이 가득 찼습니다.");
				}
				break;
			
			case 2:  // pop
				try {
					p = s.pop();
					System.out.println("pop한 데이터는 " + p + "입니다.");
				} catch (ObjectStack.EmptyGenericStackException e) {
					System.out.println("Stack이 비어있습니다.");
				}
				break;
			
			case 3:  // peek
				try {
					p = s.peek();
					System.out.println("peek한 데이터는 " + p + "입니다.");
				} catch (ObjectStack.EmptyGenericStackException e) {
					System.out.println("Stack이 비어있습니다.");
				}
				break;

			case 4:  // dump
				s.dump();
				break;

			// 어떤 값을 넣어야...?
			case 5:  // indexOf
				System.out.println("데이터: ");
				randx = stdIn.nextInt();
				randy = stdIn.nextInt();
				p = new Point(randx, randy);
				
				int result = s.indexOf(p);
				System.out.println("입력한 데이터의 인덱스는 " + result + "입니다.");
				break;
			
			case 6:  // clear
				s.clear();
				break;
			}
		}
		stdIn.close();
	}
	
}
