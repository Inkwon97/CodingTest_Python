import java.util.*;
import java.io.*;

/*
* 1. 서로 다른 빈도수 만들기
* 2.
* */

class Main {

    public static void solution(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;

        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Character key : map.keySet()) {
            for (Character key2 : map.keySet()) {
                // if key와 key2가 동일하다면,
                if (key == key2) break;

                // key2의 값이 0이라면 continue
                if (map.get(key2) == 0)
                    continue;

                // 동일한 값이 있는 경우, key값을 1 감소
                if (map.get(key) == map.get(key2)) {
                    map.put(key, map.get(key) - 1);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {

        solution("aaabbbcc");
        solution("aaabbc");
        solution("aebbbbc");
        solution("aaabbbcccde");
        solution("aaabbbcccdddeeeeeff");
    }
}
