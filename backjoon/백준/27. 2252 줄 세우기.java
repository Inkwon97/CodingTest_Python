import java.util.*;
import java.io.*;

class Main {
    static void topology_sort() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i < n+1; i++) {
            if (indegree[i] == 0) {
                deque.offer(i);
            }
        }
        while (!deque.isEmpty()) {
            int now = deque.pollFirst();
            result.add(now);

            for (Integer x : graph.get(now)) {
                indegree[x] -= 1;
                if (indegree[x] == 0) {
                    deque.offer(x);
                }
            }
        }
    }
    static int n, m;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indegree = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            indegree[b] += 1;
        }

        topology_sort();

        StringBuffer sb = new StringBuffer();
        for (Integer x : result) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }
}