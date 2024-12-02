import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}};
        System.out.println(Arrays.toString(Arrays.stream(solution(name, yearning, photo)).toArray()));
    }

    public static int[] solution(String[] name, int[] yearning,String[][] photo) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int[] answer = new int[photo.length];
        int i;
        for(i = 0; i < yearning.length; i++) {
            hashMap.put(name[i], yearning[i]);
        }
        for(int j = 0; j < photo.length; j++) {
            int sum = 0;
            for (String n : photo[j]) {
                Optional<Integer> optional = Optional.ofNullable(hashMap.get(n));
                sum += optional.orElse(0);
            }
            answer[j] = sum;
        }
        return answer;
    }
}