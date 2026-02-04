package test.homework;

// 프로그램 시작

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {

        UserManager um = new UserManager();

        while(true) {
            String id = JOptionPane.showInputDialog("ID 입력");
            String pw = JOptionPane.showInputDialog("PW 입력");

            User user = um.login(id, pw);

            if(user == null) {
                JOptionPane.showMessageDialog(null, "회원가입 진행");
                // 회원가입 로직
            } else {
                GameManager gm = new GameManager(user, um);
                gm.menu();
            }
        }
    }
}