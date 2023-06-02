// 5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현

package section02.chap03_검색;

import java.util.Arrays;

class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;
	
	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	public String toString() {
		return name + " " + height + " " + vision + "\t";
	}
	
	@Override
	public int compareTo(PhyscData o) {
		int result = this.name.compareTo(o.name);
		if(result == 0) {
			result = this.height - o.height;
			if(result == 0) {
				double d = this.vision - o.vision;
				if(d == 0) return 0;
				else if (d > 0) return 1;
				else return -1;
			}
		}
		return result;
	}
	
//	@Override
//	public int compareTo(PhyscData pd) {
////		return this.name.compareTo(pd.name);
//		int result = this.name.compareTo(pd.name);
//		if (result == 0) {
//			int hresult = this.height - pd.height;
//			if (hresult == 0) {
//				return (int)(this.vision - pd.height);
//			}
//			else return hresult;
//		}
//		return result;
//	}
}

public class ch03_03_객체배열이진탐색 {
	// showData
	static void showData(PhyscData[]arr) {
//		System.out.println();
		for (PhyscData fruit: arr) {
			System.out.print(fruit+" ");
		}
		System.out.println();
	}
	
	// swap
	static void swap(PhyscData []data, int i, int j) {
		PhyscData temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	// sortData
	static void sortData(PhyscData []data) {
		for(int i = 0; i < data.length; i++)
			for(int j = i+1; j < data.length; j++) 
				if (data[i].compareTo(data[j]) > 0) {
					swap(data, i, j);
				}
	}
	
	// linearSearch
	static int linearSearch(PhyscData[] data, PhyscData key) {
		int n = data.length;
		int i = 0;
		
		while(i < n) {
			if(data[i].compareTo(key) == 0) return i;
			i++;
		}
		
		return -1;
	}
	
	// binarySearch
	static int binarySearch(PhyscData[] data, PhyscData key) {
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
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2),
				new PhyscData("길동", 167, 0.5),
		};

		showData(data);
		sortData(data);
		showData(data);
		
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		
		key = new PhyscData("길동", 167, 0.5);	
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);
	}

}
