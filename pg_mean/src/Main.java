import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 5};
        System.out.println(solution(arr));
        System.out.println(solution2(arr));
    }

    public static double solution(int[] arr) {
        double answer = 0;
        answer = (double) Arrays.stream(arr).sum() / arr.length;
        return answer;
    }
    // 모범 답안
    public static double solution2(int[] arr) {
        return Arrays.stream(arr).average().orElse(0);
    }
}