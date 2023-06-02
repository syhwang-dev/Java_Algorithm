package chap05;

import java.util.ArrayList;
import java.util.List;

class ObjectStack {
	private List<Point> data; // 스택용 배열
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

	public ObjectStack(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<>(capacity);
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

public class Test {

	public static void SolveQueen(int[][] d) {
 		int count = 0;
		int ix = 0, iy = 0;
		ObjectStack st = new ObjectStack(10);
		Point p = new Point(ix, iy);
		d[ix][iy] = 1;
		count++;
		st.push(p);
		while (count < d.length) {
			ix++;
			int cy = NextMove(d, ix, 0);
			while (ix < d.length) {
				if (cy < d[0].length) {
					Point px = new Point(ix, cy);
					st.push(px);
					d[ix][cy] = 1;
					count++;
				}
				if (cy != d[0].length) {
					break;
				} else {
					p = st.pop();
					d[ix][iy] = 0;
					count--;
					ix =
					cy = NextMove(d, ix, p.getY() + 1);
				}
			}
		}
	}

	public static boolean checkRow(int[][] d, int crow) {
		for (int i = 0; i < d.length; i++) {
			if (d[crow][i] == 1)
				return false;
		}
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) {
		for (int i = 0; i < d[0].length; i++) {
			if (d[i][ccol] == 1)
				return false;
		}
		return true;
	}

	// x++, y-- or x--, y++ where 0 <= x,y <= 7
	public static boolean checkDiagSW(int[][] d, int cx, int cy) {
		while (cx < d.length - 1 && cy > 0) {
			cx++;
			cy--;
			if (d[cx][cy] == 1)
				return false;
		}
		while (cx > 0 && cy < d[0].length - 1) {
			cx--;
			cy++;
			if (d[cx][cy] == 1)
				return false;
		}
		return true;
	}

	// x++, y++ or x--, y--
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {
		while (cx < d.length - 1 && cy < d[0].length - 1) {
			cx++;
			cy++;
			if (d[cx][cy] == 1)
				return false;
		}
		while (cx > 0 && cy > 0) {
			cx--;
			cy--;
			if (d[cx][cy] == 1)
				return false;
		}
		return true;
	}

	// (x,y)로 이동 가능한지를 check
	public static boolean CheckMove(int[][] d, int x, int y) {
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y))
			return true;
		return false;
	}

	// 다음 row에 대하여 이동할 col을 조사
	public static int NextMove(int[][] d, int row, int col) {
		while (col < d[0].length) {
			if (CheckMove(d, row, col))
				return col;
			col++;
		}
		return d[0].length;
	}

	public static void main(String[] args) {
		int[][] data = new int[8][8];

		SolveQueen(data);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
	}

}