import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static char[] arr;
    static int n;
    static int ans;
    static HashSet<String>[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            // input
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            n = Integer.parseInt(st.nextToken());

            // 초기화
            ans = 0;

            arr = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arr[i] = str.charAt(i);
            }

            v = new HashSet[n + 1];
            for (int i = 0; i <= n; i++) {
                v[i] = new HashSet<>();
            }

            // solve
            dfs(0);

            // print
            System.out.println("#" + tc + " " + ans);

        }
    }

    static void dfs(int depth) {

        // 현재 상태 문자열 변환
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }

        // 가지치기
        if (v[depth].contains(sb.toString())) return;

        v[depth].add(sb.toString());

        // 종료 조건
        if (depth == n) {
            int digit = Integer.parseInt(sb.toString());
            ans = Math.max(ans, digit);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(i, j); // swap

                dfs(depth + 1); // 재귀호출

                swap(i, j); // 백트래킹
            }
        }
    }

    static void swap(int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}