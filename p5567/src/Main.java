import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 친구와 친구의 친구를 초대.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        // friends = {{상근이의 친구, 친구1의 친구, ... }
        List<List<Integer>> friends = new ArrayList<>();
        boolean[] vis = new boolean[N+1];
        Set<Integer> answer = new HashSet<>();;
        for (int i = 0; i <= N; i++) {
            friends.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            friends.get(t1).add(t2);
            friends.get(t2).add(t1);
        }

        vis[1] = true;
        for (int i = 0; i < friends.get(1).size(); i++) {
            int current = friends.get(1).get(i);
            answer.add(current);
            vis[current] = true;
            for (int j = 0; j < friends.get(current).size(); j++) {
                int target = friends.get(current).get(j);
                if(target == 1 || vis[target]) continue;
                answer.add(target);
            }
        }
        System.out.println(answer.size());
    }
}