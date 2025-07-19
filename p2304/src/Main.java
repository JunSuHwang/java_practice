import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<Square> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = bf.readLine().split(" ");
            list.add(new Square(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
        // 높이 순으로 정렬
        list.sort((o1, o2) -> o2.H-o1.H);
        // 높은 순서대로 순회, 해당 기둥 인덱스를 기록해서 그 다음 기둥이 기록한 인덱스 안쪽이면 무시.
        int result = list.get(0).H;
        Square right = new Square(list.get(0).L, list.get(0).H);
        Square left = list.remove(0);
        while(!list.isEmpty()) {
            Square target = list.remove(0);
            if(target.L > right.L) {
                result += target.H*(target.L - right.L);
                right.L = target.L;
            } else if(target.L < left.L) {
                result += target.H*(left.L - target.L);
                left.L = target.L;
            }
        }
        System.out.print(result);
    }
    static class Square{
        int L;
        int H;
        Square(int L, int H) {
            this.L = L;
            this.H = H;
        }

        public int getH() {
            return H;
        }

        public int getL() {
            return L;
        }

        public void setL(int l) {
            L = l;
        }

        public void setH(int h) {
            H = h;
        }
    }
}