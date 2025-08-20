import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        N이 K로 나눠진다는 것은 K가 약수라는 뜻,
        그리고 K로 나눈 값이 N 이하의 자연수가 K를 약수로 갖는 자연수의 개수가 됨.
        7/1 -> 7이하의 수들 중 1을 약수로 갖는 수가 7개
        7/2 = 3 -> 위와 같은 원리 2, 4, 6
        그런데 개수의 합이 아닌, 수들의 합이므로 2의 경우 2 * 3(2의 개수)이고
        이를 1~N까지 합을 구한다.
         */
        int N;
        long res = 0; // 1000000까지 입력할 것을 고려

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            res += i * (N/i);
        }
        System.out.println(res);
    }
}
// 출처: https://codejb.tistory.com/4 [게임 개발 낙서장:티스토리]