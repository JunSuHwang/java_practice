import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        int[] arr = new int[N+1];
        Arrays.fill(arr, 0);
        for(int t = 0; t < M; t++) {
            int i, j, k;
            i = sc.nextInt();
            j = sc.nextInt();
            k = sc.nextInt();

            for(int t2 = i; t2 <= j; t2++) {
                arr[t2] = k;
            }
        }

        for(int t = 1; t <= N; t++) {
            System.out.print(arr[t] + " ");
        }
    }
}