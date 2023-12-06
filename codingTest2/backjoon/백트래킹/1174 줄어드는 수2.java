import java.util.*;
import java.io.*;


class Main {

    static int answer = 0;
    static int[] num_arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static List<Long> reduce_list = new ArrayList<>(); // 줄어드는 수 리스트
    public static void Solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        dfs(0, 0);
        reduce_list.sort(null);

        try {
            System.out.println(reduce_list.get(n - 1));
        } catch (Exception e) {
            System.out.println(-1);
        }

        br.close();

    }

    // 줄어드는 수 구하기
    /*
    * 1. 선택하거나, 안하거나
    * 2. index가 10 이상이라면, return
    * */
    public static void dfs(long num, int idx) {

        if (!reduce_list.contains(num)) reduce_list.add(num);

        // return
        if (idx == 10) {
            return;
        }

        // 선택하거나, 안하거나
        dfs(num * 10 + num_arr[idx], idx + 1);
        dfs(num, idx + 1);

    }

    public static void main(String[] args) throws Exception{
        Solution();
    }
}