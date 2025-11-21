import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyMain {
    static int[] score;
    static int[] cal;
    static boolean[] vis;
    static int max;
    static int N;
    static int C;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("p5215_swea/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            score = new int[N];
            cal = new int[N];
            vis = new boolean[N];
            max = 0;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            System.out.println("#" + t + " " + max);
        }
    }

    public static void dfs(int current, int cscore) {
        System.out.println(cscore);
        max = Math.max(cscore, max);
        for(int i = 0; i < N; i++) {
            if(vis[i] == true) continue;
            vis[i] = true;
            if(current + cal[i] <= C){
                dfs(current + cal[i], cscore + score[i]);
            }
            vis[i] = false;
        }
    }
}
