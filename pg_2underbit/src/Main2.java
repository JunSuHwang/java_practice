import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        long[] numbers = {2, 7, 88};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static long[] solution(long[] numbers) {
        for (int i = 0; i < numbers.length; i++)        {
            long num = numbers[i];
            System.out.println(Long.toBinaryString(num));
            // 바꿀수 있는 비트가 최대 2개인데 마지막, 마지막에서 두 번째 비트가 1이면 1 더하면 됨.
            if ((num & 1L) == 0 || (num & 2L) == 0)     {
                numbers[i] = num + 1;
                continue;
            }

            int index = 2;
            // num의 최대 자릿수 + 1 구하기
            while (((1L << index) & num) != 0)  index++;

            // 1 + num의 수에 1직전 1을 제거하여 최소값으로 만듬
            numbers[i] = (num | (1L << index)) - (1L << (index - 1));
        }

        return numbers;
    }
}