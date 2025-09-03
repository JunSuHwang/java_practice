import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j+i <= s.length(); j++) {
                String t = s.substring(i, i+j);
                list.add(t);
            }
        }
        int result = list.stream().distinct().toArray().length;
        System.out.print(result);
    }
}