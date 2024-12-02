public class Main {
    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        System.out.println(solution(bandage, health, attacks));
    }
    public static int solution(int[] bandage, int health, int[][] attacks) {
        int current = health;
        int attackidx = 0;
        int count = 0;
        for(int time = 1; time < attacks[attacks.length-1][0]+1; time++) {
            if (time == attacks[attackidx][0]) {
                count = 0;
                current -= attacks[attackidx++][1];
            } else {
                count++;
                current += bandage[1];
                if(count == bandage[0]) {
                    current += bandage[2];
                    count = 0;
                }
            }

            if(current >= health) {
                current = health;
            }
            if(current <= 0) return -1;
            System.out.println("Time : " + time + ", HP : " + current);

        }
        return current;
    }
}