import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        int[] roads = new int[input1.length];
        int[] gstation = new int[input2.length];
        for(int i = 0; i < n; i++) {
            if(i < n-1) {
                roads[i] = Integer.parseInt(input1[i]);
            }
            gstation[i] = Integer.parseInt(input2[i]);

        }

        System.out.println(solution(n, roads, gstation));
    }

    public static int solution(int n, int[] roads, int[] gstation) {
        int total = 0;
        int total_roads = Arrays.stream(roads).sum();
        for(int i = 0; i < roads.length-1; i++) {
            total_roads -= roads[i];
            int current_cost = gstation[i] * total_roads;
            int next_cost = gstation[i+1] * total_roads;
            if(current_cost > next_cost) {
                total += gstation[i] * roads[i];
            } else {
                total += (total_roads + roads[i]) * gstation[i];
                break;
            }
        }
        return total;
    }
}