// ObjectArray
// 과제1_2장기본자료구조

package section02.chap02_기본자료구조;

class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;
	
	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	public String toString() {
		return name + " " + height + " " + vision + "\n"; 
	}

	@Override
	public int compareTo(PhyscData o) {
		int result = name.compareTo(o.name);
		if(result == 0) {
			result = height - o.height;
			if (result == 0) {
				double d = vision - o.vision;
				if (d == 0) return 0;  
				else if (d > 0) return 1; 
				else return -1;
			}
		}
		return result;
	}	
}

public class ch02_04_객체정렬 {
	
	// showData
	static void showData(PhyscData[] data) {
		for(int i=0; i<data.length; i++) {
//			System.out.print(data[i] + " ");
			System.out.print(data[i]);
		}
	}
	
	// swap
	static void swap(PhyscData[] data, int i, int j) {
		PhyscData temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	// sortData
	static void sortData(PhyscData[] data) {
		for(int i = 0; i < data.length; i++)
			for(int j = i+1; j < data.length; j++) 
				// if (data[i] > data[j]) {  // 정수가 아니기 때문에 에러
				if (data[i].compareTo(data[j]) > 0) {
					swap(data, i, j);
				}
	}

	public static void main(String[] args) {
		PhyscData[] data = {   
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2),
				new PhyscData("최길동", 169, 0.5),
		};
		
		showData(data);
		sortData(data);
		System.out.println("\n정렬 후 결과 > ");
		showData(data);
		

	}

	
}

// https://cwondev.tistory.com/15
// https://webstudynote.tistory.com/136
