import java.util.*;
import java.io.*;

/*
* N, M 크기의 성 입구 1, 1
*마법 벽
* 마법 벽을 피해 N, M 위치로 이동
* T 시간 이내로 구해야 함. T시간까지 가능
* 한 칸 이동 시 한 시간
* 상하좌우 이동
*
* 명검. - 벽이 있는 칸이더라도, 부수고 이동 가능
* 부술 수 있는 벽의 개수는 제한 x
* 얼마나 빨리 구출할 수 있는지
* */

class Main {
    static int n, m, t;
    static int[][] board;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    static int bfs() {
        Deque<Node> node = new ArrayDeque<>();
        node.offer(new Node(0, 0, 0, 0));
        int visited[][][] = new int[2][n][m];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(visited[i][j], -1);
            }
        }

        visited[0][0][0] = 0;

        while (!node.isEmpty()) {
            Node now = node.pollFirst();
            if (now.time > t) {
                continue;
            }
            if (now.x == n-1 && now.y == m-1) {
                return visited[now.sword][now.x][now.y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // 검의 유무와 방문하지 않은 경우
                if (0 <= nx && nx < n && 0 <= ny && ny < m && visited[now.sword][nx][ny] == -1) {
                    // 검이 있는데, 검이 없는상태에서 방문했던 경우, 방문하지 않는다
                    if (now.sword == 1 && visited[0][nx][ny] == -1) {
                        node.offer(new Node(nx, ny, now.sword, now.time + 1));
                        visited[now.sword][nx][ny] = visited[now.sword][now.x][now.y] + 1;
                    }
                    // 검이 없으면서, 0인 노드
                    else if (now.sword == 0 && board[nx][ny] != 1) {
                        // 검인 경우,
                        if (board[nx][ny] == 2) {
                            node.offer(new Node(nx, ny, 1, now.time + 1));
                            // 두 경우 모두 방문처리
                            visited[1][nx][ny] = visited[0][now.x][now.y] + 1;
                        } else {
                            node.offer(new Node(nx, ny, now.sword, now.time + 1));
                        }
                        visited[0][nx][ny] = visited[0][now.x][now.y] + 1;
                    }
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*0은 공간 1은 벽, 2는 그람*/
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        if (result == -1)
            System.out.println("Fail");
        else
            System.out.println(result);

        br.close();
    }
}

class Node {
    int x;
    int y;
    int sword;
    int time;

    public Node(int x, int y, int sword, int time) {
        this.x = x;
        this.y = y;
        this.sword = sword;
        this.time = time;
    }
}