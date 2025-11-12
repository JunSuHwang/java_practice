import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input.txt 사용시 테스트 쉽게 가능.
//        System.setIn(new FileInputStream("p1208_swea/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;
        for (int tc = 1; tc <= t; tc++) {
            int dump = Integer.parseInt(br.readLine());

            int[] boxes = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                boxes[i] = Integer.parseInt(st.nextToken());
            }
            int[] sorted = Arrays.stream(boxes)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(i -> i)
                    .toArray();
            int left = 0;
            int max = sorted[0];
            int right = 99;
            int min = sorted[99];
            while(dump > 0) {
                // 큰 값에서 빼기
                sorted[left]--;
                // 다음 위치 값이 더 크다면 위치를 오른쪽으로 옮긴다.
                if(sorted[left+1] > sorted[left]) left++;
                // 다음 값과 현재 값이 같으면 최대값들이 처음과 같은 경우이므로 처음으로 돌아가 다시 옮긴다.
                else if(sorted[left] == sorted[left+1]) left = 0;

                sorted[right]++;
                if(sorted[right-1] < sorted[right]) right--;
                else if(sorted[right] == sorted[right-1]) right = 99;
                dump--;
            }
            max = Arrays.stream(sorted).max().orElse(0);
            min = Arrays.stream(sorted).min().orElse(999);
            System.out.println("#" + tc + " " + (max - min));
        }
    }
}