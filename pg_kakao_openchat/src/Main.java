import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {
        HashMap<String, String> users = new HashMap<>();
        for(int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            if (s[0].equals("Change")) {
                users.replace(s[1], s[2]);
            } else if(s[0].equals("Enter")){
                if(users.containsKey(s[1])) {
                    users.replace(s[1], s[2]);
                }else {
                    users.put(s[1], s[2]);
                }
            }
        }
        ArrayList<String> answer = new ArrayList<>();
        for(int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter")) {
                String result = "";
                result = result + users.get(s[1]) + "님이 들어왔습니다.";
                answer.add(result);

            } else if(s[0].equals("Leave")) {
                String result = "";
                result = result + users.get(s[1]) + "님이 나갔습니다.";
                answer.add(result);
            }
        }
        return answer.toArray(new String[0]);
    }
}