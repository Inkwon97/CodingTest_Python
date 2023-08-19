import java.util.*;
import java.io.*;

class Main {

    public static void solution(int[] nums, int m) {

        Arrays.sort(nums);

        int left = 0; int right = nums.length - 1;
        int answer = 0;

        while (left < right) {
            if (nums[left] + nums[right] <= m) {
                left += 1;
                right -= 1;
            } else
                right -= 1;
            answer += 1;
        }

        if (left == right)
            answer += 1;

        System.out.println(answer);
    }

    public static void main(String[] args) {

        solution(new int[]{90, 50, 70, 100, 60}, 140);
        solution(new int[]{86, 95, 107, 67, 38, 49, 116, 22, 78, 53}, 150);
        solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120);
    }
}
