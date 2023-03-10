/*
건물 W를 건설완료 하는데 드는 최소 시간
* */

import java.util.*;
import java.io.*;

class Main {
    // 테스트케이스의 개수 t, 건물의 개수 n, 규칙의 총 개수 k
    // 각 건물당 건설에걸리는 시간
    // 건설순서 X, Y
    // 승리하기 위해 건설해야 할 건물의 번호 W
    static int indegree[];
    static int n, k, t, w;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int cost[];
    static int result[];

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

        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int l = 0; l < t; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            cost = new int[n + 1];
            indegree = new int[n + 1];
            result = new int[n + 1];

            graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                int c = Integer.parseInt(st.nextToken());
                cost[i] = c;
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                indegree[b] += 1;
            }

            topology_sort();

            w = Integer.parseInt(br.readLine());
            sb.append(result[w]).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();

    }
}
