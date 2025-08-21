import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class MyMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

//        int N = Integer.parseInt(bf.readLine());
//        int[] arr = new int[N];
//        String[] inputs = bf.readLine().split(" ");
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(inputs[i]);
//        }
        int N = 7;
        int[] arr = {8, 15, 1, 20, 4, 10, 3};
        arr = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int[] up;
        int[] down;
        if(N % 2 == 0) {
            up = new int[N/2];
            down = new int[N/2];
            int di = 0;
            for (int i = 0; i < N; i++) {
                if(i < N/2) up[i] = arr[i];
                else down[di++] = arr[i];
            }
        } else {
            up = new int[N/2+1];
            down = new int[N/2];
            int di = 0;
            for (int i = 0; i < N; i++) {
                if(i < N/2+1) up[i] = arr[i];
                else down[di++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(up));
        System.out.println(Arrays.toString(down));
        int sum = 0;
        for (int i = 1; i < N; i++) {
            System.out.print(Math.abs(arr[i-1] - arr[i]) + " ");
            sum += Math.abs(arr[i-1] - arr[i]);
        }
        // 절반 나누고 하위 N/2 개와 상위 N/2개를 사이에 배치하는 방법

        System.out.println(sum);
    }
}