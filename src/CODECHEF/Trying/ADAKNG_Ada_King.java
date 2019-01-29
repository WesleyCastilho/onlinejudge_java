package CODECHEF.Trying;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: CODECHEF
 * @Categories: Practice(Beginner)
 * @Problem: ADAKNG - Ada King
 * @Link: https://www.codechef.com/problems/ADAKNG
 * @Timelimit:
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.*;

public class ADAKNG_Ada_King {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new BufferedOutputStream(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] st = br.readLine().split(" ");
            int R = Integer.parseInt(st[0]);
            int C = Integer.parseInt(st[1]);
            int K = Integer.parseInt(st[2]);
            int answer = 0;
            if (R > 1 && R < 8 && C > 1 && C < 8) {
                answer = 8;
            } else if ((R == 1 || R == 8) && C > 1 && C < 8) {
                answer = 6;
            } else if ((C == 1 || C == 8) && R > 1 && R < 8) {
                answer = 6;
            } else if ((C == 1 || C == 8) && (R == 1 && C == 8)) {
                answer = 3;
            }
            out.write((answer + "\n").getBytes());
        }
        out.flush();
    }

}
