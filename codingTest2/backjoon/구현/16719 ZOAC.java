import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int left, right;
    static String word;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        Solution();
    }

    public static void Solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        int len = word.length();

        right = len;
        left = 0;
        visited = new boolean[len];

        dfs(0, len);
        System.out.println(sb.toString());

        br.close();
    }

    static String makeWord = "";

    public static void dfs(int leftIdx, int rightIdx) {
        // idx가 최대, 최저를 넘어서면 return
        if (rightIdx < 0 || right <= leftIdx)
            return;

        // leftIdx, rightIdx 사이 중에서, 가장 작은 word를 찾을 것
        char min_word = 'z' + 1;
        int min_idx = -1;
        for (int i = leftIdx; i < rightIdx; i++) {
            // 이미 word에 들어간 수라면, continue
            if (visited[i]) continue;
            // 더 작은 수가 있다면,
            if (word.charAt(i)  < min_word) {
                min_word = word.charAt(i);
                min_idx = i;
            }
        }

        // 최솟값이 아무것도 없다면, return
        if (min_idx == -1) return;

        // 최솟값이 있는 경우, 해당 idx를 방문처리
        visited[min_idx] = true;
        
        String temp_word = "";
        // 단어 만들기
        for (int i = 0; i < word.length(); i++) {
            if (visited[i]) temp_word += word.charAt(i);
        }

        sb.append(temp_word).append("\n");

        // 1. 우측 탐색 2. 좌측 탐색
        dfs(min_idx + 1, rightIdx);
        dfs(leftIdx, min_idx);

    }
}