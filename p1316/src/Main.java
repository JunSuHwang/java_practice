import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int result = 0;
        for(int t = 0; t < N; t++) {
            String target = sc.nextLine();
            ArrayList<Character> list = new ArrayList<>();
            int n = 1;
            char prev = target.charAt(0);
            list.add(prev);
            boolean check = true;
            while(n < target.length()) {
//                System.out.println("prev = "+prev+", target= "+target.charAt(n));
                // 현재 문자가 바로 이전 문자와 같으면 다음 반복
                if(target.charAt(n) == prev) {
                    n++;
                    continue;
                }
                else {
                    // 현재 문자가 이미 나왔던 문자이면 그룹 문자 x
                    if(list.contains(target.charAt(n))) {
                        check = false;
                        break;
                    }

                    // 현재 문자가 새로 나온 문자이면 기억
                    list.add(target.charAt(n));
                }
                // 다음 반복 세팅
                prev = target.charAt(n);
                n++;
            }
            if(check) result++;
        }
        System.out.println(result);
    }
}