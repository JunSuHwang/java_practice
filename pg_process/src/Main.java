import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>(priorities.length);
        for(int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i] + i*10);
        }
        Integer[] p = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(p, (a,b) -> b - a);
        int maxidx = 0;
        while(maxidx < p.length) {
            if((queue.element() % 10) == p[maxidx]) {
                result.add(queue.element()/10);
                System.out.println(queue.remove());
                maxidx++;
            } else {
                queue.add(queue.remove());
            }
        }
        return result.indexOf(location)+1;
    }
}