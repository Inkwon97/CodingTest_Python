import java.util.*;
import java.io.*;

class Main {
    static void print() {
        StringBuffer bf = new StringBuffer();
        for (int i = 0 ; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                bf.append(arr[i][j]).append(" ");
            }
            bf.append("\n");
        }
        System.out.println(bf);
    }

    static int[][] arr;
    static int n, m;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
        }public class 15. 2458 키 순서 {
            
        }
        

        for (int k = 0; k < n+1; k++) {
            for (int i = 0; i < n+1; i++) {
                for (int j = 0; j < n+1; j++) {
                    // arr[i][k] && arr[k][j]인 경우, arr[i][k] = 1
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }


        int answer = 0;
        for (int i = 0; i < n+1; i++) {
            int count = 0;
            for (int j = 0; j < n+1; j++) {
                // 어느쪽에서든 비교를 한 경우가 있다면
                if (arr[i][j] == 1 || arr[j][i] == 1) {
                    count++;
                }
            }
            if (count == n-1) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}