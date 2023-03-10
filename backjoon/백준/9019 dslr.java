import java.lang.reflect.GenericDeclaration;
import java.util.*;
import java.io.*;

/*
DSLR을 이용하는 간단한 계산기
0이상 10000 미만의 십진수를 저장

1. D는 n을 두 배로 바꾼다. 9999 보다 큰 경우에는 10000으로 나눈 나머지를 취한다.
2. S는 n에서 1을 뺀 것과 n-1을 레지스터에 저장 n이 0이라면, 9999가 대신 레지스터에 저장
3. L은 n의 각 자릿수를 왼편으로 회전
4. R은 n의 각 자릿수를 오른편으로 회전

A에서 B로 변하기 위해 필요한 최소한의 명령어 나열을 출력
*/

class Main {

    static String bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        boolean visited[] = new boolean[10001];
        visited[start] = true;

        String command[] = new String[10001];
        Arrays.fill(command, "");

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == end)
                return command[now];

            int D = (now * 2) % 10000;
            int S = (now == 0) ? 9999 : now - 1;
            int L = (now % 1000) * 10 + now / 1000;
            int R = (now % 10) * 1000 + now / 10;

            if (!visited[D]) {
                q.offer(D);
                visited[D] = true;
                command[D] = command[now] + "D";
            }
            if (!visited[S]) {
                q.offer(S);
                visited[S] = true;
                command[S] = command[now] + "S";
            }
            if (!visited[L]) {
                q.offer(L);
                visited[L] = true;
                command[L] = command[now] + "L";
            }
            if (!visited[R]) {
                q.offer(R);
                visited[R] = true;
                command[R] = command[now] + "R";
            }


        }

        return "";
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(bfs(start, end));
        }

        br.close();
    }
}