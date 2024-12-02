import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int count_0 = 0;
        int count_1 = 0;
        if(input.charAt(input.length()-1) == '0') {
            input = input + '1';
        } else {
            input = input + '0';
        }
        //System.out.println(input);
        for (int i = 0; i < input.length()-1; i++) {
            char next = input.charAt(i+1);
            if(input.charAt(i) != next) {
                if(input.charAt(i) == '0') {
                    count_0++;
                } else {
                    count_1++;
                }
            }
        }
        //System.out.println("count_0 : " + count_0 + ", count_1 : " + count_1);
        System.out.print(Math.min(count_1, count_0));
    }
}