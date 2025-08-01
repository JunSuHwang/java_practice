import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class MyMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int R = Integer.parseInt(s[2]);
        int repeat = 2*N + 2*M - 4; // 처음으로 돌아오게 되는 회전
        int[][] arr = new int[N][M];
        int[][] result = new int[N][M];

        boolean[][] vis = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(vis[i], false);
        }
        //
        for (int i = 0; i < N; i++) {
            Arrays.fill(result[i], -1);
        }
        //
        for (int i = 0; i < N; i++) {
            String[] s1 = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        int y = 0;
        int x = 0;
        while(true) {
            for (y = 0; y < N; y++) list.add(arr[y][x]);
            y--;
            for (x = 1; x < M; x++) list.add(arr[y][x]);
            x--;
            for (--y; y >= 0; y--) list.add(arr[y][x]);
            y++;
            for(--x; x >= 1; x--) list.add(arr[y][x]);

            for (int i = 0; i < R; i++) {
                list.addFirst(list.removeLast());
            }
            System.out.println(list);
            for (y = 0; y < N; y++) result[y][x] = list.removeFirst();
            y--;
            for (x = 1; x < M; x++) result[y][x] = list.removeFirst();
            x--;
            for (--y; y >= 0; y--) result[y][x] = list.removeFirst();
            y++;
            for(--x; x >= 1; x--) result[y][x] = list.removeFirst();
            x++;
            break;
        }
        System.out.println(Arrays.deepToString(result));
    }

}