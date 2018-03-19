package URI.Trying.TLE;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: AD-HOC
 * @Problem: 1883 - Escape From Ayutthaya
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1883
 * @Timelimit: 1 sec
 * @Status: TLE
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
import java.util.LinkedList;

class P1883_Escape_From_Ayutthaya {

    static BufferedReader br;
    static BufferedWriter bw;
    static int T, N, M;
    static int[][] MAP;
    static Point start, end, fire;

    //top -> bot - right - left
    static int[] ny = new int[]{-1, 1, 0, 0};
    static int[] nx = new int[]{0, 0, -1, 1};


    static private class Point {
        int x;
        int y;
        int time = 0;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }

        public Point(int y, int x, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public boolean equals(Point p2) {
            return this.x == p2.x && this.y == p2.y;
        }

    }


    static boolean findHeuristic() {
        LinkedList<Point> queue = new LinkedList<Point>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p == null) continue;
            int y = p.y;
            int x = p.x;
            MAP[y][x] = 1;
            int deadTime = (Math.abs(fire.x - x) + Math.abs(fire.y - y));
            if (deadTime == p.time) {
                continue;
            }
            if (p.equals(end)) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nY = y + ny[i];
                int nX = x + nx[i];
                if (nY > 0 && nY < N && nX > 0 && nX < M) {
                    if (MAP[nY][nX] == 0) {
                        Point nextPoint = new Point(nY, nX, p.time + 1);
                        queue.add(nextPoint);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] st = br.readLine().split(" ");
            N = Integer.parseInt(st[0]);
            M = Integer.parseInt(st[1]);
            MAP = new int[N][M];
            for (int y = 0; y < N; y++) {
                char[] c = br.readLine().toCharArray();
                for (int x = 0; x < M; x++) {
                    switch (c[x]) {
                        case '#':
                            MAP[y][x] = 1;
                            break;
                        case 'S':
                            MAP[y][x] = 1;
                            start = new Point(y, x);
                            break;
                        case 'E':
                            end = new Point(y, x);
                            break;
                        case 'F':
                            MAP[y][x] = 1;
                            fire = new Point(y, x);
                            break;
                        case '.':
                            MAP[y][x] = 0;
                            break;
                    }
                }
            }
            if (start == null || end == null) {
                bw.append("N");
            } else {
                int gameOver = Integer.MAX_VALUE;
                if (fire != null) {
                    gameOver = (Math.abs(fire.x - end.x) + Math.abs(fire.y - end.y));
                }
                int escaped = (Math.abs(start.x - end.x) + Math.abs(start.y - end.y));
                if (escaped >= gameOver) {
                    bw.append("N");
                } else {
                    boolean chk = findHeuristic();
                    bw.append(chk ? "Y" : "N");
                }
            }
            bw.newLine();
            bw.flush();
        }
    }

}
