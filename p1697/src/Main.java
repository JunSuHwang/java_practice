import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        /* 모범답안.
        재귀 탐색으로 풀려 했으나 N, K의 차이가 커지면 너무 오래걸림.
        큐을 이용한 bfs 풀이와 visited 배열 사용 복습
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            return;
        }
        boolean[] visited = new boolean[100001];
        visited[n] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int size = q.size();
        int count = 0;
        while (true) {
            count++;
            size = q.size();
            for (int i = 0; i < size; i++) {
                int x = q.remove();
                visited[x] = true;
                if (x-1 == k || x+1 == k || x*2 == k) {
                    System.out.println(count);
                    return;
                }
                if (x-1 >= 0 && !visited[x-1]) {
                    visited[x-1] = true;
                    q.add(x-1);
                }
                if (x+1 <= 100000 && !visited[x+1]) {
                    visited[x+1] = true;
                    q.add(x+1);
                }
                if (x*2 <= 100000 && !visited[x*2]) {
                    visited[x*2] = true;
                    q.add(x*2);
                }
            }
        }
    }
}
// https://propercoding.tistory.com/15