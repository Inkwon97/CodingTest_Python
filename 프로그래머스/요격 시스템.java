import java.util.*;
class Solution {
    public static int solution(int[][] targets) {
        int answer = 0, end = 0;

        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        for (int[] target : targets) {
            if (end <= target[0]) {
                answer += 1;
                end = target[1];
            }
        }
        
        return answer;
    }
}