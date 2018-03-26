/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: BEGINNER
 * @Problem: 2710 - Game of Array
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2710
 * @Timelimit: 1 sec
 * @Status: TLE
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI.Trying.TLE;

import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class P2710_Game_of_Array {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        int q = Integer.parseInt(br.readLine());
        int X, Y, Z, W, V;
        int[] M = new int[250501];
        int width = 500;
        while (q-- > 0) {
            String[] st = br.readLine().split(" ");
            String operation = st[0];
            if (operation.equals("U")) {
                X = Integer.parseInt(st[1]);
                Y = Integer.parseInt(st[2]);
                Z = Integer.parseInt(st[3]);
                W = Integer.parseInt(st[4]);
                V = Integer.parseInt(st[5]);
                for (int j = Y; j <= W; j++) {
                    for (int i = X; i <= Z; i++) {
                        M[(width * j) + i] += V;
                    }
                }
            } else {
                X = Integer.parseInt(st[1]);
                Y = Integer.parseInt(st[2]);
                bos.write((M[(width * Y) + X] + "\n").getBytes());
            }
        }
        bos.flush();
    }

}
