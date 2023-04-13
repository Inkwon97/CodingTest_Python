import java.util.*;

class Solution {
    public static int[] solution(int n, long k) {

        int[] answer = new int[n];

        long[] dp = new long[n];
        dp[0] = 1;

        // factorial
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] * i;
        }

        List<Integer> num_list = new ArrayList<>();
        for (int i = 1; i < n + 1; i ++) {
            num_list.add(i);
        }
        k -= 1;

        int cnt = 0;
        while (!num_list.isEmpty()) {
            int size = num_list.size() - 1;
            int pos = (int) (k / dp[size]);
            answer[cnt++] = num_list.remove(pos);
            k = k % dp[size];
        }
        return answer;
    }
}
