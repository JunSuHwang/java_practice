import java.util.*;

public class Main {
    static int n,m,value;
    // 배열 상의 상하좌우
    static int[] dr = {-1,1,0,0}, dc={0,0,-1,1};
    static boolean[][] vis;
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        System.out.println(Arrays.toString(solution(maps)));
    }

    // 모범 답안
    public static int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        vis = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                // 방문했거나 'X'이면 건너뜀.
                if(vis[i][j] || maps[i].charAt(j) == 'X') continue;
                dfs(i,j,maps);

                // 계산 후 value값에 저장.
                ans.add(value);
                value = 0;
            }
        }

        if(ans.isEmpty()) return new int[]{-1};
        return ans.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
    public static void dfs(int r,int c, String[] maps) {
        // 방문 표시.
        vis[r][c] = true;

        value+=maps[r].charAt(c)-'0';

        for(int i = 0 ; i <4 ; i++){
            // 상하좌우 순회
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 해당 땅이 범위를 벗어나거나 'X'이거나 방문했으면 건너뜀
            if(OOB(nr,nc) || maps[nr].charAt(nc) == 'X' || vis[nr][nc]) continue;

            // 연결된 땅 진입.
            dfs(nr,nc,maps);
        }
    }

    // 배열 인덱스의 범위 검사.
    static boolean OOB(int r,int c){
        return r < 0 || r >= n || c < 0 || c >= m;
    }
}