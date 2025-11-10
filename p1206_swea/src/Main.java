import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int t = 1; t <= 10; t++){
            int N = Integer.parseInt(br.readLine());
            int[] heights = new int[N];
            int result = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 2; i < N-2; i++) {
                int max = 0;
                for (int j = i-2; j < i+3; j++) {
                    if(j == i) continue;
                    if(max < heights[j]) max = heights[j];
                }
                int diff = heights[i] - max;
                if(diff > 0) result += diff;
            }
            System.out.println("#"+ t + " " + result);
        }
    }
}