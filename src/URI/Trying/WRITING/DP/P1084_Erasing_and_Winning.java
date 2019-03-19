/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: PARADIGMS
 * @Problem: 1084 - Erasing and Winning
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1084
 * @Level: 6
 * @Timelimit: 1 sec
 * @Status: TLE
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

package URI.Trying.WRITING.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class P1084_Erasing_and_Winning {

    static int N, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while (!(in = br.readLine()).equals("0 0")) {
            String[] st = in.split(" ");
            N = Integer.parseInt(st[0]);
            D = Integer.parseInt(st[1]);
            int[] number = new int[N + 1];
            String sNum = br.readLine();
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

            bw.append(answer + "\n");
        }
        bw.flush();
    }


    static int getLastNumber(String s) {
        return s.charAt(s.length() - 1) - '0';
    }


}