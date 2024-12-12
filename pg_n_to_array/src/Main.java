import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        long n =  9000000000L;
        System.out.println(Arrays.toString(Mysolution(n)));
        System.out.println(Arrays.toString(solution(n)));
    }
    public static int[] Mysolution(long n) {
        String s = Long.toString(n);
        List<Integer> result = s.chars()
                        .boxed()
                .map(i -> i-48)
                .collect(Collectors.toList());
        Collections.reverse(result);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // 모범 답안
    public static int[] solution(long n) {
        // StringBuilder의 reverse와 getNumbericValue 활용
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }
}