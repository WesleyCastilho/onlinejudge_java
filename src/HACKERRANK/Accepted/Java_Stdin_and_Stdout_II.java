package HACKERRANK.Accepted;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: HACKERRANK
 * @Problem: Java Stdin and Stdout II
 * @Link: https://www.hackerrank.com/challenges/java-stdin-stdout/problem
 * @Timelimit: 1 sec
 * @Status: Solved
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Java_Stdin_and_Stdout_II {

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        double y = Double.parseDouble(br.readLine());
        String s = br.readLine();
        System.out.println("String: " + s);
        System.out.println("Double: " + y);
        System.out.println("Int: " + x);
    }

}
