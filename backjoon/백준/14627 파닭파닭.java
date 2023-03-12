import java.util.*;
import java.io.*;

class Main {

    // 파의 개수 S, 파닭의 수 C
    static int s, c;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 파닭에 들어가는 파의 양을 최대로
        arr = new int[s];
        long sum = 0;

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        // 파가 가장 큰 길이가 되면서, 수가 n개가 될 수 잇는 값
        int lt = 1;
        int rt = Arrays.stream(arr).max().getAsInt();

        while (lt <= rt) {
            int mid = (int)((lt + rt) / 2);
            int chicken_num = 0;

            for (long x : arr) {
                chicken_num += (int) (x / mid);
            }

            if (chicken_num >= c) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(sum - rt * (long) c);

        br.close();
    }
}