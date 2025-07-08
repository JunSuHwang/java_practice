import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s1 = bf.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = Character.getNumericValue(s1.charAt(j));
            }
        }
        int result = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int current = arr[i][j];
                // k가 1일때 성공시 정사각형 크기는 2, k가 2일때는 크기 3...
                for (int k = 1; i+k < N && j+k < M; k++) {
                    //아래 & 오른 & 대각 체크
                    if(arr[i+k][j] == current && arr[i][j+k] == current
                        && arr[i+k][j+k] == current) result = Math.max(result, k+1);
                }
            }
        }

        System.out.print(result*result);
    }
}