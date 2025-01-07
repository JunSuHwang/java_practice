import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] number = {-1, 1, -1, 1};
        System.out.println(solution(number));
    }

    static public int solution(int[] number) {
        int answer = 0;
        int[] result = Arrays.stream(number).sorted().toArray();
        for(int i = 0; i < result.length-2; i++) {
            int n0 = result[i];
            for(int j = i+1; j < result.length-1; j++) {
                for(int k = j+1; k < result.length; k++) {
//                    System.out.println(result[i] + ", " + result[j] + ", " + result[k]);
                    if(result[i] + result[j] + result[k] == 0) answer++;
                }
            }
        }
        return answer;
    }
}