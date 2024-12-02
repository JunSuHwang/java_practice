import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        System.out.println(Arrays.deepToString(solution(data, ext, val_ext, sort_by)));
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        int idx = convert(ext);
        ArrayList<int[]> result = new ArrayList<>();
        for(int i = 0; i < data.length; i++) {
            if (data[i][idx] < val_ext) result.add(data[i]);
        }
        idx = convert(sort_by);
        int finalIdx = idx;
        result.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[finalIdx] - o2[finalIdx];
            }
        });
        answer = new int[result.size()][4];
        for(int i = 0; i < answer.length; i++) {
            System.arraycopy(result.get(i), 0, answer[i], 0, 4);
        }
        return answer;
    }

    public static int convert(String name) {
        return switch (name) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> -1;
        };
    }
}