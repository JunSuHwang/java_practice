import java.util.*;
import java.io.*;

public class Main {
    /*
    모범 답안
    최장 부분 수열 알고리즘 이해 한 것 :
    1. 0~(i-1) 값 j중 A[j]가 A[i] 보다 큰 값이 나온다 -> D[j]는 A[j]를 마지막으로 갖는 최장 수열의 길이이므로
        이 뒤에 A[i]를 붙여서 최장 수열을 늘릴 수 있다.
    2. 하지만 j가 마지막으로 오는 최장 수열보다 더 긴 최장 수열이 이미 나왔다면
        D[i]에 저장되어 있으므로 이 두 값 중 큰 것을 저장한다.
    */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] D = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
            D[i] = 1;  // 자기 자신. 없으면 1이기에 1로 초기화
        }

        for(int i=0;i<N;i++) { //기준값
            for(int j=0;j<i;j++) { //이전값들
                if(A[j] > A[i]) {
                    D[i] = Math.max(D[i], D[j]+1);
                }
            }
            result = Math.max(result, D[i]);
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}