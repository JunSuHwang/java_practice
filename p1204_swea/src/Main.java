import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("p1204_swea/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            br.readLine();
            String[] input = br.readLine().split(" ");
            int[] arr = new int[101];
            for(int i = 0; i < input.length; i++) {
                int current = Integer.parseInt(input[i]);
                arr[current]++;
            }
            int idx = 0;
            int max = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] >= max) {
                    if(i >= idx) idx = i;
                    max = arr[i];
                }
            }
            System.out.println("#" + t + " " + idx);
        }
    }

}