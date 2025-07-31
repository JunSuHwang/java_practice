import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MyMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        String[] s = bf.readLine().split(" ");
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[N];
        for (int i = 0; i < s.length; i++) {
            int t = Integer.parseInt(s[i]);
            arr[i] = t;
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        System.out.println(map.values());
        int equal = N - map.values().stream().max(Comparator.comparingInt(o -> o)).orElse(500);
        System.out.println("max: " + equal);
        // 앞수와 뒷수의 차이를 저장
        HashSet<Integer> set = new HashSet<>();
        int prev = arr[0];
        for (int i = 1; i < N; i++) {
            set.add(arr[i] - prev);
            prev = arr[i];
        }
        int min = equal;
        for(Integer i : set) {
            if(i == 0) continue;
            int count = 0;
            for (int j = 1; j < N; j++) {
                if(count >= min) break;
                // arr[0]이 틀리면?
                if(arr[j] != arr[0] + i*j) count++;
            }
            System.out.println(count);
            min = Math.min(min, count);
        }
        System.out.println(set);
        System.out.println(min);
    }
}