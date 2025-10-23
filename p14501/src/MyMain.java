import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int current = i;
            int total = 0;
            while (true) {
//                System.out.println("current : " + current + ", total : " + total);
                total += arr[current][1];
                current += arr[current][0];

                if(current > N) break;
            }
            max = Math.max(total, max);
        }

        System.out.println(max);
    }
}