import java.util.*;

class Solution {

    static boolean visited[][];
    static int n, m;

    public static void main(String[] args) {
        solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
    }

    public static int[] solution(String[] maps) {
        ArrayList<Integer> tmp = new ArrayList<>();

        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    visited[i][j] = true;
                    tmp.add(bfs(i, j, maps));
                    System.out.println();
                }
            }
        }

        int[] answer = {};

        if (tmp.size() == 0)
            answer = new int[]{-1};

        else
            answer = tmp.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        Arrays.sort(answer);
        return answer;
    }

    public static int bfs(int start_x, int start_y, String[] maps) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(start_x, start_y));
        int result = maps[start_x].charAt(start_y) - '0';

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if ((0 <= nx && nx < n && 0 <= ny && ny < m) && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    dq.offer(new Node(nx, ny));
                    result += maps[nx].charAt(ny) - '0';
                }
            }
        }

        return result;
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}