import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        double[] list = new double[N];
        double max = 0.0;
        for(int i = 0; i < N; i++) {
            list[i] = Double.parseDouble(bf.readLine());
        }
        for(int i = 0; i < N; i++) {
            if(list[i] > max) max = list[i];
            double sum = list[i];
            for(int j = i+1; j < N; j++) {
                sum *= list[j];
                if(sum > max) max = sum;
            }
        }
        // 넷째자리에서 반올림
        max = Math.round(max * 1000) / 1000.0;
        // 소수점 셋째자리까지 출력
        System.out.printf("%.3f%n", max);
    }
}