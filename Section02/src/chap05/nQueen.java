package chap05;

import java.util.ArrayList;
import java.util.List;

// Stack 클래스
class Stack {
	private List<Point> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터
	
	public class EmptyGenericStackException extends RuntimeException {
		public EmptyGenericStackException() { }
	}

	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException() { }
	}
	
	public Stack(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<Point>();
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	public Point push(Point p) throws OverflowGenericStackException {
		if (top >= capacity)
			throw new OverflowGenericStackException();
		data.add(p);
		return data.get(top++);
	}

	public Point pop() throws EmptyGenericStackException {
		if (top <= 0)
			throw new EmptyGenericStackException();
		Point p = data.remove(--top);
		return p;
	}

	public Point peek() throws EmptyGenericStackException {
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


// Point 클래스
class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object p) {
		Point px = (Point)p;
		if(this.x == px.x && this.y == px.y) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
//		return this.hashCode() + " : x = " + x + ", y = " + y;
		return "x = " + x + ", y = " + y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}


public class nQueen {
	static final int numberQueens = 4;
	
	public static void SolveQueen(int[][] d) {
		int count = 0, mode = 0;
		int ix = 0, iy = 0;
		Stack st = new Stack(10);  // 10?
		Point p = new Point(ix, iy);  
		d[ix][iy] = 1; count++;
		st.push(p);  // Point 객체를 Stack에 넣음.
		
//		Point px = null;  // px 초기화
		
		while (count < numberQueens) { 
			ix++;
			int cy = 0;
			while (ix < d[0].length) {
				cy = nextMove(d, ix, cy);
				while (cy < d.length) {  // cy가 -1이 아니면~
					if (cy != -1) { 
					
						Point px = new Point(ix, cy);
						st.push(px);
						count++;
	//					st.dump();
						d[ix][cy] = 1;
						break;
					}
					cy++;
				}
//				if (cy != -1) {  // cy가 마지막까지 갔으면
				if (cy != d[0].length) {
					break;
				} else {  // cy가 마지막까지 안 갔으면
				 p = st.pop(); count--;
				 d[ix][iy] = 0;
				 
				 ix = p.getX();
//				 iy = p.getY();
				 
				 cy = iy + 1;
				}
			}
		}
	}
	
	public static boolean checkRow(int[][] d, int crow) {
		// 배열 d에서 crow에 Queen을 놓을 수 있으냐?
		for (int j=0; j<d.length; j++) {
			if (d[crow][j] == 1) return false;
		}
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) {
		// 배열 d에 ccol 열에 배치할 수 있느냐? 있다면 return true
		for (int j=0; j<numberQueens; j++) {
			if (d[j][ccol] == 1) return false;
		}
		return true;
	}
	
	public static boolean checkDiagSW(int[][] d, int x, int y) { //x++, y-- or x--, y++ where 0<= x,y <= 7
		// 배열 d에 d[cx][cy]의 SW 대각선에 배치 가능하냐?
		// for문이 아닌 while문 사용
		int cx = x, cy = y;
		while(cx>=0 && cx < numberQueens && cy>=0 & cy < numberQueens) {
			cx++; cy--;
			if (cx>=0 && cx < numberQueens && cy>=0 & cy < numberQueens)
				if (d[cx][cy] == 1) 
					return false;
				else break;  // while문 나가고 아랫줄
		}
		
		cx = x; cy = y;
		while(cx>=0 && cx < numberQueens && cy>=0 & cy < numberQueens) {
			cx--; cy++;
			if (cx>=0 && cx < numberQueens && cy>=0 & cy < numberQueens)
				if (d[cx][cy] == 1) return false;
				else break;
		}
		return true;
	}
	
	public static boolean checkDiagSE(int[][] d, int x, int y) {//x++, y++ or x--, y--
		int cx = x, cy = y;
		while(cx>=0 && cx < numberQueens && cy>=0 & cy < numberQueens) {
			cx++; cy++;
			if (cx>=0 && cx < numberQueens && cy>=0 & cy < numberQueens)
				if (d[cx][cy] == 1) return false;
			else break;
		}
		
		cx = x; cy = y;
		while(cx>=0 && cx < numberQueens && cy>=0 && cx < numberQueens) {
			cx--; cy--;
			if (cx>=0 && cx < numberQueens && cy>=0 & cy < numberQueens)
				if (d[cx][cy] == 1) return false;
				else break;
		}
		return true;
	}
	
    public static boolean checkMove(int[][] d, int x, int y) {//(x,y)로 이동 가능한지를 check
    	if (checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y))
    		return true;
    	else
    		return false;
    }
    public static int nextMove(int[][] d, int row, int newCol) {//다음 row에 대하여 이동할 col을 조사
    	for (int col=0; col<d.length; col++) {
    		if (checkMove(d, row, col))
    			return col;
    	}
    	return -1;
    }

	public static void main(String[] args) {
		int row = numberQueens, col = numberQueens;  // 체스판
		int[][] data = new int[numberQueens][numberQueens];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		SolveQueen(data);
		

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}

		
	}
}
