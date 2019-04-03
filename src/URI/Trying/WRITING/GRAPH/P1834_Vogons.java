/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: URI ONLINE JUDGE
 * @Problem: 1834 - Vogons
 * @Link: https://www.urionlinejudge.com.br/repository/UOJ_1834_en.html
 * @Level:
 * @Timelimit:
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

package URI.Trying.WRITING.GRAPH;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1834_Vogons {

    private static class Planet {
        int id;
        int x, y, w;

        public Planet(int id, int x, int y, int w) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    private static class LineDistance {
        Planet p1, p2;
        int distance;

        public LineDistance(Planet p1, Planet p2, int distance) {
            this.p1 = p1;
            this.p2 = p2;
            this.distance = distance;
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        int x1 = Integer.parseInt(st[0]);
        int x2 = Integer.parseInt(st[1]);
        int y1 = Integer.parseInt(st[2]);
        int y2 = Integer.parseInt(st[3]);
        double distance = Math.sqrt(Math.pow(Math.abs(x2 - x1), 2) + Math.pow(Math.abs(y2 - y1), 2));
        int N = Integer.parseInt(br.readLine());
        Planet[] planet = new Planet[N];
        for (int i = 0; i < N; i++) {
            st = br.readLine().split(" ");
            int x = Integer.parseInt(st[1]);
            int y = Integer.parseInt(st[2]);
            int w = Integer.parseInt(st[0]);
            planet[i] = new Planet(i, x, y, w);
        }


        bw.flush();
    }

}