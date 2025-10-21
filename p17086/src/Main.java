import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 문제를 풀지 못해 주석을 달면서 풀이 이해함.
public class Main {
    static int N, M, max;
    static int[][] map;

    static int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0){
                    bfs(i, j);
                }
            }
        }

        System.out.println(max);
    }

    // 깊이가 아닌 너비 우선 탐색이기 때문에 지그재그로 max가 커지지 않음.
    static void bfs(int sr, int sc) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[N][M];

        v[sr][sc] = true;
        // {행, 열, 거리} 형태로 현재 좌표를 큐에 저장.
        q.add(new int[] {sr, sc, 0});
        // 현재 좌표로 탐색시 최소 안전거리 저장. 후에 max와 비교
        int dist = 0;

        while(!q.isEmpty()) {
            // 선입된 좌표를 꺼낸다.
            int[] now = q.poll();
            // 상어가 있는 곳이면
            if(map[now[0]][now[1]] == 1) {
                // 너비 우선이므로 상어에 도달하면 현재 좌표에서는 최소거리를 찾은 것임.
                if(dist < now[2]) {
                    dist = now[2];
                    break;
                }
            }
            // 현재 좌표의 8방향의 좌표를 큐에 넣는다.
            for (int i = 0; i < 8; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc]) {
                    continue;
                }

                v[nr][nc] = true;
                q.add(new int[] {nr, nc, now[2] + 1});
            }
        }
        if(max < dist) {
            max = dist;
        }
    }
}
// 출처 : https://happy-youngjae.tistory.com/80