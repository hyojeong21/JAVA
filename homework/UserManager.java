package test.homework;

// 회원과 관련된 모든 로직

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserManager {

    private List<User> users;

    // 프로그램 시작 시 파일에서 회원정보 불러옴
    public UserManager() throws Exception {
        users = FileManager.loadUsers();
    }

    // 로그인 처리
    // 입력한 id, pw가 users 안에 있는지 검사
    public User login(String id, String pw) {

        for(User u : users) {	// 회원 한 명씩 검사
            if(u.getId().equals(id) && u.getPassword().equals(pw)) {

                // 이전 로그인 시간 먼저 출력
                System.out.println("마지막 로그인 시간 : " + u.getLastLogin());

                // 로그인 시간 갱신
                updateLastLogin(u);
                
                // 로그인한 그 User 객체를 돌려줌
                return u;
            }
        }
        return null;	// 로그인 실패하면 null
    }

    // 이메일 형식 검사 (users와 상관없는 검사 기능이니 static)
    public static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    // 비밀번호 형식 검사
    public static boolean isValidPassword(String pw) {
        return pw.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,12}$");
    }

    // ID 중복 체크
    public boolean isDuplicateId(String id) {
        for(User u : users) {	// users를 돌면서 같은 id가 있는지 확인
            if(u.getId().equals(id)) {
                return true;	// 같은 ID를 하나라도 발견하면 메서드 종료
            }
        }
        return false;
    }

    // 회원가입 처리 
    // (이메일 형식 검사 -> 비밀번호 형식 검사 -> 중복 검사 -> 전부 통과시 User 객체 생성 -> users에 추가)
    public boolean register(String id, String pw) throws Exception {

        if(!isValidEmail(id)) {
            System.out.println("이메일 형식이 아닙니다.");
            return false;
        }

        if(!isValidPassword(pw)) {
            System.out.println("비밀번호 형식이 올바르지 않습니다.");
            return false;
        }

        if(isDuplicateId(id)) {
            System.out.println("이미 존재하는 ID입니다.");
            return false;
        }

        // 처음 가입자는 전적 0
        User newUser = new User(id, pw, "첫 로그인", 0,0,0,0);
        users.add(newUser);

        // 바로 파일 저장
        save();

        System.out.println("회원가입 되었습니다!");
        return true;
    }

    // 비밀번호 변경
    public boolean changePassword(User user, String newPw) throws Exception {

        if(!isValidPassword(newPw)) {
            System.out.println("비밀번호 형식이 올바르지 않습니다.");
            return false;
        }

        user.setPassword(newPw);	// User 객체 내부 값만 변경

        // 변경 후 저장
        save();

        return true;
    }

    // 로그인 시간 갱신
    // 외부에서 쓸 필요 없이 로그인할 때만 내부적으로 사용하기 때문에 private
    private void updateLastLogin(User user) {
        LocalDateTime now = LocalDateTime.now();	// 현재 시간 가져옴
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a hh시 mm분");

        user.setLastLogin(now.format(formatter));
    }

    // 파일 저장
    public void save() throws Exception {
        FileManager.saveUsers(users);
    }

    // 회원 리스트 반환 (전체 랭킹, 전체 전적, 승률 정렬에 사용)
    public List<User> getUsers(){
        return users;
    }
}