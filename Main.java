import java.util.Scanner;

public class Main {

    public int solution(String str, char t) {
        int answer = 0;

        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        // System.out.println(str + " " + t);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == t) answer++;
        }
        
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        char t = sc.next().charAt(0);

        System.out.println(T.solution(str, t));
        
    }
}
