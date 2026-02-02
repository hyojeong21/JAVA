package test.utilex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackExam {

	public static void main(String[] args) {

		// Stack : 후입선출. 위로 쌓는 구조. 나중에 들어온 것이 먼저 나감
		Stack<Integer> stack = new Stack<Integer>();	
		// Stack<Integer>(): Stack 객체 만듦 (생성자 호출)
		// 즉 Integer만 담는 Stack 객체를 만들어서, 그 주소를 stack 변수에 저장한다.
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		// stack에 있는 요소가 있는지를 검증하도록 하는 메서드 활용
		while(!stack.isEmpty()) {
			// stack이 공백이 아니라면
			// 데이터를 순차적으로 추출한다. (stack이 비어있지 않으면 반복)
			int data = stack.pop();		// pop(): 맨 위의 데이터를 꺼내면서 삭제. 리턴값도 줌
			System.out.println(data);
		}
		
		
		// Queue: 선입선출. 맨처음 들어간 데이터가 먼저 빠져나오는 구조
		// 다형성을 이용해서 Queue 객체를 생성한다.
		Queue<Integer> q = new LinkedList<Integer>();	
		// LinkedList<Integer>(): LinkedList 객체 만듦 (생성자 호출)
		// LinkedList 객체를 만들어서 이걸 Queue 규칙으로만 사용하겠다
		// (Queue 역할을 할 변수를 만들고, 실제 객체는 LinkedList로 만들겠다.) 
		// Queue는 실체가 없어서 new Queue() 불가능
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		while(!q.isEmpty()) {
			// q에 데이터가 존재한다면..
			System.out.println(q.poll());	// poll(): 맨 앞의 데이터를 꺼내면서 삭제
		}
	
	}
}