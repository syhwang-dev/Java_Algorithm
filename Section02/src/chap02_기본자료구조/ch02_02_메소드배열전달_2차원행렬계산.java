// Matrix

package section02.chap02_기본자료구조;

import java.util.Random;

public class ch02_02_메소드배열전달_2차원행렬계산 {
	
	// getData 만들기
	static void getData(int[][] arr) {
		Random rand = new Random(100);
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[0].length; j++) {
				arr[i][j] = rand.nextInt(5);
			}
		}
	}
	
	// showData 만들기
	static void showData(int[][] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}
	}
	
	// addMatrix 만들기
	static void addMatrix(int[][] A, int[][] A1, int[][] A2) {
		for (int i=0; i<A.length; i++) {
			for (int j=0; j<A1.length; j++) {
				A2[i][j] = A[i][j] + A1[i][j];
			}
		}
	}
	
	// multiplyMatrix 만들기
	private static void multiplyMatrix(int[][] A, int[][] B, int[][] C) {
		for (int i=0; i<A.length; i++) {
			for (int j=0; j<B.length; j++) {
				for (int k=0; k<A[0].length; k++) {
					C[i][j] += A[i][k] * B[k][j]; 
				}
			}
		}
	}
	
	// 전치행렬
	static void transposeMatrix(int[][] A, int[][] D) {
		for (int i=0; i<A.length; i++) {
			for (int j=0; j<A[0].length; j++) {
				D[j][i] = A[i][j];
			}
		}
	}
	
	public static void main(String[] args) {
		// 행렬 선언
		int[][] A = new int[2][3];
		getData(A);
		showData(A);
		System.out.println();
		
		int[][] A1 = new int[2][3];
		getData(A1);
		showData(A1);
		System.out.println();
		
		int[][] A2 = new int[2][3];
		// 행렬 덧셈
		addMatrix(A, A1, A2);
		showData(A2);
		System.out.println();
		
		int[][] B = new int[3][4];
		getData(B);
		showData(B);
		System.out.println();
		
		int[][] C = new int[2][4];
		// 행렬 곱셈
		multiplyMatrix(A, B, C);
		showData(C);
		System.out.println();
		
		int[][] D = new int[3][2];
		// 전치행렬
		transposeMatrix(A, D);
		showData(D);
	}

}




