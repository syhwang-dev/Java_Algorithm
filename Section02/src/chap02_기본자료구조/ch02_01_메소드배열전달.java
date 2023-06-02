// Array

// 1. 난수 생성
// 2. 정렬
// 3. 행렬 덧셈/곱셈 - 알고리즘02_행렬계산.java

package chap02_기본자료구조;

import java.util.Random;

public class ch02_01_메소드배열전달 {
	// Step03. getData 만들기
	static void getData(int[] items) {
		// Step05. 난수 생성하여 배열에 입력
		Random rand = new Random(100);  // seed를 100으로 설정 → seed 값이 설정되어 있으면 다시 실행해도 같은 랜덤 값이 출력됨. 
		for(int i=0; i<items.length; i++) {
			items[i] = rand.nextInt(10);
			// System.out.println(items[i]);  // 랜덤 값 출력 테스트
		}
		// System.out.println(items);  // 왜 생성된 랜덤 값이 안 나오지?
	}
	
	// Step04. showData 만들기
	static void showData(int[] items) {
		// Step06. 배열에 생성된 난수 출력
		for(int i=0; i<items.length; i++) {
			System.out.print(items[i] + " ");
		}
	}
	
	// Step08. findMax 만들기 - 반환값 없는 코드도 가능함.
	// static void findMax(int[] items) {  // Type mismatch: cannot convert from void to int
	static int findMax(int[] items) {
		int max = 0;
		for (int i=0; i<items.length; i++) {
			if (max < items[i]) max = items[i];
		}
		return max;
	}
	
	// 다른 방법
//	static int findMax(int[] items) {
//		int max = items[0];
//		for (int i=1; i<items.length; i++) {
//			if (max < items[i]) max = items[i];
//		}
//		return max;
//	}
	
	// Step11. swap 만들기
	static void swap(int[] data, int i, int j ) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	// Step10. sortData 만들기
	static void sortData(int[] data) {
		// 반복문으로 데이터 비교
		for(int i=0; i<data.length; i++) 
			for(int j=i+1; j<data.length; j++)  // i가 1이면 j는 i+1이므로 2
				if(data[i] > data[j]) {
					swap(data, i, j);
				}
	}

	public static void main(String[] args) {
		// Step01. 배열 생성
		int[] data = new int[10];
		
		// Step02. getData와 showData 생성 → 생성 후 main문 위로 이동
		getData(data);
		showData(data);
		
		// Step07. 생성된 랜덤 값 중 최댓값 찾기
		int maxValue = findMax(data);
		System.out.println("\nMax: " + maxValue);
		// 또는
		// System.out.println();
		// System.out.println("Max: " + maxValue);
		
		// Step09. 오름차순으로 정렬하기
		sortData(data);
		System.out.println("정렬 후 결과: ");
		showData(data);
	}
}
