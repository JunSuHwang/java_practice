import java.util.Scanner;

        // 모범답안 참고
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        double res = 0.0;
        // 전체 N Combination M
        double p = Combination(n, m);

        // M개 뽑았는데 K개가 맞는 경우 * N-M개 중에서 M-K개 뽑는 경우(N개의 공 중 이미 맞는 M개의 공을 뽑았으므로)
        // K+1, K+2, ... ,M
        while(m >= k) {
            if(n-m < m-k) {
                k++;
                continue;
            }

            double c = Combination(m, k) * Combination(n-m, m-k);

            res += c/p;
            k++;
        }

        System.out.println(res);
    }

    static long Combination(int n, int r) {
        int c = 1;
        int p = 1;

        while(r > 0) {
            c *= n--;
            p *= r--;
        }
        return c / p;
    }
}