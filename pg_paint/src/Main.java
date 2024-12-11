import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int m = 4;
        int[] section = {1, 3};
        System.out.println(solution(n, m, section));
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        int i = section[0];
        while(i <= n) {
            if (Arrays.binarySearch(section, i) >= 0) {
                answer++;
                i += m;
            }
            else {
                i++;
            }
        }
        return answer;
    }
}