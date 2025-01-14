import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "23four5six7";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        List<String> list = new LinkedList<>(Arrays.asList("zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"));
        char[] target = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < target.length; i++) {
            if (target[i] >= '0' && target[i] <= '9') result.append(target[i]);
            else sb.append(target[i]);

            if(sb.length() >= 3) {
                System.out.println(sb);
                int temp = list.indexOf(sb.toString());
                if(temp != -1) {
                    result.append(temp);
                    sb.delete(0, sb.length());
                }
            }
        }
        return Integer.parseInt(result.toString());
    }

    // 모범 답안
    public static int solution2(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < strArr.length; i++) {
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}