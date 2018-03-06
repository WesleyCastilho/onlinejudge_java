/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: BEGINNER
 * @Problem: 2710 - Game of Array
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2710
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI.Trying.TLE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class P2710_Game_of_Array {

    static int[][] M;
    static int X, Y, Z, W, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int q = Integer.parseInt(br.readLine());
        M = new int[501][501];
        while (q-- > 0) {
            String[] st = br.readLine().split(" ");
            String operation = st[0];
            if (operation.equals("U")) {
                X = Integer.parseInt(st[1]);
                Y = Integer.parseInt(st[2]);
                Z = Integer.parseInt(st[3]);
                W = Integer.parseInt(st[4]);
                V = Integer.parseInt(st[5]);
                for (int i = X; i <= Z; i++) {
                    for (int j = Y; j <= W; j++) {
                        M[j][i] += V;
                    }
                }
            } else {
                X = Integer.parseInt(st[1]);
                Y = Integer.parseInt(st[2]);
                bw.append(M[Y][X] + "\n");
            }
        }
        bw.flush();
    }

}
