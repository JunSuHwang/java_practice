import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    평범한 반복문으로 통과하였지만 dp방식을 적용한다면
    합계 배열 sum을 생성하고 sum[i]는 arr[0] ~ arr[i] 까지의 합을 저장.
    구간합을 계산할때(i~j) sum[j]-sum[i-1] 하면 되는 아이디어까지는 생각.
    -> 검색하니 이 방식으로 O(N^2)에서 O(N)으로 구할 수 있다고 알려짐.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            arr[i] = t;
        }
        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int j = from-1; j < to; j++) {
                sum += arr[j];
            }
            System.out.println(sum);
        }
    }
}