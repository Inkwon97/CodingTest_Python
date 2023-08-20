import java.util.*;

/*
    1. wallpaper
    2. 세로, 가로 좌표
    3. 빈칸은 ., 파일은 #
    4. 최소한의 이동거리를 갖는 한 번의 드래그로 모든 파일을 선택해서 한번에 제거

    가장 왼쪽 위에 있는 행부터 드래그
    가장 왼쪽에 있는 열부터 드래그
*/

class Main {

    public static int[] solution(String[] wallpaper) {

        int lux = Integer.MAX_VALUE, luy = Integer.MAX_VALUE, rdx = Integer.MIN_VALUE, rdy = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    // 가장 위에 있는 행, 가장 아래에 있는 행 비교
                    lux = Math.min(lux, i);
                    rdx = Math.max(rdx, i);

                    // 좌, 우 비교
                    luy = Math.min(luy, j);
                    rdy = Math.max(rdy, j);

                }
            }
        }

        System.out.println("lux : " + lux + " rdx : " + rdx + " luy : " + luy + " rdy : " + rdy);
        int[] answer = {lux, luy, rdx + 1, rdy + 1};

        return answer;
    }


    public static void main(String[] args) {
//        String[] wallpaper = {".#...", "..#..", "...#."};
        String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
//        String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
//        String[] wallpaper = {"..", "#."};
        solution(wallpaper);

    }
}
