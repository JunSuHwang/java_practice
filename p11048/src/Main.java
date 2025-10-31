import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
/*
 모범 답안.
 dfs로 풀었으나 시간초과가 발생함.
 result 배열을 두어 dp로 해결.
 대각선 이동은 항상 오른쪽 아래나 아래 오른쪽 이동이 더 사탕이 많기 때문에 고려x
 max(왼쪽에서 오른쪽 이동한 값, 위에서 아래로 이동한 값)으로 점화식 적용
 */
public class Main {
    static int[][] arr;
    static int[][] result;

    public static void main(String[] args) throws IOException  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        //String input = br.readLine();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n+1][m+1];
        result = new int[n+1][m+1];

        for(int i = 1 ; i <= n ; i ++) {
            for(int j = 1 ; j <= m ; j ++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 1 ; i <= n ; i ++) {
            for(int j = 1; j <= m ; j ++) {
                result[i][j] = Integer.max(arr[i][j] + result[i-1][j], arr[i][j] + result[i][j-1]);
            }
        }

        System.out.println(result[n][m]);
    }
}