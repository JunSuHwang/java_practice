import java.io.*;
import java.util.*;

public class Main {
    /*
    dp 문제인걸 인식하고 풀이를 세웠으나 점화식을 조금 잘못세워서
    역추적 풀이도 어렵게 됨.
    밑의 풀이처럼 dp[i]는 이전 i-1에서 단순히 +1을 한 것과(1을 더한 것)
    i가 2 또는 3 으로 나눠진다면, 기존 dp[i/2] or dp[i/3]에서 +1을 해서 활용하는 법이 맞는 것 같다.(나눠지는 것을 활용한 것)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; // 1을 빼는 연산
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        sb.append(dp[n]).append("\n");

        // 역추적 (경로 출력)
        while (n > 0) {
            sb.append(n).append(" ");
            if (n == 1) break;
            if (n % 3 == 0 && dp[n / 3] == dp[n] - 1) {
                n /= 3;
            } else if (n % 2 == 0 && dp[n / 2] == dp[n] - 1) {
                n /= 2;
            } else {
                n -= 1;
            }
        }

        System.out.println(sb.toString().trim());
    }
}
// https://propercoding.tistory.com/392