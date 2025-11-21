import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("p5215_swea/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= TC; test_case++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int[] T = new int[N];
            int[] K = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                T[i] = Integer.parseInt(st.nextToken());
                K[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[L + 1];

            for (int i = 0; i < N; i++) {
                for (int j = L; j >= K[i]; j--) {
                    // 그냥 집어넣는게 큰지, 현재 무게를 넣고 남은 배낭의 가치에 현재 가치를 더한게 더 큰지.
                    dp[j] = Math.max(dp[j], dp[j - K[i]] + T[i]);
                }
            }
            System.out.println("#" + test_case + " " + dp[L]);
        }

        br.close();
    }
}