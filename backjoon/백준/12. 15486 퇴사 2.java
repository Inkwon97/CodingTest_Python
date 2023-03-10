import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 7이라면, 7에서 수행하는 것까지 감안해야 하기 때문에 8까지
        int dp[] = new int[n + 2];

        int answer = Integer.MIN_VALUE;

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());

            // j와 time과 동일하고, j + time이 n + 1 이하인 경우
            // answer값을 맨 끝에 있는 값을 담아주기 위해서 dp를 넣어줌
            dp[i] = Math.max(dp[i - 1], dp[i]);
            if (i + time <= n + 1) {
                dp[i + time] = Math.max(dp[i + time], dp[i] + point);
            }
        }

        for (int x : dp) {
            answer = Math.max(answer, x);
        }
        System.out.println(answer);


    }
}