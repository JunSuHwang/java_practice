import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        // 들어오는 수가 -2^31 < <2^31 이므로 오버플로우 고려
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            // 같은 수일 경우 가장 왼쪽 비트를 가져와 비교
            if(Math.abs(o2) == Math.abs(o1)) return (o2>>>31)-(o1>>>31);
            else return Math.abs(o1) - Math.abs(o2);
        });
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(bf.readLine());
            if(t == 0 && q.isEmpty()) sb.append("0\n");
            else if(t == 0) sb.append(q.poll()).append("\n");
            else q.add(t);
        }
        System.out.print(sb);
    }
}