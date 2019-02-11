package URI.Trying.NOSTATUS.GRAPH.Backtracking;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1905 - Cops and Robbers
 * @Subject: Backtracking
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1905
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: DFS
 * @Note:
 */


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class P1905_Cops_and_Robbers {

    private static int[][] map = new int[6][6];

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean equals(Point p) {
            return this.x == p.x && this.y == p.y;
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        mainLoop:
        for (int i = 0; i < t; i++) {
            Point startPoint = new Point(1, 1);
            Point endPoint = new Point(5, 5);
            boolean[][] v = new boolean[6][6];
            for (int r = 1; r <= 5; r++) {
                for (int c = 1; c <= 5; c++) {
                    int x = sc.nextInt();
                    map[r][c] = x;
                    if (x == 1) {
                        v[r][c] = true;
                    }
                }
            }


            LinkedList<Point> Q = new LinkedList<>();
            if (map[1][1] == 0)
                Q.add(startPoint);

            boolean isFound = false;
            while (!Q.isEmpty()) {
                Point p = Q.poll();

                if (p.equals(endPoint)) {
                    isFound = true;
                    break;
                }

                //right
                if (p.x < 5 && map[p.x + 1][p.y] == 0 && !v[p.x + 1][p.y]) {
                    v[p.x + 1][p.y] = true;
                    Q.add(new Point(p.x + 1, p.y));
                }

                //bottom
                if (p.y < 5 && map[p.x][p.y + 1] == 0 && !v[p.x][p.y + 1]) {
                    v[p.x][p.y + 1] = true;
                    Q.add(new Point(p.x, p.y + 1));
                }


                //top
                if (p.y > 1 && map[p.x][p.y - 1] == 0 && !v[p.x][p.y - 1]) {
                    v[p.x][p.y - 1] = true;
                    Q.add(new Point(p.x, p.y - 1));
                }


                //left
                if (p.x > 1 && map[p.x - 1][p.y] == 0 && !v[p.x - 1][p.y]) {
                    v[p.x - 1][p.y] = true;
                    Q.add(new Point(p.x - 1, p.y));
                }
            }

            if (isFound) {
                bw.append("COPS\n");
            } else if (map[startPoint.x][startPoint.y] == 1 && map[endPoint.x][endPoint.y] == 1) {
                bw.append("ROBBERS\n");
            } else if (map[startPoint.x][startPoint.y] == 0 && map[endPoint.x][endPoint.y] == 1) {
                bw.append("COPS\n");
            } else {
                bw.append("ROBBERS\n");
            }
        }
        bw.flush();
    }


}
