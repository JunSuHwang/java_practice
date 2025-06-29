import java.util.Arrays;
import java.util.Scanner;

public class Main_sc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int s = 1;
        while(true) {
            n = Integer.parseInt(sc.nextLine());
            if(n == 0) break;
            String[] names = new String[n+1];
            Boolean[] check = new Boolean[n+1];
            int result = -1;
            Arrays.fill(check, false);
            for(int i = 1; i <= n; i++) {
                names[i] = sc.nextLine();
            }
            for(int i = 0; i < 2*n-1; i++) {
                // 받으려는 수가 한자리 수 이상이면 잘못된 값이 들어가게 됨.
                // int target = Character.getNumericValue(sc.nextLine().charAt(0));
                int target = sc.nextInt();
                // " B\n" or " A\n" 처리하기
                sc.nextLine();
                check[target] = !check[target];
            }
            for(int i = 1; i < check.length; i++) {
                if(check[i]) {
                    result = i;
                    break;
                }
            }
            System.out.println(s++ + " " + names[result]);
        }
    }
}
/*
    BufferedReader 사용시 걸린 시간 : 132ms
    Scanner 사용시 걸린 시간 : 228ms
 */