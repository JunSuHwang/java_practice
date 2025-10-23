import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] t = new int[N];
        int[] p = new int[N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];

        for (int i = 0; i < N; i++) {
            if(i + t[i] <= N) {
                /* 현재 상담이 끝나면 받는 보수를 끝나는 날에 저장
                해당 날짜와 현재 보수를 비교하는 이유는 해당 날짜에 다른 상담의 보수가 더 높으면
                그 보수가 저장되야 되기 때문.
                 */
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            /*
            보수를 받는 날 이외의 날도 이전의 보수를 누적되도록 저장
             */
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[N]);
    }
}