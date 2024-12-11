import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "aukks";
        int index = 5;
        String skip = "wbqd";
        System.out.println(solution(s, skip, index));
    }

    public static String solution(String s, String skip, int index) {
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, 1);
        for(char c : skip.toCharArray()) {
            int i = c-'a';
            alphabet[i] = 0;
        }

        char[] sarray = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for(char c : sarray) {
            int i = c-'a';
            int count = 0;
            while(count < index) {
                i++;
                i %= 26;
                if(alphabet[i] == 1){
                    count++;
                }
                //System.out.println("i:"+i);
            }
            result.append((char) ('a' + i));
        }
        return result.toString();
    }
}