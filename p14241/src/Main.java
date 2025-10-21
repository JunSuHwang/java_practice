import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    N = 3, arr = {1, 2, 3}
    1. 1+2 = 3 & 1*2 = 2 -> 3+3 = 6 3*3 = 9 total=11
    2. 2+3 = 5 & 2*3  = 6 -> 5+1 = 6 5*1 = 5 total=11
    3. 1+3 = 4 & 1*3 = 3 -> 4+2 = 6 4*2 = 8 total=11
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int size = arr[0];
        int sum = 0;
        for (int i = 1; i < N; i++) {
            sum += size * arr[i];
            size = size + arr[i];
        }
        System.out.println(sum);
    }
}