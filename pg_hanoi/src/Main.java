import java.util.*;

public class Main {
    static ArrayList<int[]> list;

    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.deepToString(solution(n)));
    }

    public static int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        return list.toArray(new int[list.size()][list.getFirst().length]);
    }

    public static void hanoi(int num, int from, int by, int to) {
        if(num == 1) {
           list.add(new int[]{from, to});
        }
        else {
            // 1번의 n번째 판을 to로 옮기기 위해선
            // n-1개의 판들을 by로 옮겨야 한다.
            hanoi(num-1, from, to, by);
            list.add(new int[]{from, to});
            // n-1개의 판들이 by에 있고 이를 to로 옮긴다.
            hanoi(num-1, by, from, to);
        }
    }
}