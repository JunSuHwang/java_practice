import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        int n = 0;
        int s = 1;
        while(true) {
            n = Integer.parseInt(bf.readLine());
            if(n == 0) break;
            String[] names = new String[n+1];
            Boolean[] check = new Boolean[n+1];
            int result = -1;
            Arrays.fill(check, false);
            for(int i = 1; i <= n; i++) {
                names[i] = bf.readLine();
            }
            for(int i = 0; i < 2*n-1; i++) {
                st = new StringTokenizer(bf.readLine());
                int target = Integer.parseInt(st.nextToken());
                check[target] = !check[target];
            }
            for(int i = 1; i < check.length; i++) {
                if(check[i]) {
                    result = i;
                    break;
                }
            }
            System.out.println(s++ + " " + names[result]);
        }
    }
}