import java.util.*;


/*
*
* */
class Main {


    public static void main(String[] args) {
        solution(new String[][]{
                {"15:00", "17:00"},
                {"16:40", "18:20"},
                {"14:20", "15:20"},
                {"14:10", "19:20"},
                {"18:20", "21:20"}});
    }

    public static int solution(String[][] book_time) {
        int answer = 0;
        int[][] book_times = new int[book_time.length][book_time[0].length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // start를 기준으로 정렬
        Arrays.sort(book_time, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });

        // 시간으로 변경
        for (int i = 0; i < book_time.length; i++) {
            book_times[i][0] = timeToMinute(book_time[i][0]);
            book_times[i][1] = timeToMinute(book_time[i][1]);
        }

        for (int i = 0; i < book_time.length; i++) {
            System.out.println("start : " + book_time[i][0] + " end : " + book_time[i][1]);
//            System.out.println("start : " + book_times[i][0] + " end : " + book_times[i][1]);
        }

        //
        for (int i = 0; i < book_times.length; i++) {
            // pq가 비어있지 않은경우, 가장 앞에있는 값보다 시간이 크거나 같은 경우, 사용이 가능하다
            if (!pq.isEmpty() && book_times[i][0] >= pq.peek() + 10) {
                pq.poll();
            } else {
                // pq가 비어있거나, 앞에잇는 값보다 시간이 작은 경우. 방이 하나 더 필요한 경우
                answer++;
            }
            pq.offer(book_times[i][1]);
        }

        for (Integer integer : pq) {
            System.out.println(integer);
        }

        System.out.println(answer);
        return answer;
    }

    public static int timeToMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}