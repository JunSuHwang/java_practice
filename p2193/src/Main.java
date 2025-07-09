import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
처음 1로 시작.
1 다음일 경우 0만 가능.
0 다음 0 or 1 반복...

101 or 100 -> 2
1010  1000 or 1001 -> 맨끝 0 1개  1 2개
10101 or 10100  10001 or 10000  10010 -> 5 0 3개 1 2개
++ 수가 커서 int형말고 long형으로 해야 정답.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long n0 = 1; long n1 = 0;
        for (int i = 1; i < N; i++) {
            long t0 = n1;
            long t1 = n1 + n0;
            n0 = t0;
            n1 = t1;
        }
        System.out.print(n0+n1);
    }
}