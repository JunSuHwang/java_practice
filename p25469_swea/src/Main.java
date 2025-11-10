import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] arr = new char[H][W];
            int result = 0;
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = st.nextToken().toCharArray();
            }
            int rCount = 0;
            int cCount = 0;
            for (int i = 0; i < H; i++) {
                int count = 0;
                for (int j = 0; j < W; j++) {
                    if(arr[i][j] == '#') count++;
                }
                if(count == W) rCount++;
            }
            for (int i = 0; i < W; i++) {
                int count = 0;
                for (int j = 0; j < H; j++) {
                    if(arr[j][i] == '#') count++;
                }
                if(count == H) cCount++;
            }
            if(rCount == H && cCount == W) {
                result = Math.min(rCount, cCount);
            } else {
                result = rCount+cCount;
            }
            System.out.println(result);
        }
    }
}