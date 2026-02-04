package test.homework;

// 메뉴 관리 (로그아웃, 게임시작, 내 전적, 랭킹, 비밀번호 변경)

import javax.swing.JOptionPane;

public class GameManager {

    private User currentUser;
    private UserManager userManager;

    public GameManager(User user, UserManager um) {
        this.currentUser = user;
        this.userManager = um;
    }

    public void menu() throws Exception {
        while(true) {
            String input = JOptionPane.showInputDialog(
                "1.로그아웃\n2.게임시작\n3.내 전적\n4.전체 랭킹\n5.비번변경");

            switch(input) {
                case "1":
                    userManager.save();
                    return;
                case "2":
                    RSPGAME game = new RSPGAME();
                    game.startGame();

                    currentUser.setTotal(currentUser.getTotal() + game.getTotal());
                    currentUser.setWin(currentUser.getWin() + game.getWin());
                    currentUser.setLose(currentUser.getLose() + game.getLose());
                    currentUser.setDraw(currentUser.getDraw() + game.getDraw());
                    break;
                case "3":
                    showRecord();
                    break;
            }
        }
    }

	private void showRecord() {
		// TODO Auto-generated method stub
		
	}
}