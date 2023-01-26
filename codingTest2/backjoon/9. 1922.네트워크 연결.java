/*
* 모든 컴퓨터가 연결
* 컴퓨터를 연결하는 비용을 최소로
* 각 컴퓨터를 연결하는데 필요한 비용 최소화
*
* 컴퓨터의 수 N
* 연결할 수 있는 선의 수 M
* M + 2번째 줄 까지 M개의 줄에 비용
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int a;
    int b;
    int cost;

    public Node(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
public class Main {
    public static int find(int x) {
        if (graph[x] != x) {
            graph[x] = find(graph[x]);
        }
        return graph[x];
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            graph[b] = a;
        } else {
            graph[a] = b;
        }
    }

    public static int graph[];
    public static int n;
    public static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            graph[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a, b, cost));
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            Node node = pq.poll();
            if (find(node.a) != find(node.b)) {
                union(node.a, node.b);
                answer += node.cost;
            }
        }

        System.out.println(answer);
    }
}