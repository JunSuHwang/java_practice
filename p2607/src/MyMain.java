import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[] s = bf.readLine().toCharArray();
        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            int count = 0;
            char[] current = bf.readLine().toCharArray();
            for (char value : s) {
                for (char c : current) {
                    if (value == c) {
                        count++;
                    }
                }
            }
            if(count <= 1 && Math.abs(s.length-current.length) <= 1) result++;
        }
        System.out.println(result);
    }
}