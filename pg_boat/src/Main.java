import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] people = {70, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        ArrayList<Integer> list = Arrays.stream(people).boxed().sorted().collect(Collectors.toCollection(ArrayList::new));
        int count = 0;
        while(!list.isEmpty()) {
            int e = list.get(0);
            boolean success = false;
            for(int i = list.size()-1; i >= 1; i--) {
                if(e + list.get(i) <= limit) {
                    count ++;
                    list.remove(i);
                    list.remove(0);
                    success = true;
                    break;
                }
            }
            if (!success) {
                list.remove(0);
                count++;
            }
        }
        return count;
    }
}