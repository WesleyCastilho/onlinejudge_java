/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: PARADIGMS
 * @Problem: 1084 - Erasing and Winning
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1084
 * @Level: 6
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

package URI.Trying.WRITING.DP;

import java.util.Scanner;


public class P1084_Erasing_and_Winning {


    static int N, D;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            N = sc.nextInt();
            D = sc.nextInt();
            if (N == 0 && D == 0) break;
            int[] number = new int[N + 1];
            String sNum = sc.next();
            for (int i = 0; i < N; i++) number[i] = sNum.charAt(i) - '0';

            String answer = "";
            for (int i = 0; i < N; i++) {
                if (D > 0 && number[i] < number[i + 1]) {
                    D--;
                    while (D > 0 && !answer.isEmpty() && getLastNumber(answer) < number[i + 1]) {
                        answer = answer.substring(0, answer.length() - 1);
                        D--;
                    }
                } else {
                    answer += number[i];
                }
            }

            while (D-- > 0) {
                answer = answer.substring(0, answer.length() - 1);
            }


            System.out.println(answer);

        }

    }


    static int getLastNumber(String s) {
        return s.charAt(s.length() - 1) - '0';
    }


}