import java.util.*;
import java.io.*;

/*
    1. 소문자 a,b,c,d,e로 이루어진 문자열이 주어지면 a,b,c,d,e의 최소 개수를 추가하여 빈도수가 동일하게 되도록

    1. 개수가 가장 많은 것 찾기
    2. 그 개수만큼 더해주기
*/
class Main {

    public static void solution(String s) {

        int[] answer = new int[5];
        HashMap<Character, Integer> map = new HashMap<>();

        // 값 넣기
        for (Character x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int maxCount = 0;
        // 개수가 가장 많은 것 찾기
        for (Character key : map.keySet()) {
            maxCount = Math.max(maxCount, map.get(key));
        }

        // 그 개수만큼 더해줄 것
        String tmp = "abcde";
        for (int i = 0; i < tmp.length(); i++) {
            answer[i] = maxCount - map.getOrDefault(tmp.charAt(i), 0);
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        solution("aaabc");
        solution("aabb");
        solution("abcde");
        solution("abcdeabc");
        solution("abbccddee");
    }
}
