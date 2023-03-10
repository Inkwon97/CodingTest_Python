import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        String[][] clothes2 = {
                {"yellow_hat", "face"},
                {"blue_sunglasses", "face"},
                {"green_turban", "face"}
        };

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            String value = clothes[i][0];

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int answer = 1;

        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }

        System.out.println(answer-1);

    }
}