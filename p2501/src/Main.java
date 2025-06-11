import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, K;
        N = sc.nextInt();
        K = sc.nextInt();
//        System.out.println(N + " " + K);
        // 약수
        int i = 1;
        // 번째
        int num = 0;
        int result = 0;
        while(num != K) {
            // 약수가 맞으면
            if(N % i == 0) {
                num++;
                result = i;
            }
            // 약수가 N보다 크거나 찾는 번째가 K를 넘어가면 out
            if(i > N || num > K) {
                result = 0;
                break;
            }

            i++;
        }
        System.out.println(result);
    }
}