import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class Main {

    static int dfs(int x, int y) {
        if (x  == n-1 && y == m-1) {
            return 1;
        }

        if (visited[x][y] != -1) {
            return visited[x][y];
        }
        visited[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (graph[x][y] > graph[nx][ny]) {
                    visited[x][y] += dfs(nx, ny);
                }
            }
        }

        return visited[x][y];
    }


    static int n, m;
    static int graph[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i],  -1);
        }

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }*/

        bw.write(dfs(0, 0) + "\n");
        bw.flush();
        bw.close();
        br.close();



    }
}