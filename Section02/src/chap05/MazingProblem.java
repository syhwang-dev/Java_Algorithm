package chap05;

enum Directions {
	N, NE, E, SE, S, SW, W, NW
}

// 현재 위치
class Items {
	int x;
	int y;
	int dir;

	public Items(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}

class Offsets {
	int a;
	int b;

	public Offsets(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

public class MazingProblem {
	static Offsets[] moves = new Offsets[8];
	
	public static void path(int[][] maze, int[][] mark, int ix, int iy) {

		mark[1][1] = 1;
		StackOfMaze st = new StackOfMaze(50);
		
		Items temp = new Items(0, 0, 0);
		temp.x = 1; temp.y = 1; temp.dir = 2; // E:: 2
		mark[temp.x][temp.y] = 7;  // 미로 찾기 궤적: 7로 표시 - mark1
		st.push(temp);
		
		
		while (!st.isEmpty()) {  // stack not empty
			Items tmp = st.pop();
			int i = tmp.x;
			int j = tmp.y;
			int d = tmp.dir;
			mark[i][j] = 1;  // backtracking 궤적은 1로 표시
			
			
			while (d < 8) {  // moves forward
				int g = i + moves[d].a;
				int h = j + moves[d].b;
				if ((g == ix) && (h == iy)) { // reached exit
					st.push(new Items(i, j, d + 1));
					mark[g][h] = 7;  // mark2
					while(!st.isEmpty()) {
						Items result = st.pop();
						int rX = result.x;
						int rY = result.y;
						mark[rX][rY] = 7;  // mark3
					}
					System.out.println("exit");
					return;
				}
				if ((maze[g][h] == 0) && (mark[g][h] == 0)) { // new position
					mark[g][h] = 1;
					st.push(new Items(i, j, d + 1));
					i = g;
					j = h;
					d = 0;  
				} else {
					d++;
				}

			}
		}
		System.out.println("no path in maze");
	}
	
	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		// 12 x 15
		int input[][] = { 
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				
				
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 } };
		
		for (int ia = 0; ia < 8; ia++) {
			moves[ia] = new Offsets(0, 0);
		}
		
		// N, NE, E, SE, S, SW, W, NW
		moves[0].a = -1;
		moves[0].b = 0;
		moves[1].a = -1;
		moves[1].b = 1;
		moves[2].a = 0;
		moves[2].b = 1;
		moves[3].a = 1;
		moves[3].b = 1;
		moves[4].a = 1;
		moves[4].b = 0;
		moves[5].a = 1;
		moves[5].b = -1;
		moves[6].a = 0;
		moves[6].b = -1;
		moves[7].a = -1;
		moves[7].b = -1;
		
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				if ((i == 0) || (j == 0) || (i == 13) || (j == 16))
					maze[i][j] = 1;
				else {
					maze[i][j] = input[i - 1][j - 1];
				}
				mark[i][j] = 0;
			}
		}

		System.out.println("maze[12,15]::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("\nFirst mark::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(mark[i][j] + " ");
			}
			System.out.println();
		}

		path(maze, mark, 12, 15);
		System.out.println("\nCompleted mark::");
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 15; j++) {
				System.out.print(mark[i][j] + " ");
			}
			System.out.println();
		}
	}

}
