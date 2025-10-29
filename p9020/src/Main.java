import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        T개의 입력 n은 짝수이고 두 소수의 합으로 이루어진다. 소수는 무조건 홀수이지만 소수가 아닌 홀수 존재.
        소수 배열을 만들어 놓고, 이중 반복문으로 5000개 크기의 고정배열을 채우고 정답 출력 but 소수배열 만드는거 오래걸릴수도.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] arr = new int[10001][2];
        // 소수 리스트
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        for (int i = 3; i <= 9999; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                list.add(i);
            }

        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                // 소수끼리 더한 현재 값을 arr에 각각 저장.
                int current = list.get(i) + list.get(j);
                int diff = Math.abs(list.get(i) - list.get(j));
                if(current > 10000) continue;
                // 처음 값 저장이 아니고, 저장된 차이 값이 현재 차이 값보다 작으면 continue.
                if(arr[current][0] != 0 && arr[current][1] != 0 && diff > Math.abs(arr[current][0] - arr[current][1])) continue;
                arr[current][0] = list.get(i) > list.get(j) ? list.get(j) : list.get(i);
                arr[current][1] = list.get(i) > list.get(j) ? list.get(i) : list.get(j);
            }
        }
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n  = Integer.parseInt(st.nextToken());
            System.out.println(arr[n][0] + " " + arr[n][1]);
        }
    }
}