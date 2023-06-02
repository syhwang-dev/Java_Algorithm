// ObjectArray
// 과제1_2장기본자료구조

package section02.chap02_기본자료구조;

class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;
	
	public PhyscData2(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	public String toString() {
		return name + " " + height + " " + vision; 
	}
	
	@Override
	public int compareTo(PhyscData2 o) {
		if (this.name.compareTo(o.name) == 0) {
			if (this.height == o.height) {
				return (int) (this.vision - o.vision);
			} else { return this.height - o.height; }
		} else { return this.name.compareTo(o.name); }
	}
	
	// showData
	public static void showData(PhyscData2[] arr) {
		for (PhyscData2 obj : arr) {
			System.out.println("name: " + obj.name + ", height: " + obj.height + ", vision: " + obj.vision);
		}
	}
	
	// swap
	static void swap(PhyscData2[] data, int i, int j) {
		PhyscData2 temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	// sortData
	static void sortData(PhyscData2[] data) {
		for(int i = 0; i < data.length; i++) {
			for(int j = i+1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					swap(data, i, j);
				}
			} 
		}
	}
}

public class ch02_05_객체정렬2 {
	public static void main(String[] args) {
		PhyscData2[] data = {   
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("홍동", 164, 1.3),
				new PhyscData2("홍길", 152, 0.7),
				new PhyscData2("김홍길동", 172, 0.3),
				new PhyscData2("이길동", 182, 0.6),
				new PhyscData2("박길동", 167, 0.2),
				new PhyscData2("최길동", 169, 0.5),
		};
		
		PhyscData2.showData(data);
		PhyscData2.sortData(data);
		System.out.println("\n정렬 후 결과 > ");
		PhyscData2.showData(data);
		

	}

	
}

// https://cwondev.tistory.com/15
// https://webstudynote.tistory.com/136
