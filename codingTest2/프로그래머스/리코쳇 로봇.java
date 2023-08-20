import java.util.*;
/*
    1. 시작 위치에서 목표위치까지 최소 몇 번만에 도달할 수 있는지
    2. 로봇의 처음 위치 R, 장애물 - D, 목표지점 - G
    3. 목표위치에 도달하는데 최소 몇 번 이동해야 하는지
    4. 도달할 수 없다면, -1

*/


class Solution {

    static int[][] visited;
    static int width, height;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
//        solution(new String[]{".D.R", "....", ".G..", "...D"});
    }

    /*
        몇번 움직였는지 표시
        1. board
        2. Node에 숫자를 저장
        3. 횟수로 표현
    * */

    public static int solution(String[] board) {
        width = board[0].length();
        height = board.length;

        Node start;

        int answer = bfs(board);

        return answer;
    }

    public static int bfs(String[] board) {

        visited = new int[height][width];
        Deque<Node> dq = new ArrayDeque<>();

        // visited 초기화
        for (int i = 0; i < height; i++) {
            Arrays.fill(visited[i], -1);
        }

        // 출발지점 찾기
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i].charAt(j) == 'R') {
                    dq.offer(new Node(i, j));
                    visited[i][j] = 0;
                }
            }
        }

        // 1. bfs를 통해, 장애물 혹은 끝으로 나가기전까지 이동
        // 2. 한번 갔던 곳은 visited 표시
        while (!dq.isEmpty()) {
            Node now = dq.pollFirst();

            if (board[now.x].charAt(now.y) == 'G') {
                return visited[now.x][now.y];
            }

            // 4방향 장애물 or 끝까지 이동하는 경우
            for (int i = 0; i < 4; i++) {
                int nx = now.x;
                int ny = now.y;

                // board 범위 && 장애물 check
                while ((0 <= nx + dx[i] && nx + dx[i] < height && 0 <= ny + dy[i] && ny + dy[i] < width)
                        && board[nx + dx[i]].charAt(ny + dy[i]) != 'D') {
                    nx += dx[i];
                    ny += dy[i];

                }

                if (visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                    dq.offer(new Node(nx, ny));
                }
            }
        }

        return -1;
    }

}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}