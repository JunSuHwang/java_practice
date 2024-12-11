import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(ingredient));
    }

    public static int solution(int[] ingredient) {
        int answer = 0;
        ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(ingredient)
                .boxed()
                .collect(Collectors.toList());
        for(int i = 0; i <= list.size()-4; i++) {
//            System.out.println("i:"+i);
            if(list.get(i) == 1 && list.get(i+1) == 2 && list.get(i+2) == 3 && list.get(i+3) == 1) {
                list.remove(i);
                list.remove(i);
                list.remove(i);
                list.remove(i);
                i=-1;
                answer++;
            }
//            System.out.println(list.size());
        }
//        System.out.println(list);
        return answer;
    }
}