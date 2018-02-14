/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories:
 * @Problem: 1045 - The Halting Problem
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1405
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package uri.Trying.NOSTATUS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1405_The_Halting_Problem {

    static int L, N;
    static int[] parameter;

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] st = input.split(" ");
            L = Integer.parseInt(st[0]);
            N = Integer.parseInt(st[1]);
            parameter = new int[N];
            while (L-- > 0) {
                st = br.readLine().split(" ");
                if (st[0].startsWith("IF")) {

                }
                if (st[0].equals("MOV")) {
                } else if (st[0].equals("ADD")) {
                } else if (st[0].equals("SUB")) {
                } else if (st[0].equals("MUL")) {
                } else if (st[0].equals("DIV")) {
                } else if (st[0].equals("MOD")) {
                } else if (st[0].equals("CALL")) {
                } else if (st[0].equals("RET")) {
                }
            }
        }
        bw.flush();
    }

    static boolean IFEQ(int a, int b) {
        return a == b;
    }

    static boolean IFNEQ(int a, int b) {
        return a != b;
    }

    static boolean IFG(int a, int b) {
        return a > b;
    }

    static boolean IFGE(int a, int b) {
        return a >= b;
    }

    static boolean IFL(int a, int b) {
        return a < b;
    }

    static boolean IFLE(int a, int b) {
        return a <= b;
    }
}
