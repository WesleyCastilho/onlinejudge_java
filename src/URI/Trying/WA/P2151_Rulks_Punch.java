package URI.Trying.WA;
/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: AD-HOC
 * @Problem: 2151 - Rulk's Punch
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2151
 * @Timelimit: 1 sec
 * @Status: WA 95%
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class P2151_Rulks_Punch {

    public P2151_Rulks_Punch() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] wall;
        String[] st;
        int t = Integer.parseInt(br.readLine());
        for (int k = 1; k <= t; k++) {
            st = br.readLine().split(" ");
            int M = Integer.parseInt(st[0]);
            int N = Integer.parseInt(st[1]);
            int Y = Integer.parseInt(st[2]);
            int X = Integer.parseInt(st[3]);
            wall = new int[M + 1][N + 1];
            for (int y = 1; y <= M; y++) {
                st = br.readLine().split(" ");
                for (int x = 1; x <= N; x++) {
                    int value = Integer.parseInt(st[x - 1]) + 10;
                    if (value >= 100) {
                        value = 100;
                    }
                    if (y == Y && x == X) {
                        wall[y][x] = value;
                        continue;
                    }

                    wall[y][x] = value;
                    int pX = (int) Math.pow(x - X, 2);
                    int pY = (int) Math.pow(Y - y, 2);
                    int distance = (int) Math.sqrt(pX + pY);
                    wall[y][x] -= distance;
                    if (wall[y][x] <= 0) wall[y][x] = 1;

                }
            }

            bw.append("Parede " + k + ":\n");
            for (int y = 1; y <= M; y++) {
                bw.append("" + wall[y][1]);
                for (int x = 2; x <= N; x++) {
                    bw.append(" " + wall[y][x]);
                }
                bw.newLine();
            }
        }
        bw.flush();
    }

}
