import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M = 0;
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        // System.out.println(N + " " + M);
        String[] list = new String[N];
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            list[i] = br.readLine();
            hashMap.put(list[i], i);
        }

        for (int i = 0; i < M; i++) {
            String q = br.readLine();
            if (q.charAt(0) >= '0' && q.charAt(0) <= '9') {
                System.out.println(list[Integer.parseInt(q)-1]);
            } else {
                System.out.println(hashMap.get(q)+1);
            }
        }
    }
}