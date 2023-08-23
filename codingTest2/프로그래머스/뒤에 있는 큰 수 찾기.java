import java.util.*;
 
class Solution {
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        PriorityQueue<Node> pq = new PriorityQueue<>();
 
        for (int i = 0; i < numbers.length; i++) {
 
            // pq가 존재하거나, 가장 작은 수가 numbers[i]보다 작은 경우
            while (!pq.isEmpty() && pq.peek().num < numbers[i]) {
                Node now = pq.poll();
                answer[now.idx] = numbers[i];
            }
            pq.add(new Node(i, numbers[i]));
        }
 
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            answer[now.idx] = -1;
        }
 
        return answer;
    }
}
 
class Node implements Comparable<Node>{
    int idx;
    int num;
 
    public Node(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
 
    @Override
    public int compareTo(Node o) {
        return this.num - o.num;
    }
}