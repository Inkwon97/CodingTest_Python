import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int indegree[];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int result[];
    static int cost[];

    static void topology_sort() {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i < n+1; i++) {
            if (indegree[i] == 0) {
                dq.offer(i);
            }
        }

        while (!dq.isEmpty()) {
            int now = dq.pollFirst();
            result[now] += cost[now];

            for (int x : graph.get(now)) {
                indegree[x] -= 1;
                result[x] = Math.max(result[x], result[now]);
                if (indegree[x] == 0) {
                    dq.offer(x);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        result = new int[n + 1];
        indegree = new int[n + 1];
        cost = new int[n + 1];

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            cost[i] = n;
            while (true) {
                int data = Integer.parseInt(st.nextToken());
                if (data == -1) {
                    break;
                }
                graph.get(data).add(i);
                indegree[i] += 1;
            }
        }

        topology_sort();

        StringBuffer bf = new StringBuffer();
        for (int i = 1; i < result.length; i++) {
            bf.append(result[i]).append("\n");
        }
        bw.write(bf.toString());
        bw.flush();
        bw.close();
        br.close();

        bf.reverse();
    }
}