package URI.Trying.WRITING.BEGINNER;
/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 2698 - Daunting Device
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2698
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2698_Daunting_Device {
    static int L, C, N;
    static int P, X, A, B, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        L = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);
        N = Integer.parseInt(st[2]);
        int[] cell = new int[L];
        for (int i = 0; i < N; i++) {
            st = br.readLine().split(" ");
            P = Integer.parseInt(st[0]);
            X = Integer.parseInt(st[1]);
            A = Integer.parseInt(st[2]);
            B = Integer.parseInt(st[3]);
            int S = 0;
            for (int j = 0; j < L && j < P; j++) {
                S += cell[j] + P;
            }
            int M1 = (int) ((A + Math.pow(S, 2)) % L);// (A + S2) mod L
            int M2 = (int) ((A + Math.pow(S + B, 2)) % L);// (A +  (S + B)2) mod L

            for (int j = 0; j < L; j++) {
                cell[j] = Math.abs(M1 - M2);
            }
        }

        for (int i = 0; i < L; i++) {
            System.out.println(cell[i]);
        }


        int answer = 0;
        for (int i = 0; i < N; i++) {

        }

        System.out.println(answer);
    }

}
