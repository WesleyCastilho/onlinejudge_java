package URI.Trying.NOSTATUS.BEGINNER;

import java.io.*;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 2649 - Visual Python++
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2649
 * @Timelimit: 5 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
public class P2649_Visual_Python_plusplus {

    static int n;
    static Point[] topLeftLocation;
    static Point[] bottomRightLocation;


    static class Point {
        int row;
        int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        topLeftLocation = new Point[n];
        bottomRightLocation = new Point[n];
        String[] st;
        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            int row = Integer.parseInt(st[0]);
            int column = Integer.parseInt(st[1]);
            Point p = new Point(row, column);
            topLeftLocation[i] = p;
        }
        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            int row = Integer.parseInt(st[0]);
            int column = Integer.parseInt(st[1]);
            Point p = new Point(row, column);
            bottomRightLocation[i] = p;
        }

        bw.append("syntax error\n");
    }

}
