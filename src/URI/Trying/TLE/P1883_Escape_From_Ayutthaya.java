package URI.Trying.TLE;


import java.io.*;
import java.util.LinkedList;

public class P1883_Escape_From_Ayutthaya {

    BufferedReader br;
    BufferedWriter bw;
    int T, N, M;
    int[][] MAP;
    Point start, end, fire;

    private class Point {
        int x;
        int y;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Point p2) {
            return this.x == p2.x && this.y == p2.y;
        }

    }

    int[][] heuristic;
    int[][] spread;

    public P1883_Escape_From_Ayutthaya() throws IOException {
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
                            MAP[y][x] = -1;
                            break;
                        case 'S':
                            MAP[y][x] = 1;
                            start = new Point(y, x);
                            break;
                        case 'E':
                            end = new Point(y, x);
                            break;
                        case 'F':
                            MAP[y][x] = -1;
                            fire = new Point(y, x);
                            break;
                        case '.':
                            MAP[y][x] = 0;
                            break;
                    }
                }
            }
            int gameOver = (Math.abs(fire.x - end.x) + Math.abs(fire.y - end.y));
            int escaped = (Math.abs(start.x - end.x) + Math.abs(start.y - end.y));
            if (escaped > gameOver) {
                bw.append("N");
            } else {
                spread = new int[N][M];
                heuristic = new int[N][M];
                boolean chk = buildHeuristic();
                bw.append(chk ? "Y" : "N");
//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < M; j++) {
//                        System.out.print(" " + heuristic[i][j]);
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < M; j++) {
//                        System.out.print(" " + spread[i][j]);
//                    }
//                    System.out.println();
//                }
//                System.out.println();


//                bw.append("Y");
//                boolean escaped = run(gameOver);
//                boolean escaped = simulation();
//                bw.append(escaped ? "Y" : "N");
            }
            bw.newLine();
            bw.flush();
        }
    }


    boolean buildHeuristic() {
        LinkedList<Point> queue = new LinkedList<Point>();
        LinkedList<Point> next = new LinkedList<Point>();
        next.add(start);
        int cost = 0;
        while (!next.isEmpty()) {
            queue.addAll(next);
            next.clear();
            while (!queue.isEmpty()) {
                Point p = queue.poll();
                int y = p.y;
                int x = p.x;
                heuristic[y][x] = cost;
                spread[y][x] = (Math.abs(fire.x - x) + Math.abs(fire.y - y));
                if (spread[y][x] == heuristic[y][x]) {
                    System.out.println("spread");
                    return false;
                }
                if (y > 0
                        && MAP[y - 1][x] == 0
                        && heuristic[y - 1][x] == 0) {//TOP
//                    System.out.println("now");
                    Point nextP = new Point(y - 1, x);
                    boolean chk = cost + 1 < (Math.abs(fire.x - nextP.x) + Math.abs(fire.y - nextP.y));
                    if (nextP.equals(end) && chk) {
                        System.out.println("end");
                        return true;
                    }
                    next.add(nextP);
                }
                if (y < N - 1
                        && MAP[y + 1][x] == 0
                        && heuristic[y + 1][x] == 0) {//BOT
//                    System.out.println("now");
                    Point nextP = new Point(y + 1, x);
                    boolean chk = cost + 1 >= (Math.abs(fire.x - nextP.x) + Math.abs(fire.y - nextP.y));
                    if (nextP.equals(end) && chk) {
                        System.out.println("end");
                        return true;
                    }
                    next.add(nextP);
                }
                if (x > 0
                        && MAP[y][x - 1] == 0
                        && heuristic[y][x - 1] == 0) {//LEFT
//                    System.out.println("now");
                    Point nextP = new Point(y, x - 1);
                    boolean chk = cost + 1 >= (Math.abs(fire.x - nextP.x) + Math.abs(fire.y - nextP.y));
                    if (nextP.equals(end) && chk) {
                        System.out.println("end");
                        return true;
                    }
                    next.add(nextP);
                }
                if (x < M - 1
                        && MAP[y][x + 1] == 0
                        && heuristic[y][x + 1] == 0) {//RIGHT
//                    System.out.println("now");
                    Point nextP = new Point(y, x + 1);
                    boolean chk = cost + 1 >= (Math.abs(fire.x - nextP.x) + Math.abs(fire.y - nextP.y));
                    if (nextP.equals(end) && chk) {
                        System.out.println("end");
                        return true;
                    }
                    next.add(nextP);
                }
            }
            cost++;
        }
        System.out.println("end Loop");
        return false;
    }


}
