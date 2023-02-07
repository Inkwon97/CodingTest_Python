import java.util.*;
import java.io.*;

/*
 * 크기가 N인 수열
 * NGF
 * 수열 A에서 등장한 횟수를 F(A)
 * 오등큰수는 오른쪽에 있으면서 수열 A에서 등장한 횟수가 F(A)보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미
 * 그러한 수가 없는 경우 오등큰수는 -1
 *
 * ex) A = [1, 1, 2, 3, 4, 2, 1
 * */
class Node {
    int idx;
    int data;

    public Node(int idx, int data) {
        this.idx = idx;
        this.data = data;
    }
}
class Main {
    static int n;

    // 1. HashMap으로 데이터들의 개수 파악
    // 2. stack에 데이터를 넣어서 더 큰 hash값이 나올 때까지
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        // 들어온 데이터들을 hash값으로 매핑
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            list.add(num);
        }

        Stack<Node> stack = new Stack<>();
        stack.push(new Node(0, list.get(0)));
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // stack의 마지막 값과 list[i]의 해시값을 서로 비교
        // stack에 있는 값이 더 작다면, 해당 stack을 꺼내서 result[idx] 위치에 list[i] 대입
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && (hashMap.get(stack.get(stack.size() - 1).data) < hashMap.get(list.get(i)))) {
                Node node = stack.pop();
                result[node.idx] = list.get(i);
            }
            stack.push(new Node(i, list.get(i)));
        }

        StringBuffer bf = new StringBuffer();
        for (int x : result) {
            bf.append(x).append(" ");
        }
        System.out.println(bf);

    }
}