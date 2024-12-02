import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String name = "BCAAAAAAZK";
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        int answer = 0, rem = 0, cnt = Integer.MAX_VALUE;

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                answer += calc(name.charAt(i));
                // 순서대로, 역순??
                if (i == 0) continue;
                int tmp = rem + name.length()-i;
                System.out.println(cnt + " " + (tmp+rem) + " " + (tmp+name.length()-i));
                cnt = Math.min(cnt, Math.min(tmp+rem, tmp+name.length()-i));
                rem = i;
            }
        }
        cnt = Math.min(rem, cnt);
        return answer+cnt;
    }

    public static int calc(char c) {
        int cint = (int) c;
        return Math.min(91-c, c-65);
    }
}