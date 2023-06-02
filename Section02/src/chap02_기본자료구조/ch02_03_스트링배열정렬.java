// StringArray

package section02.chap02_기본자료구조;

public class ch02_03_스트링배열정렬 {
	
	// showData
	static void showData(String[] items) {
		for(int i=0; i<items.length; i++) {
			System.out.print(items[i] + " ");
		}
	}
	
	// swap
	static void swap(String[] items, int i, int j) {
		String tmp = items[i];
		items[i] = items[j];
		items[j] = tmp;
	}
	
	// sortData
	static void sortData(String[] items) {
		for (int i=0; i<items.length; i++) {
			for (int j=i+1; j<items.length; j++) {
				// if (data[i] > data[j]) {  // 정수가 아닌 문자열 비교이므로 오류 발생
				if (items[i].compareTo(items[j]) > 0) {
					swap(items, i, j);
				}
			}
		}
	}

	public static void main(String[] args) {
		String[] data = {"Orange", "Banana", "Apple", "Grape"};  // 배열인 데이터를 String에 넣으며 초기화
		showData(data);
		sortData(data);
		System.out.println("\n정렬 후 결과 > ");
		showData(data);
	}
}

//https://bangu4.tistory.com/288
//https://www.delftstack.com/ko/howto/java/sort-string-srray-alphabetically-in-java/
