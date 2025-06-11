import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int i = 1;
        for(; i <= n; i++) {
            for(int j = 1; j <= n-i; j++) System.out.print(" ");
            for(int j = 1; j <= 2*i-1; j++) System.out.print("*");
            // 뒤에도 공백 붙이면 백준 출력 오류
//            for(int j = 1; j <= n-i; j++) System.out.print(" ");
            System.out.println();
        }
        i = i-2;
        for(; i >= 1; i--) {
            for(int j = 1; j <= n-i; j++) System.out.print(" ");
            for(int j = 1; j <= 2*i-1; j++) System.out.print("*");
//            for(int j = 1; j <= n-i; j++) System.out.print(" ");
            if(i > 1) System.out.println();
        }
    }
}