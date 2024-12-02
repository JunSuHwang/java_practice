import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        int[] abc = new int[26];
        Arrays.fill(abc, 0);
        int pcount = 0;
        for(int i = 0; i < s.length(); i++) {
            abc[s.charAt(i) - 'A']++;
        }
        for(int i = 0; i < abc.length; i++) {
            if(abc[i] % 2 != 0) pcount++;
            if(pcount == 2) return "I'm Sorry Hansoo";
        }

        String left = "";
        String mid = "";
        String right = "";

        for(int i = 0; i < abc.length; i++) {
            while(abc[i] != 0) {
                if(abc[i] == 1) {
                    mid = mid + (char)('A' + i);
                    abc[i]--;
                } else {
                    left = left + (char)('A' + i);
                    right = (char)('A' + i) + right;
                    abc[i] -= 2;
                }
            }
        }

        return left+mid+right;
    }
}