package URI.Trying.WA.GRAPH;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 2688 - Choosing a Place
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2688
 * @Timelimit: 1 sec
 * @Status: WA 5 %
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class P2688_Choosing_a_Place {

    private static int[][] map;
    private static int line, column;
    private static double dMin = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            int A = Integer.parseInt(input);
            map = new int[14][14];
            dMin = Integer.MAX_VALUE;

            //build map
            for (int i = 1; i <= 13; i++) {
                String[] st = br.readLine().split(" +");
                for (int j = 1; j <= 13; j++) {
                    map[i][j] = Integer.parseInt(st[j - 1]);
                }
            }

            //solve
            for (int i = 1; i <= 13; i++) {
                for (int j = 1; j <= 13; j++) {
                    switch (map[i][j]) {
                        case 0:
                            double sum = 0;
                            double total = 0;
                            //top
                            if (i > 1 && map[i - 1][j] != 99) {
                                sum += map[i - 1][j];
                                total++;
                            }
                            //right
                            if (j < 13 && map[i][j + 1] != 99) {
                                sum += map[i][j + 1];
                                total++;
                            }
                            //bottom
                            if (i < 13 && map[i + 1][j] != 99) {
                                sum += map[i + 1][j];
                                total++;
                            }
                            //left
                            if (j > 1 && map[i][j - 1] != 99) {
                                sum += map[i][j - 1];
                                total++;
                            }

                            double average = sum / total;
                            System.out.println("x="+i+" y="+j+" average="+average+ " a="+A);
                            if (average > A) {
                                continue;
                            }

                            double d = Math.sqrt((Math.pow(i - 1, 2) + Math.pow(j - 8, 2)));
                            if (dMin > d) {
                                dMin = d;
                                line = i;
                                column = j;
                            }
                            break;
                        default:
                            continue;
                    }
                }
            }


            bw.append("linha > " + column + " coluna > " + line);
        }
        bw.flush();
    }

}
