import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        /* 양이 같은 물통끼리 합칠 수 있다는 것이 관건.
        이진수로 변환하면 64, 32, 16 ... 꼴로 변환
        이진수 변환시 1의 총 개수가 K보다 크면 물통을 더 사서 합쳐야 함.
         */
        String b = Integer.toBinaryString(N);
        int count = 0;
        int idx = 0;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '1') count++;
        }
        if (count > K) {
            count = 0;
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == '1') count++;
                if (count == K) {
                    idx = i;
                    break;
                }
            }
            String target = b.substring(idx);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < target.length(); i++) {
                if (target.charAt(i) == '0') sb.append('1');
                else sb.append('0');
            }
            System.out.print(Integer.parseInt(String.valueOf(sb), 2) + 1);
        } else {
            // 1의 개수가 K이하일 경우는 물통 개수가 충분할 경우
            System.out.print(0);
        }
    }
}