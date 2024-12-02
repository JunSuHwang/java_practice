import java.util.Optional;

public class EmailSample {
    /** orElse 괄호 내부의 getUserEmail이 실행되어 반환값이 orElse에 전달
     *  그 후 Optional은 null이 아니므로 "Empty" 값 그대로를 가짐
     */
    public void findUserEmailOrElse() {
        String userEmail = "Empty";
        String result = Optional.ofNullable(userEmail)
                .orElse(getUserEmail());

        System.out.println(result);
    }

    public void findUserEmailOrElseGet() {
        String userEmail = "Empty";
        String result = Optional.ofNullable(userEmail)
                .orElseGet(this::getUserEmail);

        System.out.println(result);
    }

    private String getUserEmail() {
        System.out.println("getUserEmail() Called");
        return "mangkyu@tistory.com";
    }
}
