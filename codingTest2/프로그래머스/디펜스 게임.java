import java.util.*;
 
class Solution {
    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
 
        for (int e : enemy) {
            // 무적권이 존재한다면
            if (k > 0) {
                pq.offer(e);
                k -= 1;
            } else { // 무적권이 존재하지 않는 경우
            	// sub에 저장한 뒤, 남은 병사에서 뺄 수 있는지를 비교할 예정
                int sub = 0;
                // 새로 들어온 enemy가 더 많은 경우
                if (!pq.isEmpty() && pq.peek() < e) {
                    sub = pq.poll();
                    pq.offer(e);
                }
                // 무적권은 다 사용했는데, enemy가 계속 들어오는 경우
                else
                    sub = e;
 
                if (n - sub < 0) break;
                n -= sub;
            }
            answer++;
        }
 
        return answer;
    }
 
}