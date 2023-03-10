/*
검은 방은 들어갈 수 없음
검은 방 몇 개를 흰 방으로

검은 방으로 바꾸어야 할 최소 개수
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

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
    static int[][] graph;
    static void print(int[][] graph) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + "");
            }
            System.out.println();
        }
    }

    static int bfs() {
        ArrayDeque<Node> deque = new ArrayDeque();
        int visited[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }
        visited[0][0] = 0;
        deque.offer(new Node(0, 0));

        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};

        while (!deque.isEmpty()) {
            Node node = deque.pollFirst();
            if (node.x == n-1 && node.y == n-1) {
                return visited[node.x][node.y];
            }
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (visited[nx][ny] == -1) {
                        // 벽이 아니라면, 이전의 벽 개수 그대로 들고가기
                        if (graph[nx][ny] == 1) {
                            visited[nx][ny] = visited[node.x][node.y];
                            deque.offerFirst(new Node(nx, ny));
                        }
                        // 해당 위치가 벽이라면, 벽 + 1
                        if (graph[nx][ny] == 0) {
                            visited[nx][ny] = visited[node.x][node.y] + 1;
                            deque.offer(new Node(nx,ny));
                        }
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] x = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(x[j]);
            }
        }

        System.out.println(bfs());

    }
}