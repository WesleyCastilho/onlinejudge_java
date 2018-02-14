/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1885 Thai Lotery
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1885
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI2.Trying.NOSTATUS;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class P1885_Thai_Lotery {

    static class Dice {

        int num1, num2;

        public Dice(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new BufferedOutputStream(System.out);
        int t = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);//Persons
        int k = Integer.parseInt(st[1]);//dice
        int[] numberDice = new int[k];
        for (int i = 0; i < k; i++) {
            numberDice[i] = Integer.parseInt(br.readLine());
        }
        Dice[] dice = new Dice[t];
        
        for (int i = 0; i < t; i++) {

            boolean ispossible = true;

            out.write(((ispossible ? "Y" : "N") + "\n").getBytes());
        }
        out.flush();
    }

}
