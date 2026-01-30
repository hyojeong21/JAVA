package test.utilex;

import java.util.Collections;
import java.util.List;

public class UseList {

	public void showUsers(List<Player> lists) {
		Collections.sort(lists, Collections.reverseOrder());
        System.out.println(lists);
        
		// list 내부에 있는 플레이어의 정보를 출력해보자
		System.out.println(lists.size());
		for(int i = 0; i <lists.size(); i++) {
			Player player = lists.get(i);
			System.out.println(player.getId());
			System.out.println(player.getPw());
			System.out.println(player.getWin());
			System.out.println(player.getLose());
			System.out.println(player.getDraw());
			System.out.println(player.getRate());
			System.out.println("--------------");
		}

	}
}