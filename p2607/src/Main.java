import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 단순히 브루트 포스로 탐색하여 일치하는 문자의 개수를 세려고 했으나
 동일한 문자가 2개 이상이 나오는 것을 해결할 방법이 떠오르지 않아 실패하였다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String first = bf.readLine();
        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            String str = bf.readLine();
            int cnt = 0;    // 같은 단어 개수
            int[] word = new int[26];
            for (int j = 0; j < first.length(); j++) {
                word[first.charAt(j) - 'A']++;
            }
            for (int j = 0; j < str.length(); j++) {
                if(word[str.charAt(j) - 'A'] > 0) {
                    cnt++;
                    word[str.charAt(j) - 'A']--;
                }
            }

            // 기준 문자열 길이와 비교 문자열 길이 차이
            // 같은 경우 or 한 글자만 바뀐 경우
            if(first.length() == str.length()
                    && (first.length() == cnt || first.length() - 1 == cnt)) {
                result++;
            }
            // 비교 문자열이 짧은 경우 (제거)
            else if (first.length() == str.length() - 1 && str.length() - 1 == cnt) {
                result++;
            }
            // 비교 문자열이 긴 경우 (추가)
            else if (first.length() == str.length() + 1 && str.length() == cnt) {
                result++;
            }
        }
        System.out.println(result);
    }
}
// https://jyunslog.tistory.com/22