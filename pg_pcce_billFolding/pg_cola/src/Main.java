public class Main {
    public static void main(String[] args) {
        int a = 3;
        int b = 1;
        int n = 20;
        System.out.println(solution(a, b, n));
    }
    public static int solution(int a, int b, int n) {
        int answer = 0;
        while(n / a != 0) {
            int t = n%a;
            n = n/a*b;
            answer += n;
            n += t;
//            System.out.println(answer);
        }
        return answer;
    }
}