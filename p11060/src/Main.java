import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int idx = 0;
        while(st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        idx = 0;
        // 1칸이면 점프 0회
        if(N > 1) {
            while(idx <= N-1) {
                // 오른쪽 d칸 내로 점프
                int d = arr[idx];
                // 점프시 오른쪽 끝에 갈 수 있으면 종료
                if(idx + d >= N-1) {
                    result++;
                    break;
                }
                int max = 0;
                int max_i = -1;
                // d칸 내의 값을 중 max 값과 해당 인덱스 값을 계산, 0이면 최종 -1
                for(int i = idx+1; i <= idx+d; i++) {
                    // 해당 칸으로 점프했을 때의 위치와 해당 칸에 점프했을 때 갈 수 있는 거리를 함께 고려.
                    if(arr[i] != 0 && arr[i]+i >= max+max_i) {
                        max = arr[i];
                        max_i = i;
                    }
                }
                if(max == 0) {
                    result = -1;
                    break;
                } else {
                    result++;
                    idx = max_i;
                }
            }
        }

        System.out.println(result);
    }
}