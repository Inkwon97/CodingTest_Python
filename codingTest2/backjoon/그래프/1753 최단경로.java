import java.io.*;
import java.util.*;

class Main {
    public static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));
        distance[start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.distance > distance[now.index]) {
                continue;
            }

            for (Node node : graph.get(now.index)) {
                int cost = now.distance + node.distance;
                if (cost < distance[node.index]) {
                    distance[node.index] = cost;
                    q.offer(new Node(node.index, cost));
                }
            }
        }
    }

    static int[] distance;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        distance = new int[v + 1];
        final int INF = (int) 1e6;

        Arrays.fill(distance, INF);
        graph = new ArrayList<>();
        for (int i = 0 ; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        dijkstra(k);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (distance[i] == INF) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class Node implements Comparable<Node> {
    int index;
    int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(distance, other.distance);
    }

    @Override
    public String toString() {
        return index + " " + distance;
    }
}