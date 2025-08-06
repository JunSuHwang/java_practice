import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        /*
        1이나 9면 계단수가 하나로만 갈라짐. 나머지는 2개씩
        처음 0이 아닌데 0이 들어갈 수 있다.
        1->2 9->8
        123456789
        0123456789

        arr[1] -> 0111111111
        arr[2] -> 1222222211
        arr[3] -> 2344444331
         */
        int[][] arr = new int[101][10];
        Arrays.fill(arr[1], 1);
        arr[1][0] = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if(j == 0) arr[i][0] = arr[i-1][1] % 1000000000;
                else if(j == 9) arr[i][9] = arr[i-1][8]% 1000000000;
                else {
                    arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]) % 1000000000;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += arr[N][i];
            sum %= 1000000000;
        }
        System.out.print(sum);
    }
}