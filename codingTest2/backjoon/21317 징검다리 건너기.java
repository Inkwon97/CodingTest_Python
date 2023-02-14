import java.io.*;
import java.util.*;
/*
    N개의 돌이 나열
    점프의 종류는 3가지
    다음 돌로 점프, 1개의 돌을 건너뛰는 점프, 2개의 돌을 건너뛰는 점프

    점프를 하는 돌의 번호마다 다르다
    매우 큰 점프 K만큼의 에너지
    에너지의 최솟값

*/

class Main {
    static int n, k;
    static int graph[][];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        graph = new int[n+1][2];

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
        }

        k = Integer.parseInt(br.readLine());

        /*for (int[] x : graph) {
            System.out.println(x[0] + " " + x[1]);
        }*/

        int dp[][] = new int[n+1][2];
        // dp[][1]은 MAX_VALUE로 초기화
        for (int i = 0; i < n+1; i++) {
            dp[i][1] = Integer.MAX_VALUE;
        }

        // 두번째 칸부터 점프
        for (int i = 2; i < n+1; i++) {
            // 한칸만 점프하는 경우 -> 2를 점프 못하는 2 포함이므로 i-2와 같이 안묶어줬음
            dp[i][0] = dp[i - 1][0] + graph[i - 1][0];
            if (i > 2) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 2][0] + graph[i - 2][1]);
            }

            // 2칸 점프하는 경우도 dp[i][1]에 넣어주기. 두칸 뛴적이 없는 dp[i-3][0]에서 + k
            if (i > 3) {
                dp[i][1] = dp[i - 3][0] + k;
            }
        }

        /*for (int i = 0; i < n+1; i++) {
            System.out.print(dp[i][0] + " ");
        }
        System.out.println();
        for (int i = 0; i < n+1; i++) {
            System.out.print(dp[i][1] + " ");
        }
        System.out.println();*/

        System.out.println(Math.min(dp[n][0], dp[n][1]));

    }
}