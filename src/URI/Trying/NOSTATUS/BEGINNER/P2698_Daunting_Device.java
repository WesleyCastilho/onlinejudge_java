package URI.Trying.NOSTATUS.BEGINNER;
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

import java.io.*;

public class P2698_Daunting_Device {
    int L, C, N;
    int P, X, A, B, S;

    public P2698_Daunting_Device() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        L = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);
        N = Integer.parseInt(st[2]);
        int[] color = new int[L];
        int[] S = new int[L];
        int[] M1 = new int[L];
        int[] M2 = new int[L];
        int[] minM = new int[L];
        int[] maxM = new int[L];
        //N step
        for (int i = 0; i < N; i++) {
            st = br.readLine().split(" ");
            P = Integer.parseInt(st[0]);
            S[i] = 1;
            X = Integer.parseInt(st[1]);
            if (X == P) S[i]++;
            A = Integer.parseInt(st[2]);
            if (A == P) S[i]++;
            B = Integer.parseInt(st[3]);
            if (B == P) S[i]++;
            M1[i] = (A + (int) Math.pow(S[i], 2)) % L;
            M2[i] = (A + (int) Math.pow(S[i] + B, 2)) % L;
            minM[i] = Math.min(M1[i], M2[i]);
            maxM[i] = Math.max(M1[1], M2[i]);
            color[minM[i]] = X;
            color[maxM[i]] = X;
        }


    }

}
