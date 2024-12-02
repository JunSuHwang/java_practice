import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        System.out.println(solution(friends, gifts));
    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Integer> users = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            users.put(friends[i], i);
        }
        int[][] present = new int[friends.length][friends.length];
        for(int i = 0; i < present.length; i++) Arrays.fill(present[i], 0);

        for(int i = 0; i < gifts.length; i++) {
            String[] result = gifts[i].split(" ");
            present[users.get(result[0])][users.get(result[1])]++;
        }
//        for(int i = 0; i < present.length; i++) {
//            for (int j = 0; j < present[0].length; j++) {
//                System.out.print(present[i][j] + " ");
//            }
//            System.out.println();
//        }
        int[][] presentindex = new int[friends.length][3];
        for(int i = 0; i < presentindex.length; i++) Arrays.fill(presentindex[i], 0);

        for(int i = 0; i < present.length; i++) {
            for(int j = 0; j < present[0].length; j++) {
                presentindex[i][0] += present[i][j];
                presentindex[j][1] += present[i][j];
            }
        }

        for (int i = 0; i < presentindex.length; i++) {
            presentindex[i][2] = presentindex[i][0] - presentindex[i][1];
        }

//        for(int i = 0; i < presentindex.length; i++) {
//            for (int j = 0; j < presentindex[0].length; j++) {
//                System.out.print(presentindex[i][j] + " ");
//            }
//            System.out.println();
//        }
        int[] result = new int[friends.length];
        Arrays.fill(result, 0);
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if(i == j) continue;
                if (present[i][j] > present[j][i]) {
                    result[i]++;
                } else if (present[i][j] == present[j][i]) {
                    if (presentindex[i][2] > presentindex[j][2]) result[i]++;
                }
            }
        }
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + " ");
//        }
//        System.out.println();
        answer = Arrays.stream(result).max().orElse(-1);
        return answer;
    }
}