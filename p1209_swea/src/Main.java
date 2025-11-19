import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("p1209_swea/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        for(int t = 1; t <= T; t++) {
            int max = 0;
            br.readLine();
            int[][] arr = new int[100][100];
            for(int i = 0; i < 100; i++) {
                int sum = 0;
                String[] inputs = br.readLine().split(" ");
                for(int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(inputs[j]);
                    sum += arr[i][j];
                }
                max = Math.max(sum, max);
            }
            for(int i = 0; i < 100; i++) {
                int sum = 0;
                for(int j = 0; j < 100; j++) {
                    sum += arr[j][i];
                }
                max = Math.max(sum, max);
            }
            int idx = 0;
            int sum = 0;
            for(int i = 0; i < 100; i++) {
                sum += arr[i][idx++];
            }
            max = Math.max(sum, max);
            idx = 99;
            sum = 0;
            for(int i = 99; i >= 0; i--) {
                sum += arr[i][idx--];
            }
            max = Math.max(sum, max);
            System.out.println("#" + t + " " + max);
        }
    }

}
