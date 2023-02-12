import java.util.*;
import java.io.*;
/*
n, m으로 이동하려면 벽을 몇 개 부셔야 하는지
4 2
0001
1000
*/

class Node {
    int x;
    int y;
    int cnt;

    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
class Main {
    static int bfs() {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!dq.isEmpty()) {
            Node now = dq.pollFirst();
            if (now.x == n-1 && now.y == m-1) {
                return now.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny]) {
                    if (graph[nx][ny] == 0) { //벽이 아니라면, offerFirst
                        dq.offerFirst(new Node(nx, ny, now.cnt));
                        visited[nx][ny] = true;
                    } else if (graph[nx][ny] == 1) { // 벽일 때는, 현재 위치에서 벽 하나 추가
                        dq.offer(new Node(nx, ny, now.cnt + 1));
                        visited[nx][ny] = true;
                    }

                }
            }
        }
        return -1;
    }

    static int n, m;
    static int graph[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static boolean visited[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < m; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        int answer = bfs();
        System.out.println(answer);

        br.close();

    }
}