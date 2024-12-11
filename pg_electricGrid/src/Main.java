import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        int n = 7;
//        int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        System.out.println(solution(n ,wires));
    }
    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        // 노드 번호 : {연결된 노드 번호들, ..} 형태로 표현
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n+1; i++) list.add(new ArrayList<>());
        for(int i = 0; i < wires.length; i++) {
            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }

        for(int i = 0; i < wires.length; i++) {
            /** 해당 wire가 끊겼다면 두 덩어리로 나뉘게 되며, 끊긴 노드 둘을 시작으로 탐색하여 각각 개수를 구한다.
             이의 차이값을 비교하여 최소값을 저장. **/
            // 그래프 조정.
            list.get(wires[i][0]).remove((Integer) wires[i][1]);
            list.get(wires[i][1]).remove((Integer) wires[i][0]);

            // 연결이 끊긴 두 노드
            int target1 = wires[i][0];
            int target2 = wires[i][1];
            int result = Math.abs(backTracking(list, target1, 0)-backTracking(list, target2, 0));
            answer = Math.min(answer, result);

            // 다음 차례 위해 노드 복구
            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }
        return answer;
    }

    static int backTracking(ArrayList<ArrayList<Integer>> tree, int nodeNum, int previous) {
        if(tree.get(nodeNum).size() <= 1 && tree.get(nodeNum).contains((Integer) previous)) {
            return 1;
        }
        int sum = 1;
        for(int node : tree.get(nodeNum)) {
            if(node == previous) continue;
            sum += backTracking(tree, node, nodeNum);
        }
        return sum;
    }
}