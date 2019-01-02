package URI.Trying.NOSTATUS.BEGINNER;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: BEGINNER
 * @Problem: 2784 - Islands
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2784
 * @Timelimit: 2 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution: find shorted path min and max path in graph
 * @Note:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2784_Islands {

    static int n, m, s, min, max;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        min = Integer.MIN_VALUE;
        max = 0;
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int s = Integer.parseInt(st[0]);
            int d = Integer.parseInt(st[1]);
            int ping = Integer.parseInt(st[2]);
            map[s][d] = ping;
        }
        s = Integer.parseInt(br.readLine());

    }

}
