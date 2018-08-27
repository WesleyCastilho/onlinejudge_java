package URI.Trying.NOSTATUS.AD_HOC;
/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: AD-HOC
 * @Problem: 2151 - Rulk's Punch
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2151
 * @Timelimit: 1 sec
 * @Status: WA 70%
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
            int X = Integer.parseInt(st[2]);
            int Y = Integer.parseInt(st[3]);
            wall = new int[M + 1][N + 1];
            for (int i = 1; i <= M; i++) {
                st = br.readLine().split(" ");
                for (int j = 1; j <= N; j++) {
                    int value = Integer.parseInt(st[j - 1]) + 10;
                    if (value >= 100) {
                        value = 100;
                    }
                    if (i == X && j == Y) wall[i][j] = value;
                    else {
                        wall[i][j] = value;
                        wall[i][j] -= max(Math.abs(i - X), Math.abs(j - Y));
                        if (wall[i][j] <= 0) wall[i][j] = 1;
                    }
                }
            }

            bw.append("Parede " + k + ":\n");
            for (int i = 1; i <= M; i++) {
                bw.append("" + wall[i][1]);
                for (int j = 2; j <= N; j++) {
                    bw.append(" " + wall[i][j]);
                }
                bw.newLine();
            }
        }
        bw.flush();
    }

    int max(int a, int b) {
        return a > b ? a : b;
    }
}
