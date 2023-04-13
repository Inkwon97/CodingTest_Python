import java.util.*;
import java.util.stream.*;
 
class Solution {
    public static String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
 
        for (int i = 0; i < number.length(); i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < number.charAt(i)) {
                stack.pop();
                k -= 1;
            }
 
            stack.push(number.charAt(i));
        }
        
        while (k > 0) {
            stack.pop();
            k -= 1;
        }
 
        answer = stack.stream()
                .map(Objects::toString)
                .collect(Collectors.joining());
 
        return answer;
    }
}