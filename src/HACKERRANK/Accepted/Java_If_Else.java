package HACKERRANK.Accepted;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: HACKERRANK
 * @Problem: Java If-Else
 * @Link: https://www.hackerrank.com/challenges/java-if-else/problem
 * @Timelimit: 1 sec
 * @Status: Solved
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.util.Scanner;

public class Java_If_Else {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (N % 2 != 0) {
            System.out.println("Weird");
        } else if (N >= 2 && N <= 5) {
            System.out.println("Not Weird");
        } else if (N >= 6 && N <= 20) {
            System.out.println("Weird");
        } else if (N > 20) {
            System.out.println("Not Weird");
        }
        scanner.close();
    }

}
