import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MyMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        /*
        g(3) = f(1) + f(2) + f(3)
        N의 약수를 구할 때 N의 약수의 약수 활용 가능한가?
        f(20) = 1, 2, 4, 5, 10, 20
        f(10) = 1, 2, 5, 10
         */
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    System.out.print(j + " ");
                    sum += j;
                }
            }
            arr[i] = sum;
            System.out.println();
        }
        System.out.print(Arrays.stream(Arrays.stream(arr).toArray()).sum());
    }
}