import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


class Main {

    static int answer = 0;
    static int[] num_arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static Set<Long> reduce_set = new HashSet<>(); // 줄어드는 수 리스트
    public static void Solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 줄어드는 수 구하기
        dfs(0L, 0);

        // n이 최대값보다 크다면, -1
        if (n > 1023) {
            System.out.println(-1);
            return;
        }

        List<Long> sorted_reduce_list = reduce_set.stream().sorted().collect(Collectors.toList());

        // n번째 줄어드는 수 출력
        System.out.println(sorted_reduce_list.get(n - 1));

        br.close();
    }

    // 줄어드는 수 구하기
    /*
    * 1. 선택하거나, 안하거나
    * 2. index가 10 이상이라면, return
    * */
    public static void dfs(Long num, int idx) {

        reduce_set.add(num);

        // return
        if (idx >= 10) {
            return;
        }

        // 선택하거나, 안하거나
        for (int i = idx; i < 10; i++) {
            dfs(num * 10 + num_arr[i], i + 1);
            dfs(num, i + 1);
        }

    }

    public static void main(String[] args) throws Exception{
        Solution();
//        System.out.println(num_arr[9]);()
    }
}