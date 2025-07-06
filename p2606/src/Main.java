import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 중첩 리스트를 통해 [[1번 노드와 연결된 노드들..], [2번 노드와 연결된 노드들..], ..] 형태로
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int ccount = Integer.parseInt(bf.readLine());
        for (int i = 0; i < ccount+1; i++) {
            arr.add(new ArrayList<Integer>());
        }
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            arr.get(first).add(second);
            arr.get(second).add(first);
        }
        // dfs를 통한 노드 방문 체크
        boolean[] visited = new boolean[ccount+1];
        Arrays.fill(visited, false);
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        visited[1] = true;
        while(!stack.isEmpty()) {
            int nodeIndex = stack.pop();
            ArrayList<Integer> target = arr.get(nodeIndex);
            for(int node : target) {
                if(!visited[node]){
                    stack.push(node);
                    visited[node] = true;
                }
            }
        }
        int result = 0;
        // 1번 노드로부터 감염된 개수를 세는 것, 1번 노드만 있을 경우 대비
        for (int i = 1; i < visited.length; i++) {
            if(visited[i]) result++;
        }
        System.out.print(result-1);
    }
}