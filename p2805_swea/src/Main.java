import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("p2805_swea/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for(int i = 0; i < N; i++) {
                String inputs = br.readLine();
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Character.getNumericValue(inputs.charAt(j));
                }
            }
            int y = 0;
            int x1 = N/2;
            int x2 = N/2;
            int result = 0;
            while(true) {
                for(int i = x1; i <= x2; i++) {
                    result += arr[y][i];
                }
                y++; x1--; x2++;
                if(x2 == N) break;
            }
            if(y < N){
                x1 = 1;
                x2 = N-2;
                while(true) {
                    for(int i = x1; i <= x2; i++) {
                        result += arr[y][i];
                    }
                    if(x1 == x2) break;
                    y++; x1++; x2--;
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }

}
