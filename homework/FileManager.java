package test.homework;

// 파일 입출력 역할. (User.java를 파일에 저장하고 꺼내오는 역할)
// users.txt 파일과 User 객체들(List<User>)을 서로 변환해주는 역할
// 회원 정보, 전적을 파일에 저장해놔야 해서 필요함

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    // 회원 정보를 저장할 파일 이름
	// 항상 users.txt 파일만 사용
    private static final String FILE = "users.txt";

    // 파일에서 회원 정보를 읽어와 User 객체들로 만들어서 List에 담아 돌려줌 (List<User>로 반환)
    // loadUsers: 파일에서 회원들을 읽어오는 기능
    public static List<User> loadUsers() throws Exception {

        List<User> list = new ArrayList<>();

        File file = new File(FILE);

        // 파일이 처음이라 존재하지 않으면 빈 리스트 반환
        if(!file.exists()) {
            return list;
        }

        // 파일 읽기
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        
        // 한 줄씩 읽기
        // 파일에서 한 줄 읽고 String으로 주고 더 이상 읽을 줄이 없으면 null
        // (읽을 줄이 있는 동안 계속 반복)
        while((line = br.readLine()) != null) {

            // 한 줄을 , 기준으로 나눔
            String[] arr = line.split(",");

            // 잘못된 데이터가 있을 경우 대비 (데이터가 이상하면 무시하고 다음 줄 읽음)
            if(arr.length < 7) continue;

            // User 객체 만들기
            User u = new User(
                    arr[0],                 	// id
                    arr[1],                 	// password
                    arr[2],                 	// lastLogin
                    Integer.parseInt(arr[3]), 	// total. 파일에서 읽은 건 전부 String이기 때문에 숫자로 변환
                    Integer.parseInt(arr[4]), 	// win
                    Integer.parseInt(arr[5]), 	// lose
                    Integer.parseInt(arr[6])  	// draw
            );

            // 리스트에 담기
            list.add(u);
        }

        br.close();
        return list;	// 다 읽었으면 이 리스트가 UserManager로 넘어감
    }

    // 메모리에 있는 User들(List<User>의 내용)을 파일에 저장
    // saveUsers: 유저들을 저장하는 기능
    public static void saveUsers(List<User> list) throws Exception {

    	// 파일 쓰기
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE));

        // User 하나씩 꺼내기
        for(User u : list) {
            bw.write(
            	// 한 줄 문자열로 만들기 (객체를 텍스트로 변환)
                u.getId() + "," +
                u.getPassword() + "," +
                u.getLastLogin() + "," +
                u.getTotal() + "," +
                u.getWin() + "," +
                u.getLose() + "," +
                u.getDraw()
            );
            bw.newLine();	// 줄바꿈
        }

        bw.close();
    }
}