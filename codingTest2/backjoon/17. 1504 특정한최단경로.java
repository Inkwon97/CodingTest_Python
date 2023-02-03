import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int start;
    int cost;

    public Node(int start, int cost) {
        this.start = start;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

class Main {

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        // 변수 초기화
        int distance[] = new int[n + 1];
        Arrays.fill(distance, (int) 1e8);
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.cost > distance[now.start]) {
                continue;
            }

            for (Node x : nodes.get(now.start)) {
                int cost = now.cost + x.cost;
                if (cost < distance[x.start]) {
                    distance[x.start] = cost;
                    pq.offer(new Node(x.start, cost));
                }
            }
        }
        return distance[end];
    }
    static int n, e;

    static ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n+1; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes.get(start).add(new Node(end, cost));
            nodes.get(end).add(new Node(start, cost));
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        long path1 = dijkstra(1, u) + dijkstra(u, v) + dijkstra(v, n);
        long path2 = dijkstra(1, v) + dijkstra(v, u) + dijkstra(u, n);

        long answer = Math.min(path1, path2);
        if (answer >= (int) 1e8) {
            answer = -1;
        }

        System.out.println(answer);
    }
}