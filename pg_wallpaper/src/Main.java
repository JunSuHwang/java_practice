import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        System.out.println(Arrays.toString(solution(wallpaper)));
    }

    public static int[] solution(String[] wallpaper) {
        // 세로 축을 x, 가로 축을 y
        int i = 0;
        int j = 0;
        boolean flag = false;
        int x1 = 0;
        int y1 = 0;
        int x2 = wallpaper[0].length();
        int y2 = wallpaper.length;

        for(; i < wallpaper.length; i++) {
            for(j=0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    x1 = i;
                    x2 = i+1;
                    y1 = j;
                    y2 = j+1;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        for(; i < wallpaper.length; i++) {
            for(j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    if(x2 < i+1) x2 = i+1;
                    if(y1 > j) y1 = j;
                    if(y2 < j+1) y2 = j+1;
                }
            }
        }

        return new int[]{x1, y1, x2, y2};
    }
}