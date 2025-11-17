import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static char[][] arr;
    static List<String> ans;
    static int N;
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("p1215_swea/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;
        for (int tc = 1; tc <= t; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new char[8][8];
            ans = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                String input = br.readLine();
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = input.charAt(j);
                }
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    solve(i, j);
                }
            }
            System.out.println("#"+tc+" "+ans.size());
        }
    }

    public static void solve(int y, int x) {
        StringBuilder down = new StringBuilder();
        StringBuilder right = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if(x+i < 8) right.append(arr[y][x+i]);
            if(y-i >= 0) down.append(arr[y-i][x]);
        }
        if(down.length() == N && check(down.toString())) {
            ans.add(down.toString());
        }
        if(right.length() == N && check(right.toString())) {
            ans.add(right.toString());
        }
    }

    public static boolean check(String s) {
        boolean isPalin = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                isPalin = false;
                break;
            }
        }
        return isPalin;
    }
}