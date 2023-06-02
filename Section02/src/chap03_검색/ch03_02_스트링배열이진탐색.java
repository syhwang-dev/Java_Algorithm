package section02.chap03_검색;

import java.util.Arrays;

public class ch03_02_스트링배열이진탐색 {
	// showData
	static void showData(String[] data) {
		for (int i=0; i<data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}
	
	// swap
	static void swap(String[] data, int i, int j) {
		String tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
	// sortData
	static void sortData(String[] data) {
		for (int i=0; i<data.length; i++) {
			for (int j=i+1; j<data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					swap(data, i, j);
				}
			}
		}
	}
	
	// linearSearch
	static int linearSearch(String[] data, String key) {
		int n = data.length;
		int i = 0;
		
		while (i < n) {
//			if (data[i] == key) return i;
			if (data[i].compareTo(key) == 0) return i;
			i++;
		}
		return -1;
	}
	
	// binarySearch
	static int binarySearch(String[] data, String key) {
		int n = data.length;
		int pl = 0;
		int pr = n - 1;
		
		do {
			int pc = (pl + pr) / 2;
			
			if (data[pc].compareTo(key) == 0) {
				System.out.println(pc + "번 위치에 있습니다.");
				return pc;
			}
			else if (data[pc].compareTo(key) < 0) pl = pc + 1;
			else pr = pc - 1;
		} while (pl <= pr);
		return -1;
	}
	
	public static void main(String[] args) {
		String[] data = {"apple","grape","persimmon", "감", "배", "사과", "포도", "pear","blueberry", "strawberry", "melon", "oriental_melon"};
	
		showData(data);
		System.out.println();
		sortData(data);
		showData(data);
		System.out.println();
		
		String key = "감";
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		
		key = "배";
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);
		
	}
}
