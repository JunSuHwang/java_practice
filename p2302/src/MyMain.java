import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        //
        for (int i = 0; i < M; i++) {
            list.add(Integer.parseInt(bf.readLine()));
        }
        list.add(N+1);
        int sum = 1;
        int idx = 0;
        for(int i : list) {
            if(i-idx > 1) sum *= (i-idx-1);
            idx = i;
        }
        System.out.print(sum);
    }
}