public class Main {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution2(n));
    }

    public static int solution(int n) {
        int answer = n-1;
        for(int i = n-2; i > 1; i--) {
            if(n % i == 1 && i < answer) answer = i;
        }
        return answer;
    }

    // 모범 답안, 1부터 시작하는 것이 더 바람직.
    public static int solution2(int n) {
        int answer = 1;
        while(n % answer != 1) {answer ++;}
        return answer;
    }
}