import java.util.*;
import java.io.*;
 
class Node {
    int x;
    int y;
 
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
class Main {
 
    static int n, m;
    static String[] graph;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
 
    static int bfs(int x, int y) {
        int visited[][] = new int[n][m];
        visited[x][y] = 1;
 
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(x, y));
 
        int count = 0;
 
        while (!dq.isEmpty()) {
            Node now = dq.pollFirst();
            for (int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                if ((0 <= nx && nx < n) && (0 <= ny && ny < m) && visited[nx][ny] == 0) {
                    if (graph[nx].charAt(ny) == 'L') {
                        visited[nx][ny] = visited[now.x][now.y] + 1;
                        count = Math.max(visited[nx][ny], count);
                        dq.offer(new Node(nx, ny));
                    }
                }
            }
        }
        return count;
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
 
        graph = new String[n];
        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine();
        }
 
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i].charAt(j) == 'L') {
                    answer = Math.max(bfs(i, j), answer);
                }
            }
        }
        System.out.println(answer - 1);
    }
}