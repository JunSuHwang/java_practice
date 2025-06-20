import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"cnbc", "anbcd"};
        int n =1;
        System.out.println(Arrays.toString(Arrays.stream(solution(strings, n)).toArray()));
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n) > o2.charAt(n)) {
                    return 1;
                } else if (o1.charAt(n) < o2.charAt(n)) {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        return strings;
    }
}