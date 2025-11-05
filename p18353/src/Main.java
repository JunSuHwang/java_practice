import java.util.*;
import java.io.*;
/*
    모범단안, 최장 증가 부분 수열(LIS)을 찾는 문제 -> dp이용
    LIS를 생각 못하고 단순히 현재, 다음 값 비교로 푸는 방식과
    현재, 다음 값의 차이로 푸는 방식을 생각했지만 풀지 못했다.
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [] arr;
    static int []dp;
    static int N;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for(int i=0; i<N; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j] > arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            System.out.println("i : " + i + ", " + Arrays.toString(dp));
            result = Math.max(result, dp[i]);
        }
        System.out.println(N-result);

    }
}
// https://jjw7.tistory.com/49