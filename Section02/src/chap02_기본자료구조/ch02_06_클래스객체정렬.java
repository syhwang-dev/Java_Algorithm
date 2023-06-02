// 온라인 게임 서비스에서 게이머들을 높은 점수 순으로 보여주는 게이머 랭킹 페이지
// https://www.daleseo.com/java-comparable-comparator/

package section02.chap02_기본자료구조;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// Step04. Comparable 인터페이스
class Player implements Comparable<Player> {
	private String name;
	private int score;
	
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	public int compareTo(Player o) {
		return o.getScore() - getScore();
	}
	
	
	// Getters, Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

// Step01. 정렬 대상 클래스
//public class Player {
//	private String name;
//	private int score;
//	
//	public Player(String name, int score) {
//		this.name = name;
//		this.score = score;
//	}
//}

public class ch02_06_클래스객체정렬 {

	public static void main(String[] args) {
		// Step02. 5명의 게이머를 담고 있는 리스트 생성
		List<Player> players = new ArrayList<>();
		// Step03. Chloe가 1등이기 때문에 리스트의 맨 앞으로 나와야 하고, Alice가 꼴등이기 때문에 리스트의 맨 뒤로 보내야 함.
		players.add(new Player("Alice", 899));
		players.add(new Player("Bob", 982));
		players.add(new Player("Chloe", 1090));
		players.add(new Player("Dale", 982));
		players.add(new Player("Eric", 1018));
		
		Collections.sort(players);
		System.out.println(players);

	}

}

// https://choichumji.tistory.com/119
// https://kim-oriental.tistory.com/m/45
