import java.util.Arrays;

// 정확성 테스트 만점, 효율성 테스트 케이스 2/6 통과
public class Main {
    static boolean[][] vst;
    static int N, M;
    public static void main(String[] args) {
        int[][] land = {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1},
            {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};
        N = land.length;
        M = land[0].length;
        vst = new boolean[N][M];
        for (boolean[] v : vst) Arrays.fill(v, false);
        System.out.println(solution(land));
    }

    public static int solution(int[][] land) {
        int answer = 0;
        for(int j = 0; j < M; j++) {
            int sum = 0;
            for(int i = 0; i < N; i++) {
                if(land[i][j] == 1) sum  += search(land, i, j);
            }
            if(answer < sum) answer = sum;
            // System.out.println(sum);
            for (boolean[] v : vst) Arrays.fill(v, false);
        }
        return answer;
    }

    public static int search(int[][] land, int y, int x) {
        if(y >= 0 && y < N && x >= 0 && x < M && land[y][x] == 1 && !vst[y][x]) {
//            System.out.println("y : " + y + ", x : " + x);
            vst[y][x] = true;
            return 1 + search(land,y+1, x) + search(land, y, x+1) + search(land, y, x-1) + search(land, y-1, x);
        }
        return 0;
    }
}