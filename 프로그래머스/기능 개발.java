import java.util.*;
class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();

        int time = 0;
        Deque<Integer> deque_progresses = new ArrayDeque<>();
        for (int progress : progresses) {
            deque_progresses.offer(progress);
        }

        Deque<Integer> deque_speeds = new ArrayDeque<>();
        for (int speed : speeds) {
            deque_speeds.offer(speed);
        }

        while (!deque_progresses.isEmpty()) {
            int cnt = 0;
            while (!deque_progresses.isEmpty() && 
                   isCompleted(time, deque_progresses.getFirst(), deque_speeds.getFirst())) {
                deque_progresses.pollFirst();
                deque_speeds.pollFirst();
                cnt += 1;
            }

            if (cnt > 0) {
                result.add(cnt);
            }
            time++;
        }

        answer = result.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }

    public static boolean isCompleted(int time, Integer progress, Integer speed) {
        return progress + time * speed >= 100;
    }
}