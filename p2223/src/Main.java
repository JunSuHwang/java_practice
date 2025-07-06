import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /* t는 주어진 시간, x는 시간당 금화 개수
        m은 몬스터의 종류(수), d는 몬스터와의 위치, s는 시간당 움직이는 거리
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] darr = new int[m];
        int[] sarr = new int[m];
        int[] carr = new int[m];
        Arrays.fill(carr, 0);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            darr[i] = Integer.parseInt(st.nextToken());
            sarr[i] = Integer.parseInt(st.nextToken());
        }

        // 0부터 t초까지 매 시간을 계산
        for (int i = 0; i < t; i++) {
            boolean getCoin = true;
            // 금화 얻기 or 멈추기
            for (int j = 0; j < m; j++) {
                // 현재 거리에서 +몬스터 거리인지 판단(지금 금화 얻으면 잡히는지)
                if(carr[j]+sarr[j] >= darr[j]) {
                    getCoin = false;
                    break;
                }
            }
            if(getCoin) {
                result += x;
                for (int j = 0; j < m; j++) {
                    carr[j] += sarr[j];
                }
            } else {
                for (int j = 0; j < m; j++) {
                    if(carr[j]-sarr[j] < 0) carr[j] = 0;
                    else carr[j] -= sarr[j];
                }
            }
        }
        System.out.print(result);
    }
}