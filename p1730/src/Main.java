import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(arr[i], '.');
        int y = 0;
        int x = 0;
        String s = bf.readLine();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'D') {
                if(y+1 < N){
                    // U or D or .이면 ㅣ 그리기
                    if(arr[y][x] == '-' || arr[y][x] == '+') arr[y][x] = '+';
                    else arr[y][x] = '|';

                    // D 이동한 후 ㅣ 그리기
                    y++;
                    if(arr[y][x] == '-' || arr[y][x] == '+') arr[y][x] = '+';
                    else arr[y][x] = '|';
                }
            } else if (c == 'U') {
                if(y-1 >= 0){
                    if(arr[y][x] == '-' || arr[y][x] == '+') arr[y][x] = '+';
                    else arr[y][x] = '|';

                    y--;
                    if(arr[y][x] == '-' || arr[y][x] == '+') arr[y][x] = '+';
                    else arr[y][x] = '|';
                }
            } else if (c == 'L') {
                if(x-1 >= 0){
                    if(arr[y][x] == '|' || arr[y][x] == '+') arr[y][x] = '+';
                    else arr[y][x] = '-';

                    x--;
                    if(arr[y][x] == '|' || arr[y][x] == '+') arr[y][x] = '+';
                    else arr[y][x] = '-';
                }
            } else if (c == 'R') {
                if(x+1 < N){
                    if(arr[y][x] == '|' || arr[y][x] == '+') arr[y][x] = '+';
                    else arr[y][x] = '-';

                    x++;
                    if(arr[y][x] == '|' || arr[y][x] == '+') arr[y][x] = '+';
                    else arr[y][x] = '-';
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}