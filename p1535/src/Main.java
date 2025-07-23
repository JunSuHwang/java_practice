import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] damage = new int[N];
        int[] joy = new int[N];
        String[] dinput = bf.readLine().split(" ");
        String[] jinput = bf.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            damage[i] = Integer.parseInt(dinput[i]);
            joy[i] = Integer.parseInt(jinput[i]);
        }
        for (int i = 0; i < N; i++) {
            dfs(i, 0, 0, damage, joy);
        }
        System.out.print(max);
    }

    static void dfs(int current, int hp, int sum, int[] damage, int[] joy) {
//        System.out.println("c : " + current + ", hp: " + hp + ", sum : " + sum + ", max : " + max);
        // 현재 탐색때 hp 감소 총합이 100이상이면 유망x
        if(hp+damage[current] >= 100) {
            return;
        }
        max = Math.max(max, sum+joy[current]);
        for (int i = current + 1; i < damage.length; i++) {
            dfs(i, hp + damage[current], sum + joy[current], damage, joy);
        }
    }
}