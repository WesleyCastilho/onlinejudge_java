package HACKERRANK.Accepted;

import java.util.Scanner;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: HACKERRANK
 * @Problem: Java Output Formatting
 * @Link: https://www.hackerrank.com/challenges/java-output-formatting/submissions/code/14131042
 * @Timelimit: 1 sec
 * @Status: Solved
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
public class Java_Output_Formatting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();


            while (s1.length() != 15) {
                s1 += " ";
            }

            String y = "" + x;
            while (y.length() != 3) {
                y = "0" + y;
            }
            System.out.println(s1 + "" + y);

        }
        System.out.println("================================");
    }


}
