import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MyMain {
    public static void main(String[] args) throws IOException {
        /*
        dp로 풀이 생각. i/3번째 i/2번째 i-1번째에 연산 횟수를 기록하며 계산.
        1 2 3 4 5 6 7 8 9 10
        3 3 2 2 1 2 3 2 1  0
         */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[N] = 0;
        for (int i = N; i > 1; i--) {
            if(i % 3 == 0) arr[i/3] = Math.min(arr[i]+1, arr[i/3]);
            if(i % 2 == 0) arr[i/2] = Math.min(arr[i]+1, arr[i/2]);
            arr[i-1] = Math.min(arr[i]+1, arr[i-1]);
        }
        System.out.println(Arrays.toString(arr));
    }
}