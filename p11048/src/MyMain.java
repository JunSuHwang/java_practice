import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyMain {
    static int[][] arr;
    static int M;
    static int N;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, 0);
        System.out.println(max);
    }
    static void dfs(int r, int c, int current) {
        if(r >= N-1 && c >= M-1) {
            max = Math.max(max, current + arr[r][c]);
            return;
        }
        if(r+1 < N){
            dfs(r + 1, c, current + arr[r][c]);
        }
        if(c+1 < M){
            dfs(r, c + 1, current + arr[r][c]);
        }
        if(r+1 < N && c+1 < M){
            dfs(r + 1, c + 1, current + arr[r][c]);
        }
    }
}