import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(solution2(numbers)));
    }

    public static int[] solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            int result = -1;
            for(int j = i+1; j < numbers.length; j++) {
                if(numbers[j] > numbers[i]) {
                    result = numbers[j];
                    break;
                }
            }
            answer.add(result);
        }
        return answer.stream().
                mapToInt(Integer::intValue)
                .toArray();
    }

    // 모범 답안, 이중 반복문은 case20~23에서 시간초과하기 때문에 스택 사용
    public static int[] solution2(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];
        int idx = size-1;
        answer[idx--] = -1;

        Stack<Integer> stack = new Stack<>();
        for(int i = size-2; i >= 0; i--) {
            if(numbers[i+1] > numbers[i]) {
                // 스택에 푸시되므로 나중에 푸시되었던 것은 우선순위가 낮음
                stack.push(numbers[i+1]);
                answer[idx--] = numbers[i+1];
                continue;
            } else {
                boolean isBig = false;
                while(!stack.isEmpty()) {
                    int now = stack.peek();
                    System.out.println("now : " + now);
                    if(now > numbers[i]) {
                        isBig = true;
                        answer[idx--] = now;
                        break;
                    } else {
                        // 스택에서 peek한 것의 값이 더 낮으면 더 뒤의 것을 가져오기 위해 pop
                        stack.pop();
                    }
                }

                // 스택을 전부 탐색했는데 못 찾으면 뒤에 현재보다 큰 수가 없음 & 현재가 제일 큰 수
                if(!isBig) {
                    answer[idx--] = -1;
                }
            }
        }

        return answer;
    }
}