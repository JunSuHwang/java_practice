// 케이스 14/18 성공
public class Main {
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(ingredient));
    }

    public static int solution(int[] ingredient) {
        int answer = 0;
        int n1, n2;
        for (int i = 0; i <= ingredient.length - 4; i++) {
            if(ingredient[i] == 1) {
                int count = 0; n1 = -1; n2 = -1;
                for(int j = i+1; j < ingredient.length; j++) {
                    if(ingredient[j] == 0) continue;
                    else if(count == 0 && ingredient[j] == 2) {
                        n1 = j;
                        count++;
                    }
                    else if(count == 1 && ingredient[j] == 3) {
                        n2 = j;
                        count++;
                    }
                    else if(count == 2 && ingredient[j] == 1) {
                        ingredient[i] = 0;
                        ingredient[n1] = 0;
                        ingredient[n2] = 0;
                        ingredient[j] = 0;
                        answer++;
                        i = -1;
                        break;
                    }
                    else{
                        break;
                    }
                }
            }
//            System.out.println(Arrays.toString(ingredient));
        }
        return answer;
    }
}