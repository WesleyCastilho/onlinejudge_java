package URI.Trying.WA;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 2689 - Game of the Miao
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2689
 * @Timelimit: 1 sec
 * @Status: WA 40%
 * @Submission: 3/29/18, 5:06:08 PM
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class P2689_Game_of_the_Miao {

    final int DEL = -1;

    public P2689_Game_of_the_Miao() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Q = Integer.parseInt(br.readLine());
        int[][] data = new int[3][3];
        int[][] tmp = new int[3][3];
        int[][] diff = new int[3][3];
        while (Q > 0) {
            Set<Integer> removeData = new TreeSet<>();
            Set<Integer> allData = new TreeSet<>();
            for (int i = 0; i < 3; i++) {
                String[] st = br.readLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    data[i][j] = Integer.parseInt(st[j]);
                    tmp[i][j] = data[i][j];
                    if (allData.contains(tmp[i][j])) {
                        removeData.add(tmp[i][j]);
                    } else {
                        allData.add(tmp[i][j]);
                    }
                }
            }

            //find Diff
            int[] n = new int[101];
            int max = 0, mostNumber = 0;
            for (int i = 0; i < 3; i++) {
                diff[i][0] = abs(tmp[i][0], tmp[i][1]);
                if (max < ++n[diff[i][0]]) {
                    max = n[diff[i][0]];
                    mostNumber = diff[i][0];
                }
                diff[i][1] = abs(tmp[i][1], tmp[i][0]);
                if (max < ++n[diff[i][1]]) {
                    max = n[diff[i][1]];
                    mostNumber = diff[i][1];
                }
                diff[i][2] = abs(tmp[i][2], tmp[i][1]);
                if (max < ++n[diff[i][2]]) {
                    max = n[diff[i][2]];
                    mostNumber = diff[i][2];
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (removeData.contains(tmp[i][j])) {
                        tmp[i][j] = DEL;
                    } else if (diff[i][j] == mostNumber) {
                        removeData.add(tmp[i][j]);
                        tmp[i][j] = DEL;
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                if (data[i][0] < data[i][1] && tmp[i][1] == DEL) {
                    tmp[i][0] = DEL;
                }
                if (data[i][1] < data[i][2] && tmp[i][2] == DEL) {
                    tmp[i][1] = DEL;
                }
            }

            bw.append("Possiveis maletas: ");
            boolean printed = false;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int number = tmp[i][j];
                    if (number != DEL) {
                        if (!printed) {
                            bw.append("" + number);
                            printed = true;
                        } else {
                            bw.append(", " + number);
                        }
                    }
                }
            }
            bw.append(";\n");
            if (--Q == 0) {
                break;
            }

        }
        bw.flush();
    }

    int abs(int a, int b) {
        return Math.abs(a - b);
    }

}
