import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         1 -> 1
         2 -> 1+1 2
         3 -> 1+1+1 2+1 1+2 3
         4 -> 1+1+1+1 1+1+2 1+2+1 2+1+1 2+2 3+1 1+3
         5 -> 전꺼에 1 더하기 + 전전꺼에 2 더하기 전전전꺼에 3 더하기
         결국 n = n-1 + n-2 + n-3
         */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        int[] arr = new int[1000001];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int j = 4; j < arr.length; j++) {
            arr[j] = ((arr[j-1] + arr[j-2])%1000000009 + arr[j-3])%1000000009;
        }
        for (int i = 0; i < T; i++) {
            int t = Integer.parseInt(bf.readLine());
            System.out.println(arr[t]);
        }
    }
}