public class Main {
    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(solution(cards1, cards2, goal));
    }
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int j = 0; int k = 0;
        // j와 k 둘다 끝 범위에 가면 종료
        for(String g : goal) {
            System.out.println(g);
            if(j >= cards1.length && k >= cards2.length) break;
            if (j < cards1.length && cards1[j].equals(g)) {
                j++;
            }
            else if(k < cards2.length && cards2[k].equals(g)) {
                k++;
            } else {
                return "No";
            }
        }
        return answer;
    }
}