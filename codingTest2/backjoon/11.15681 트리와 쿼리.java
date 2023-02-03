import java.io.*;
import java.security.cert.TrustAnchor;
import java.util.*;

/*
간선에 가중치와 방향성이 없는 임의의 루트 있는 트리
U를 루트로 하는 서브트리에 속한 정점의 수

정점의 수 N과 루트의 번호 R 쿼리의 수 Q
N-1 줄에 걸쳐, U V의 형태로 트리에 속한 간선의 정보
U와 V를 양 끝점으로 하는 간선이 트리에 속함을 의미
Q줄에 걸쳐, 문제에 설명항ㄴ U가 하나씩 주어진다.
입력으로 주어지는 트리는 항상 올바른 트리임을 보장

Q줄에 걸쳐 각 쿼리의 답을 정수 하나로 출력
* */

class Main {
    public static int dfs(int node) {
        if (dp[node] != 0) {
            return dp[node];
        }
        dp[node] = 1;
        visited[node] = true;

        for (int x : nodes.get(node)) {
            // 방문한 노드라면 continue
            if (visited[x])
                continue;
            dp[node] += dfs(x);
        }
        return dp[node];
    }

    // root 노드에서 내려가면서 dp에 값을 저장하는 식으로 진행
    static int n, r, q;
    static int dp[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        dp = new int[n+1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n+1; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes.get(u).add(v);
            nodes.get(v).add(u);
        }

        // 원래대로라면, dfs
        System.out.println(nodes);
        dfs(r);

        /*for (int x : dp) {
            System.out.println(x);
        }*/

        for (int i = 0; i < q; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }

    }
}