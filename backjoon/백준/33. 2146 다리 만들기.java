import java.nio.Buffer;
import java.util.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicReferenceArray;
/*
다리를 가장 짧게 하여 연결
N x N
-> 1에서 시작해서 다음 1까지의 거리 중에서 가장 짧은 길이
*/

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Main {
    static int n;
    static int graph[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static boolean visited[][];

    // 최단 거리
    static int bfs(int x, int y, int count) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(x, y));

        int visited[][] = new int[n][n];
        visited[x][y] = 1;

        while (!dq.isEmpty()) {
            Node now = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    // 0인 부분은 여기서 걸리고
                    if (visited[nx][ny] == 0 && graph[nx][ny] == 0) {
                        visited[nx][ny] = visited[now.x][now.y] + 1;
                        dq.offer(new Node(nx, ny));
                    }
                    // 다른 섬에 도착했다면, return 해주기
                    else if (visited[nx][ny] == 0 && graph[nx][ny] != 0 && graph[nx][ny] != count) {
                        return visited[now.x][now.y];
                    }
                }
            }
        }
        return -1;
    }

    // 섬 담아주기
    static void land(int x, int y, int count) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        visited[x][y] = true;
        graph[x][y] = count;
        dq.offer(new Node(x, y));

        while (!dq.isEmpty()) {
            Node now = dq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    // 방문하지 않았고, 해당 육지라면
                    if (!visited[nx][ny] && graph[nx][ny] == 1) {
                        dq.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                        graph[nx][ny] = count;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬들의 영역을 표시
        int count = 1;
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    land(i, j, count);
                    count += 1;
                }
            }
        }

        // 거리를 비교
        int answer = (int)1e8;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] != 0) {
                    int result = bfs(i, j, graph[i][j]);
                    if (result != -1) {
                        answer = Math.min(result, answer);
                    }
                }
            }
        }
        System.out.println(answer - 1);
    }
}
