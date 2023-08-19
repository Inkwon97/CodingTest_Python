import java.util.*;

/*
    1. 비 내림차순
    2. 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분수열
    부분수열의 합은 k
    합이 k인 부분 수열이 여러개인 경우, 짧은 부분수열
    길이가 짧은 것이 여러개인 경우, 앞쪽에 나오는 수열을 찾기
*/

class Main {

    public static int[] solution(int[] sequence, int k) {
        int[] answer = {0, 0};


        int leftIdx = 0, rightIdx = 0, total = 0;
        int len = Integer.MAX_VALUE;

        while (rightIdx < sequence.length) {
            // 다음 노드를 더한 값이 k보다 작거나 같은 경우
            if (sequence[rightIdx] + total <= k) {
                total += sequence[rightIdx];
                rightIdx += 1;
            }
            // 다음 노드를 더한 값이 k보다 큰 경우
            else {
                total -= sequence[leftIdx];
                leftIdx += 1;
            }

            // 합이 k와 동일한 경우 && 길이가 더 짧은 경우
            // answer에 leftIdx, rightIdx 대입
            if (total == k && rightIdx - leftIdx < len) {
                answer[0] = leftIdx;
                answer[1] = rightIdx - 1;
                len = rightIdx - leftIdx;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);

        return answer;
    }

    public static void main(String[] args) {

        solution(new int[]{1, 2, 6, 2, 5}, 7);
        solution(new int[]{4, 4, 4, 4, 4, 4, 5}, 5);
        solution(new int[]{2, 2, 2, 2, 2}, 6);


    }
}
