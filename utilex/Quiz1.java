package test.utilex;

import java.util.ArrayList;
import java.util.List;

/*
 * Board 객체의 getBoardList()를 호출하면 List<Board> 타입의 컬렉션을 리턴함..
 * BoardListExam의 실행 결과를 보고, BoardDao 클래스와 getBoardList() 메서드를 작성하자
 */

class Board {
	private String title;
	private String content;
	
	public Board(String title, String content) {	// Board 객체를 만들 때 반드시 제목과 내용을 넣어라
		this.title = title;		
		// this.title: Board 객체 안에 있는 필드(변수), title: 생성자로 들어온 매개변수(파라미터)
		// "생성자로 들어온 제목을, 이 객체의 title 변수에 저장해라"
		this.content = content;
	}
	
	// private으로 막아놨기 때문에 꺼내는 문을 만들어주기
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
}

class BoardListExam {
	public void doSome() {	// Board들을 모아서 출력하는 역할
		BoardDao dao = new BoardDao();		// 게시글들을 가져오는 담당자(DAO)를 만든 것
		List <Board> list = dao.getBoardList();		// Board 여러 개를 리스트로 받아온 것
		for (Board b: list) {	// 리스트 안에 있는 Board를 하나씩 꺼내서 b에 넣겠다
			System.out.println(b.getTitle() + " = " + b.getContent());		// Board 안의 값을 getter로 꺼내서 출력
		}
	}
}


class BoardDao {
	public List <Board> getBoardList(){				// Board 객체들을 담고 있는 List를 리턴하는 메서드
		List <Board> list = new ArrayList<Board>();	// Board 타입만 저장할 수 있는 리스트를 만들겠다는 뜻. 겉(타입)은 List, 실제 객체는 ArrayList.
		
		list.add(new Board("제목1", "내용1"));
		list.add(new Board("제목2", "내용2"));
		list.add(new Board("제목3", "내용3"));
		
		return list;
	}
}


public class Quiz1 {

	public static void main(String[] args) {

		BoardListExam le = new BoardListExam();		
		// BoardListExam 클래스로 실제 사용할 수 있는 객체(인스턴스)를 하나 만든 것. new BoardListExam(): 진짜 객체 생성
		le.doSome();
		
	}
}