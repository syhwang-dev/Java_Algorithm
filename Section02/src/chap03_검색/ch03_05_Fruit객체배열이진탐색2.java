package section02.chap03_검색;

//3장 객체 배열 정렬 - binary search
/*
* Comparator를 사용하는 방법
* MyComparator implements Comparator<>
* MyComparator myComparator = new MyComparator();
* Arrays.sort(array, myComparator);
* Collections.sort(list, myComparator);
*/

import java.util.Arrays;
import java.util.Comparator;

class Fruit2 {
	String name;
	int price;
	String expire;
	
//	public static final Comparator<Fruit> class_cc =
//			new ComparatorFruit();
//			
//    private static class ComparatorFruit implements Comparator<Fruit>() {  // cc_expire는 변수이며 객체를 가지고 있음.
//		@Override
//		public int compare(Fruit f1, Fruit f2) {
//			// return (f1.expire - f2.expire);  // 불가능
//			return (f1.expire.compareTo(f2.expire));
//		}
//    };
    
	
	// main에 있을 때와 비교하기
	// 앞에 static이 붙음. static - 오직 하나의 변수만 있는 것
//    private static Comparator<Fruit> cc_expire = new Comparator<Fruit>() {  // cc_expire는 변수이며 객체를 가지고 있음.
//		@Override
//		public int compare(Fruit f1, Fruit f2) {
//			// return (f1.expire - f2.expire);  // 불가능
//			return (f1.expire.compareTo(f2.expire));
//		}
//    };

	public Fruit2(String name, int price, String expire) {
		this.name = name;
		this.price = price;
		this.expire = expire;
	};
	
	public String toString() {
		return name + " " + price + " " + expire + "\t";
	}

//	@Override
//	public int compare(Fruit f1, Fruit f2) {
//		int result = compare(f1.name, f2.name);
//		return 0;
//	};

	public int getPrice() { return price; };
	public String getName() { return name; };
	public String getExpire() { return expire; }
}


public class ch03_05_Fruit객체배열이진탐색2 {

	public static void main(String[] args) {
		Fruit[] arr = {
				new Fruit("사과", 200, "2023-5-8"),
		        new Fruit("키위", 500, "2023-6-8"),
		        new Fruit("오렌지", 200, "2023-7-8"),
		        new Fruit("바나나", 50, "2023-5-18"),
		        new Fruit("수박", 880, "2023-5-28"),
		        new Fruit("체리", 10, "2023-9-8")
		};
		
		System.out.println("1. 정렬 전 객체 배열: ");
		showData(arr);
		
		Arrays.sort(arr, (a,b) -> a.getPrice() - b.getPrice()); //Fruit에 compareTo()가 있어도 람다식 우선 적용  // 많은 정보를 내포
		System.out.println("\n2. 람다식 정렬(가격)후 객체 배열: ");
		showData(arr);
		
		Arrays.sort(arr, new Comparator<Fruit>() {
		      @Override
		      public int compare(Fruit a1, Fruit a2) {
		    	  return a1.getName().compareTo(a2.getName());
		      }
		   });
		System.out.println("\n3. comparator 정렬(이름)후 객체 배열: ");
		showData(arr);
	
		Comparator<Fruit> cc_name = new Comparator<Fruit>() {
			@Override
			public int compare(Fruit f1, Fruit f2) {
				return (f1.name.compareTo(f2.name));
//				return (f1.getName().compareTo(f2.getName()));
			}
	    };
	    
	    Comparator<Fruit> cc_price = new Comparator<Fruit>() {  // 익명클래스
			@Override
			public int compare(Fruit f1, Fruit f2) {
				return (f1.price - f2.price);
			}
	    }; 
	    
	//    익명 클래스로 생성된 new Comparator<Fruit>()를 cc_expire가 가지고 있음.
	    Comparator<Fruit> cc_expire = new Comparator<Fruit>() {  // cc_expire는 변수이며 객체를 가지고 있음.
			@Override
			public int compare(Fruit f1, Fruit f2) {
				// return (f1.expire - f2.expire);  // 불가능
				return (f1.expire.compareTo(f2.expire));
			}
	    };
		
		Fruit newFruit = new Fruit("체리", 880, "2023-5-18");
		int result3 = Arrays.binarySearch(arr, newFruit, cc_name);  // cc_name가 정렬 기준
//		int result3 = Arrays.binarySearch(arr, newFruit, Fruit.class_cc);
		System.out.println("\n4. Arrays.binarySearch() 조회결과-이름::" + result3);
		// 구현하기
		result3 = binarySearch(arr, newFruit, cc_name);  // 내가 만든 binarySearch
		System.out.println("\n5. binarySearch() 조회결과::-이름" + result3);
		
		sortData(arr, cc_price);
		System.out.println("\n6. comparator 정렬(가격)후 객체 배열: ");
		showData(arr);
		
		result3 = Arrays.binarySearch(arr, newFruit, cc_price);
		System.out.println("\n7. Arrays.binarySearch() 조회결과-가격::" + result3);
		
		result3 = binarySearch(arr, newFruit, cc_price);
		System.out.println("\n8. binarySearch() 조회결과-가격::" + result3);
		
		// 원인 파악 필요
		// 힌트: 이진 탐색을 하기 전 "정렬"을 함.
		result3 = Arrays.binarySearch(arr, newFruit, cc_name);
		System.out.println("\n9. Arrays.binarySearch() 조회결과-이름::" + result3);
		
		result3 = binarySearch(arr, newFruit, cc_name);
		System.out.println("\n10. binarySearch() 조회결과-이름::" + result3);
	}
	
	// showData
	static void showData(Fruit[] arr) {
		for (Fruit fruit:arr) {
			System.out.print(fruit+" "+"\n");
		}
//		System.out.println();	
	}
	
	static void sortData(Fruit[] arr, Comparator<? super Fruit> cc) {  // 더 명시적으로 표현
//		for (int i=0; i<arr.length; i++) {
//			for (int j=i+1; j<arr.length; j++) {
//				if (cc.compare(arr[i], arr[j]) > 0)
//					swap(arr, i, j);
//			}
//		}
//	} 
	
//	static void sortData(Fruit[] arr, Comparator<Fruit> cc) {  // 틀린 표현은 아니지만 위의 표현으로 사용하기
		for (int i=0; i<arr.length; i++) {
			for (int j=i+1; j<arr.length; j++) {
				if (cc.compare(arr[i], arr[j]) > 0)
					swap(arr, i, j);
			}
		}
	}
	
	static void swap(Fruit[] arr, int i, int j) {
		Fruit temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// binarySearch
	static int binarySearch(Fruit[]arr, Fruit key, Comparator<? super Fruit> cc) {  // 타입 + 변수 
		// 이진탐색 코드 가져와서 Fruit 버전으로 변경
		// if문에서 비교할 때
//		Fruit d1 = arr[0];
//		Fruit d2 = arr[1];
//		if (cc.compare(d1, d2) > 0) {  // cc_name → cc_name 
//			
//		}
//		return 0;
		int pl = 0;
		int pr = arr.length-1;
		
		do {
			int pc = (pl + pr) / 2;
			int com = cc.compare(arr[pc], key);
			if(com == 0) return pc;
			else if(com < 0) pl = pc + 1;
			else pr = pc-1;
		} while(pl <= pr);
		
		return -1;
	}
}
