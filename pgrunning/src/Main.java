import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(Arrays.toString(Arrays.stream(solution(players, callings)).toArray()));
    }

    public static String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playermap = new HashMap<>();
        String[] answer = Arrays.copyOf(players, players.length);
        for(int i = 0; i < players.length; i++) {
            playermap.put(players[i], i);
        }
        for(int i = 0; i < callings.length; i++) {
            int currentidx = playermap.get(callings[i]);
            int nextidx = currentidx-1;
            String nextplayer = answer[nextidx];
            playermap.replace(callings[i], nextidx);
            playermap.replace(nextplayer, currentidx);
            answer[nextidx] = answer[currentidx];
            answer[currentidx] = nextplayer;
        }
        return answer;
    }
}