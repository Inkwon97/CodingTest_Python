import java.util.*;
import java.io.*;
/*
도시별로 홍보하는데 드는 비용, 몇 명의 호텔 고객이 늘어나는지에 대한 정보
ex) 9원 -> 3명
돈에 정수배 만큼 투자 가능
나눗셈은 불가
적어도 C명 늘이기 위해 투자해야 하는 돈의 최솟값
*/

class Main {
    static int c, n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int dp[][] = new int[n + 1][c + 1];
        // 두번째 행부터 1e8로 초기화, dp[i][0]은 고객이 0명이므로 0으로 초기화
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(dp[i], (int)1e8);
            dp[i][0] = 0;
        }

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            for (int j = 1; j < c+1; j++) {
                // j - cost < 0인 경우, 이전 dp를 그대로 참조하거나, customer * 1일 때의 cost를 그대로 넣어줌
                if (j - customer < 0) {
                    // 첫째 행의 경우, customer를 추가했을 때의 cost를 넣어준다 (적어도이므로 ex) customer가 3이면 1 2가 모두 3과 같은 cost)
                    if (i == 1) {
                        dp[i][j] = cost;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], cost);
                    }
                } else {
                    // 이전 값을 참조해주거나, j - customer 위치에서 customer를 추가함으로써 cost를 더해주기
                    // dp[i-1][j]와 비교
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-customer] + cost);
                }
            }
        }

        System.out.println(dp[n][c]);

        br.close();
    }
}