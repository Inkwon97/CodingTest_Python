public class 14. 12100 2048 {
    
}
import java.util.*;
import java.io.*;

/*
돌 N개
1개 3개 또는 4개
*/


class Main {
    public static void move(int graph[][], int direction) {

        // 상
        if (direction == 0) {
            for (int i = 0; i < n; i++) {
                int top = 0;
                for (int j = 1; j < n; j++) {
                    if (graph[j][i] != 0) {
                        int tmp = graph[j][i];
                        graph[j][i] = 0;
                        if (graph[top][i] == 0) {
                            graph[top][i] = tmp;
                        } else if (graph[top][i] == tmp) {
                            graph[top][i] *= 2;
                            top++;
                        } else {
                            top++;
                            graph[top][i] = tmp;
                        }

                    }
                }
            }
        }

        // 하
        if (direction == 1) {
            for (int i = 0; i < n; i++) {
                int top = n - 1;
                for (int j = n-2; j >= 0; j--) {
                    if (graph[j][i] != 0) {
                        int tmp = graph[j][i];
                        graph[j][i] = 0;
                        if (graph[top][i] == 0) {
                            graph[top][i] = tmp;
                        } else if (graph[top][i] == tmp) {
                            graph[top][i] *= 2;
                            top--;
                        } else {
                            top--;
                            graph[top][i] = tmp;
                        }
                    }

                }
            }
        }

        // 좌
        if (direction == 2) {
            for (int i = 0; i < n; i++) {
                int top = 0;
                for (int j = 1; j < n; j++) {
                    if (graph[i][j] != 0) {
                        int tmp = graph[i][j];
                        graph[i][j] = 0;
                        // 값이 0인 경우, tmp만 이동해주기
                        if (graph[i][top] == 0)
                            graph[i][top] = tmp;
                        else if (graph[i][top] == tmp) {
                            graph[i][top] *= 2;
                            top++;
                        } else { // 값이 서로 다른 경우
                            top++;
                            graph[i][top] = tmp;
                        }
                    }
                }
            }
        }

        // 우
        if (direction == 3) {
            for (int i = 0; i < n; i++) {
                int top = n - 1;
                for (int j = n-2; j >= 0; j--) {
                    if (graph[i][j] != 0) {
                        int tmp = graph[i][j];
                        graph[i][j] = 0;
                        if (graph[i][top] == 0) {
                            graph[i][top] = tmp;
                        } else if (graph[i][top] == tmp) {
                            graph[i][top] *= 2;
                            top--;
                        } else {
                            top--;
                            graph[i][top] = tmp;
                        }
                    }
                }
            }
        }

    }

    public static void dfs(int graph[][], int L) {
        if (L == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    answer = Math.max(answer, graph[i][j]);
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int copy[][] = new int[n][n];
            for (int j = 0; j < n; j++) {
                copy[j] = graph[j].clone();
            }
            move(copy, i);
            dfs(copy, L + 1);
        }
    }

    public static void print(int[][] graph) {
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bf.append(graph[i][j]).append(" ");
            }
            bf.append("\n");
        }
        System.out.println(bf);
    }

    static int graph[][];
    static int n;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int copy[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = graph[i].clone();
        }

        dfs(graph, 0);
        System.out.println(answer);
    }
}