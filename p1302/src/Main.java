import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            String target = bf.readLine();
            if(map.containsKey(target)) {
                map.replace(target, map.get(target)+1);
            } else {
                map.put(target, 1);
            }
        }

        List<String> keyset = new ArrayList<>(map.keySet());
        keyset.sort((o1, o2) -> {
            int result = map.get(o2).compareTo(map.get(o1));
            if(result == 0){
                return o1.compareTo(o2);
            } else {
                return result;
            }
        });
//        System.out.println(map.toString());
        // 백준 자바15 제출시 getFirst() 지원 x
        System.out.print(keyset.get(0));
    }
}