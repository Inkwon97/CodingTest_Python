/*
# 매 초마다 두 개의 나무 중 하나의 나무에서 열매
# 자두가 그 나무의 아래에 서 있으면, 그 열매를 받아먹을 수 있다
# 다른 위치로 이동 가능

# T초 동안 떨어짐, W번만 움직인다
# 받을 수 있는 자두의 개수
*/

import java.io.*;
import java.util.*;

class Main {

    static int[][] dp;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t, w;
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        int[] graph = new int[t + 1];
        dp = new int[w+1][t+1];

        // 자두 떨어진 횟수 별로 저장, dp[0]번대 초기화
        for (int i = 1; i < t+1; i++) {
            graph[i] = Integer.parseInt(br.readLine());
            if (graph[i] == 1) {
                dp[0][i] = dp[0][i-1] + 1;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        // dp[w+1][T+1]


        for (int i = 1; i < w+1; i++) {
            for (int j = 1; j < t+1; j++) {
                // 자신의 위치와 숫자가 동일한 경우
                if (i % 2 == 0 && graph[j] == 1) {
                    dp[i][j] = Math.max(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                } else if (i % 2 == 1 && graph[j] == 2) {
                    dp[i][j] = Math.max(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                } else {
                    // 자신의 위치와 숫자가 다른 경우
                    // 가만히 있거나,
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        StringBuffer bf = new StringBuffer();
        bf.append(dp[w][t]);
        System.out.println(bf);



    }
}