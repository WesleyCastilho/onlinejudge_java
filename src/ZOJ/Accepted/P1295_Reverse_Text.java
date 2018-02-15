package accepted;

/**
 *
 * @author Teerapat Phokhonwong
 */
//ZOJ 1295 Reverse Text http://acm.zju.edu.cn/onlinejudge/showProblem.do?problemId=295
//Accepted 2013-07-23 01:32:36 Run Time(ms) = 30 Run Memory(KB) = 422
import java.util.Scanner;
public class P1295_ReverseText {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        for (int i = 0; i < Integer.parseInt(n); i++) {
            String word = sc.nextLine();
            String s = word;
            String answer = "";
            for (int j = word.length()-1; j >= 0 ; j--) {
                answer+= s.charAt(j);
            }
            if (i < Integer.parseInt(n)-1)System.out.println(answer);
            else System.out.print(answer);
        }
    }
}