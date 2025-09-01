import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class MyMain {
        // 왼쪽 수 배열을 오름차순 정렬(같을 시 수가 작은 거 부터), 단 해당 수를 알아야함.
        // 조건에 맞게 swap?
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        List<Integer> list = new LinkedList<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i < N+1; i++) {
            arr[i-1] = Integer.parseInt(st.nextToken());
            list.add(i);
        }
        list.sort((o1, o2) -> {
            if (arr[o1 - 1] == arr[o2 - 1]) return o1 - o2;
            else return Integer.compare(arr[o1 - 1], arr[o2 - 1]);
        });
        int[] sorted = Arrays.stream(arr).sorted().toArray();

        System.out.println(list);
        System.out.println(Arrays.toString(sorted));

    }
}