import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long[] numbers = {2, 7};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            String x = Long.toBinaryString(numbers[i]);
            String smax = "1"+x;
            long max = Long.parseLong(smax, 2); // max가 long 넘어갈 가능성?
            long min = Long.MAX_VALUE;
            for(long target = numbers[i]+1; target <= max; target++) {
                int count = 0;
                String starget = Long.toBinaryString(target);
                if(starget.length() - x.length() == 1) x = "0"+x;
                // System.out.println(starget);
                for(int j = 0; j < x.length(); j++) { // long의 이진수의 String의 길이가 int 넘어갈 가능성?
                    if(x.charAt(j) != starget.charAt(j)) count++;
                    if(count >= 3) break;
                }
                if(count == 3) continue;
                else {
                    min = target;
                    break;
                }
            }
            answer[i] = min;
        }
        // 설마 x를 String으로 바꾼 것을 0이나 1을 바꾸면서 찾아야하나??
        return answer;
    }
}