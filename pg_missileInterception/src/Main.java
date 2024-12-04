import java.util.Arrays;

// 정답 풀이
public class Main {
    public static void main(String[] args) {
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        System.out.println(solution(targets));
    }

    public static int solution(int[][] targets) {
        int answer = 0;
        // 첫 번째 원소를 먼저 정렬하고, 같으면 두 번째 원소로 정렬.
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        // 현재 위치.
        int pos = 0;

        for (int i = 0; i < targets.length; i++) {
            // 다음 pos를 결정할 때 pos보다 작은, 즉 앞의 것을 선택하지 않기 위함.
            if (targets[i][0] >= pos)  {
                answer++;
                // 다음 pos를 현재 target의 끝 위치로 지정
                pos = targets[i][1];
            }
        }
        return answer;
    }
}