import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyMain {
    static int min = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        // 백트래킹 -> 스택 or 재귀?
        min = Math.abs(N-K);
        dfs(N, K,0,0);

        System.out.print(min);
    }
    static void dfs(int current, int answer, int prevOp, int result) {
        if(current < 0 || result >= min) return;
        if(current == answer) {
            if(min > result) min = result;
            return;
        }
        // +1을 탐색
        if(prevOp != -1) dfs(current+1, answer, 1, result+1);
        // -1을 탐색
        if(prevOp != 1) dfs(current-1, answer, -1, result+1);
        // *2를 탐색
        dfs(current*2, answer, 2, result+1);
    }
}