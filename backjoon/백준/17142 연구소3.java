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
    static int graph[][];
    static ArrayList<Node> virus = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> virus_list = new ArrayList<>();

    // 바이러스의 경우의 수 구하기
    static void dfs(int L, int s, ArrayList<Integer> virus_arr) {
        if (L == m) {
            virus_list.add((ArrayList<Integer>) virus_arr.clone());
            return;
        }

        for (int i = s; i < virus.size(); i++) {
            virus_arr.add(i);
            dfs(L + 1, i + 1, virus_arr);
            virus_arr.remove(virus_arr.size() - 1);
        }
    }

    // 바이러스가 퍼져나가는 경우
    // 경우의 수가 들어있는 바이러스를 넣어줌
    static int bfs(int num) {

        ArrayDeque<Node> dq = new ArrayDeque<>();
        int visited[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }

        // 경우의 수의 좌표값을 넣어줌
        for (int i = 0; i < virus_list.get(num).size(); i++) {
            Node node = virus.get(virus_list.get(num).get(i));
            visited[node.x][node.y] = 0;
            dq.offer(node);
        }
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};

        int count = 0;

        while (!dq.isEmpty()) {
            Node now = dq.pollFirst();

            for (int j = 0; j < 4; j++) {
                int nx = now.x + dx[j];
                int ny = now.y + dy[j];
                // 방문한 적이 없을 때
                if (0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] == -1) {
                    // 벽이 아닐 때 방문처리
                    if (graph[nx][ny] != 1) {
                        visited[nx][ny] = visited[now.x][now.y] + 1;
                        dq.offer(new Node(nx, ny));

                        // 총 걸린 시간으로 count 저장 단, 바이러스가 있는 부분은 최신화 해줄 필요 없음. 이미 감염되어있으므로
                        // 비활성화 바이러스 시간은 바꿔줘야함. 퍼져나갈 때 기록해야하므로
                        if (graph[nx][ny] != 2) {
                            count = Math.max(visited[nx][ny], count);
                        }
                    }
                }
            }
        }

        // return해줄 때, 모든 빈칸들을 방문처리해주었는지 확인해주기 -> 순환못하는 경우가 있다면, return false
        if (check(visited, graph)) {
            return count;
        } else {
            return -1;
        }
    }

    static boolean check(int visited[][], int graph[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 빈칸인데, 방문안한노드
                if (visited[i][j] == -1 && graph[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                // virus의 위치 저장
                if (graph[i][j] == 2) {
                    virus.add(new Node(i, j));
                }
            }
        }

        dfs(0, 0, new ArrayList<>());

        // 경우의 수 만큼돌려서, 가장 적은 시간 저장
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < virus_list.size(); i++) {
            int result = Math.min(bfs(i), answer);

            // 모든 공간을 순회했다면 != -1
            if (result != -1) {
                answer = result;
            }
        }
        // 가능한 시간을 하나도 찾지 못했다면 -1
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        System.out.println(answer);
    }
}