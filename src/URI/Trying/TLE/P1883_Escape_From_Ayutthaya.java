package URI.Trying.TLE;


import java.io.*;
import java.util.Deque;
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
        Point p;
        char direct;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }

    }

    private static Deque<Point> spread, move;
    int[][] heuristic;


    public P1883_Escape_From_Ayutthaya() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            spread = new LinkedList<Point>();
            move = new LinkedList<Point>();
            String[] st = br.readLine().split(" ");
            N = Integer.parseInt(st[0]);
            M = Integer.parseInt(st[1]);
            MAP = new int[N][M];
            heuristic = new int[N][M];
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
                            move.add(start);
                            break;
                        case 'E':
                            MAP[y][x] = Integer.MIN_VALUE;
                            end = new Point(y, x);
                            break;
                        case 'F':
                            fire = new Point(y, x);
                            fire.direct = 'A';
                            spread.addFirst(fire);
                            break;
                    }
                }
            }
            int gameOver = (Math.abs(fire.x - end.x) + Math.abs(fire.y - end.y));
            int minMove = (Math.abs(start.x - end.x) + Math.abs(start.y - end.y));
            if (minMove > gameOver) {
                bw.append("N");
            } else {

                boolean escaped = simulation();
                bw.append(escaped ? "Y" : "N");
            }
            bw.newLine();
            bw.flush();
        }
    }

    void buildHeuristic()

    private boolean simulation() {
        while (true) {
            int c1 = 0;
            int n1 = spread.size();
            Point fire;
            while (c1 < n1) {
                fire = spread.remove();
                if (fire.x == end.x && fire.y == end.y) {
                    return false;
                }
                setSpread(fire);
                c1++;
            }

            int c2 = 0;
            int n2 = move.size();
            Point m;
            while (c2 < n2) {
                m = move.remove();
                if (m.x == end.x && m.y == end.y) {
                    return true;
                } else if (MAP[m.y][m.x] != -1) {
                    setNextMove(m);
                }
                c2++;
            }
            if (move.isEmpty()) {
                return false;
            }
        }
    }

    private void setSpread(Point fire) {
        int x = fire.x;
        int y = fire.y;
        MAP[y][x] = -1;
        switch (fire.direct) {
            case 'A':
                spreadRight(y, x);
                spreadLeft(y, x);
                spreadBot(y, x);
                spreadTop(y, x);
                break;
            case 'R':
                spreadRight(y, x);
                spreadBot(y, x);
                spreadTop(y, x);
                break;
            case 'L':
                spreadLeft(y, x);
                spreadBot(y, x);
                spreadTop(y, x);
                break;
            case 'B':
                spreadRight(y, x);
                spreadBot(y, x);
                spreadLeft(y, x);
                break;
            case 'T':
                spreadTop(y, x);
                spreadLeft(y, x);
                spreadRight(y, x);
                break;
        }

    }

    void spreadRight(int y, int x) {
        if (x + 1 < M) {
            Point p = new Point(y, x + 1);
            p.direct = 'R';
            spread.addLast(p);
        }
    }

    void spreadLeft(int y, int x) {
        if (x > 0) {
            Point p = new Point(y, x - 1);
            p.direct = 'L';
            spread.addLast(new Point(x - 1, y));
        }
    }

    void spreadBot(int y, int x) {
        if (y + 1 < N) {
            Point p = new Point(y + 1, x);
            p.direct = 'B';
            spread.addLast(p);
        }
    }

    void spreadTop(int y, int x) {
        if (y > 0) {
            Point p = new Point(y - 1, x);
            p.direct = 'T';
            spread.addLast(p);
        }
    }

    private void setNextMove(Point moved) {
        int x = moved.x;
        int y = moved.y;
        MAP[y][x] = 1;

        //Move left
        if (x > 0 && MAP[y][x - 1] != 1) {
            move.addLast(new Point(y, x - 1));
        }

        //Move right
        if ((x + 1) < M && MAP[y][x + 1] != 1) {
            move.addLast(new Point(y, x + 1));
        }

        //Move top
        if (y > 0 && MAP[y - 1][x] != 1) {
            move.addLast(new Point(y - 1, x));
        }

        //Move bottom
        if (y + 1 < N && MAP[y + 1][x] != 1) {
            move.addLast(new Point(y + 1, x));
        }
    }


}
