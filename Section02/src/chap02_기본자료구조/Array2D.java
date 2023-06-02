package section01;

public class Array2D {

	public static void main(String[] args) {
		Array2D a = new Array2D();
		
		// 2차원 배열의 크기가 같은 경우
		int[][] grid = new int[3][4];  // grid 라는 이차원 배열을 생성함.
		
		System.out.println("------ 0으로 초기화 ------");
		a.print(grid);  // 출력된 값을 보면 초기화가 0으로 되어있음.
		System.out.println();
		
		System.out.println("------ [0][1] = 10 ------");
//		grid[0] = 10;  // Type mismatch: cannot convert from int to int[]
		grid[0][1] = 10;
		a.print(grid);
		System.out.println();
		
		// 2차원 배열의 크기가 다른 경우
		int[][] grid2 = new int[3][];  // grid2 라는 이차원 배열 생성
		grid2[0] = new int[1];
		grid2[1] = new int[2];
		grid2[2] = new int[7];
		
		System.out.println("------ 배열의 크기가 다름. ------");
		a.print(grid2);
		System.out.println();
		
		// 가장 많이 쓰는 방법 - 값을 직접 입력
		int[][] grid3 = {{1, 2},
						{2, 3},
						{3, 5}};
		System.out.println("------ 가장 많이 쓰는 방법 ------");
		a.print(grid3);
		
		
		

	}
	// print 메소드
	public void print(int[][] grid) {
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				System.out.print("["+i+"]["+j+"]"+grid[i][j]+" ");
			}
			System.out.println();
		}
	}

}
