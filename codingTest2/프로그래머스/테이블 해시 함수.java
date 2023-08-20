import java.util.*;
 
class Solution {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
 
        // 정렬
        Arrays.sort(data, ((o1, o2) -> {
            // 동일한 경우, 첫번째 항을 기준으로 내림차순
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }
            // col을 기준으로 오름차순
            return o1[col - 1] - o2[col - 1];
 
        }));
 
        // xor
        for (int i = row_begin; i < row_end + 1; i++) {
            int res = 0;
            for (int datum : data[i - 1])
                res += datum % i;
 
            answer = answer ^ res;
        }
 
        return answer;
    }
}