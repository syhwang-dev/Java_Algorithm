// 3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
// comparator 구현 실습

package section02.chap03_검색;

import java.util.Arrays;
import java.util.Random;

public class ch03_01_정수배열이진탐색 {
	// inputData
	static void inputData(int[] data) {
		Random rand = new Random(100);
		for (int i=0; i<data.length; i++) {
			data[i] = rand.nextInt(100);
		}
	}
	
	// showData
	static void showData(int[] data) {
		for (int i=0; i<data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}
	
	// swap
	static void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	
	// sortData
	static void sortData(int[] data) {
		for (int i=0; i<data.length; i++) {
			for (int j=i+1; j<data.length; j++) {
				if (data[i] > data[j]) {
					swap(data, i , j);
				}
			}
		}
	}
	
	// linearSearch
	static int linearSearch(int[] data, int key) {
		int n = data.length;  // n = 10
		int i = 0;  // 시작값
		
		while (i < n) {
			if (data[i] == key) return i;
			i++;
		}
		return -1;
	}
	
	// binarySearch
	static int binarySearch(int[] data, int key) {
		int n = data.length;
		int pl = 0;  // 검색 범위의 맨 앞 인덱스
		int pr = n - 1;  // 맨 끝 인덱스
		
		do {
			int pc = (pl + pr) / 2;  // 중앙 인덱스
			
			if (data[pc] == key) return pc;
			else if (data[pc] < key) pl = pc + 1;
			else pr = pc -1;
		} while (pl <= pr);
		return -1;
	}
	
	public static void main(String[] args) {
		int[] data = new int[10];
		
		inputData(data);
		showData(data);
		sortData(data);
		
		System.out.println();
		for (int num : data) {
			System.out.print(num + " ");
		}
		
		int key = 33;
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		
		key = 91;
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);
		System.out.println(idx);
		

	}

}
