import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
/*
 모범답안.
 dfs를 떠올리긴 했지만 방문 배열을 어떻게 만들어야할지 몰라 못풀었다.
 방문 배열 HashSet<String>의 배열을 depth 크기만큼 만들고, 이에 이미 찾은 문자열을 추가한 것이 키포인트이다.
 */
public class MyMain {
    static char[] arr;
    static int n;
    static int ans;
    static HashSet<String>[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            n = Integer.parseInt(st.nextToken());

            ans = 0;
            arr = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arr[i] = str.charAt(i);
            }
            // dfs depth가 n일때까지 방문 기록, 0일때는 아직 바꾸지 않은것.
            v = new HashSet[n + 1];
            for (int i = 0; i <= n; i++) {
                v[i] = new HashSet<>();
            }

            dfs(0);
            System.out.println(Arrays.toString(v));
            System.out.println("#" + tc + " " + ans);
        }
    }
    static void dfs(int depth) {
        StringBuilder sb = new StringBuilder();
        // 현재 상태 문자열(처음 제외, swap한) 변환
        for (char c : arr) {
            sb.append(c);
        }

        // 가지치기
        if(v[depth].contains(sb.toString())) return;

        v[depth].add(sb.toString());
        System.out.println(sb.toString());

        if (depth == n) {
            int digit = Integer.parseInt(sb.toString());
            ans = Math.max(ans, digit);
            return;
        }

        // 모든 자리 끼리 바꾸는 경우를 탐색함.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                swap(i, j);

                dfs(depth + 1);

                swap(i, j);
            }
        }
    }

    static void swap(int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}