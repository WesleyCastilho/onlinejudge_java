package URI.Trying.AcceptedOtherLanguage;

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
 * @Note: This Problem AC With C++
 */

import java.io.*;
import java.util.LinkedList;

class P1883_Escape_From_Ayutthaya {
    static final int WALL = Integer.MAX_VALUE;
    static BufferedReader br;
    static BufferedWriter bw;
    static int T, N, M;
    static int[][] MAP;
    static int[][] fireTime;
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

    static void fireSpread(Point firePoint) {
        LinkedList<Point> queue = new LinkedList<Point>();
        queue.add(firePoint);
        while (!queue.isEmpty()) {
            Point p = queue.pollFirst();
            int y = p.y;
            int x = p.x;
            int time = p.time;
            fireTime[y][x] = p.time;
            for (int i = 0; i < 4; i++) {
                int tmpY = y + ny[i];
                int tmpX = x + nx[i];
                if (tmpY >= 0 && tmpY < N
                        && tmpX >= 0 && tmpX < M
                        && fireTime[tmpY][tmpX] == 0
                        && MAP[tmpY][tmpX] != WALL) {
                    Point point = new Point(tmpY, tmpX, time + 1);
                    queue.add(point);
                }
            }
        }
    }

    static boolean run(Point startPoint) {
        LinkedList<Point> queue = new LinkedList<Point>();
        queue.add(startPoint);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int y = p.y;
            int x = p.x;
            int time = p.time;
            MAP[y][x] = 1;
            if (p.equals(end)) {
                return true;
            }
            time = time + 1;
            for (int i = 0; i < 4; i++) {
                int nY = y + ny[i];
                int nX = x + nx[i];
                if (nY >= 0 && nY < N && nX >= 0 && nX < M && fireTime[nY][nX] > time) {
                    if (MAP[nY][nX] == 0) {
                        Point nextPoint = new Point(nY, nX, time);
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
            fireTime = new int[N][M];
            for (int y = 0; y < N; y++) {
                char[] c = br.readLine().toCharArray();
                for (int x = 0; x < M; x++) {
                    switch (c[x]) {
                        case '#':
                            MAP[y][x] = WALL;
                            break;
                        case 'S':
                            start = new Point(y, x, 1);
                            break;
                        case 'E':
                            end = new Point(y, x);
                            break;
                        case 'F':
                            fire = new Point(y, x, 1);
                            break;
                        case '.':
                            MAP[y][x] = 0;
                            break;
                    }
                }
            }
            fireSpread(fire);
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(fireTime[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();
            bw.append(run(start) ? "Y\n" : "N\n");
            bw.flush();
        }
    }

}
