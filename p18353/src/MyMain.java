import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MyMain {
    // 6 5 4 3 2 1 100 99 98 97 96 case 만족해야함
    // 6 5 4 3 100 99 98 97 96 97 도 마찬가지
    // 15 11 4 8 5 2 4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] diff = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.toString(arr));
//        int[] sorted = Arrays.stream(arr)
//                        .boxed()
//                                .sorted(Comparator.reverseOrder())
//                                        .mapToInt(i -> i)
//                                                .toArray();
//        System.out.println(Arrays.toString(sorted));
        int result = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] <= arr[i+1]) result++;
            diff[i] = arr[i+1] - arr[i];
        }
        System.out.println(result);
        System.out.println(Arrays.toString(diff));

    }
}