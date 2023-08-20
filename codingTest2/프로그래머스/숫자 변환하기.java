import java.util.*;

class Solution {
    static boolean[] visited;
    
        public static int solution(int x, int y, int n) {
        int answer = bfs(x, y, n);
        return answer;
    }

    public static int bfs(int x, int y, int n) {
        Deque<Node> dq = new ArrayDeque<>();
        visited = new boolean[y + 1];

        dq.offer(new Node(x, 0));
        visited[x] = true;

        while (!dq.isEmpty()) {
            Node now = dq.pollFirst();
            if (now.val == y)
                return now.cnt;

            for (int res : new int[]{now.val + n, now.val * 2, now.val * 3}) {
                if (res <= y && !visited[res]) {
                    visited[res] = true;
                    dq.offer(new Node(res, now.cnt + 1));
                }
            }
        }
        return -1;
    }
}

class Node {
    int val;
    int cnt;

    public Node(int val, int cnt) {
        this.val = val;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return val + " " + cnt;
    }
}