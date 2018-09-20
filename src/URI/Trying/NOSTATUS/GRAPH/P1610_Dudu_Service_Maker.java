/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1610 : Dudu Service Maker
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1610
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI.Trying.NOSTATUS.GRAPH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class P1610_Dudu_Service_Maker {


    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);
        int n, m;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] st = br.readLine().split(" ");
            n = Integer.parseInt(st[0]);
            m = Integer.parseInt(st[1]);
            LinkedList<Integer>[] link = new LinkedList[n];
            int[][] connection = new int[n][n];
            boolean[][] isLoop = new boolean[n][n];
            int a, b;
            boolean loop = false;
            while (m-- > 0) {
                br.readLine().split(" ");
                a = Integer.parseInt(st[0]);
                b = Integer.parseInt(st[1]);
                if (link[a - 1] == null) {
                    link[a - 1] = new LinkedList<Integer>();
                    link[a - 1].add(b - 1);
                }
//                if (a > n || b > n) continue;
//                if (isLoop[a][b]) {
//                    loop = true;
//                }
//                connection[a][b] = 1;
//                isLoop[a][b] = true;
//                isLoop[b][a] = true;
            }

            int i = -1;
            for (LinkedList<Integer> e : link) {
                ++i;
                if (e == null) continue;
                for (int e2 : e) {
                    boolean[] visited = new boolean[n];

                }
            }

            bw.append((loop ? "SIM" : "NAO") + "\n");

        }
        bw.flush();
    }


    static boolean isCheckLoop(int a, int b, boolean[] v) {
        return true;
    }

}
