package URI.Trying.NOSTATUS.GRAPH;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: GRAPH
 * @Problem: 1057 - Going Together
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1057
 * @Level: 7
 * @Timelimit: 2 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: Divide and conquer algorithm
 * @Note: ทดสอบเดินทีละตัว แล้วหาลำดับการเดินโดย เพื่อให้ทั้ง 3 เข้าจุดวาป
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;

public class P1057_Going_Together {

    static char[][] map;
    static int size;
    static Point[][] p;
    static Robot[] robots;

    static private class Robot {
        int id;
        int startX, startY;
        boolean ended;
        boolean[][] visited;

        public Robot(int id, int y, int x) {
            this.id = id;
            this.startY = y;
            this.startX = x;
        }


    }


    static private class Point {
        int x, y;
        Point p;
        int move = 0;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] moveY = new int[]{
            -1,//top
            0,//right
            1,//bottom;
            0//left
    };
    static int[] moveX = new int[]{
            0,//top
            1,//right
            0,//bottom
            -1//left
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int t = 1; t <= n; t++) {
            size = Integer.parseInt(br.readLine());
            map = new char[size][size];
            robots = new Robot[3];
            for (int i = 0; i < size; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < size; j++) {
                    switch (map[i][j]) {
                        case '.':
                            break;
                        case 'A':
                            robots[0] = new Robot(0, j, i);
                            robots[0].visited = new boolean[size][size];
                            map[j][i] = '.';
                            break;
                        case 'B':
                            robots[1] = new Robot(1, j, i);
                            robots[1].visited = new boolean[size][size];
                            map[j][i] = '.';
                            break;
                        case 'C':
                            robots[2] = new Robot(2, j, i);
                            robots[2].visited = new boolean[size][size];
                            map[j][i] = '.';
                            break;
                    }
                }
            }


            int minMove = Integer.MAX_VALUE;


            //init Robot
            LinkedList<Point>[] Q = new LinkedList[3];
            for (int i = 0; i < 3; i++) {
                robots[i].visited[robots[i].startY][robots[i].startX] = true;
                Q[i].add(new Point(robots[i].startY, robots[i].startX));
            }


            while (!isEndGame()) {
                int[] minMoveRobot = new int[3];
                for (int i = 0; i < 1; i++) {
                    LinkedList<Point> nextQ = new LinkedList<>();
                    minMoveRobot[i] = Integer.MAX_VALUE;
                    loopRobot:
                    while (!Q[i].isEmpty()) {
                        Point p = Q[i].pollFirst();
                        if (map[p.y][p.x] == 'X') {//เจอทางออกแล้ว
                            if (minMoveRobot[i] > p.move) {
                                minMoveRobot[i] = p.move;
                            }
                            map[p.y][p.x] = '.';
                            break loopRobot;
                        }
                        for (int j = 0; j < 4; j++) {
                            int y = p.y + moveY[j];
                            int x = p.x + moveX[j];
                            if (inMap(y, x)) {

                                if (robots[i].visited[y][x]) {
                                    continue;
                                }

                                if (map[y][x] != '#') {
                                    robots[i].visited[y][x] = true;
                                    Point nextPoint = new Point(y, x);
                                    nextPoint.p = p;
                                    nextPoint.move = p.move + 1;
                                    nextQ.add(nextPoint);
                                }
                            }
                        }
                    }
                    Q[i].addAll(nextQ);
                }

                if (minMoveRobot[0] == minMoveRobot[1] && minMoveRobot[1] == minMoveRobot[2]) {
                    minMove = minMoveRobot[0];
                    break;
                }
            }

            bw.append("Case " + t + ": " + (minMove != Integer.MAX_VALUE ? minMove : "trapped") + "\n");


        }
        bw.flush();
    }


    static boolean inMap(int y, int x) {
        return y < size && y > -1 && x < size && x > -1;
    }

    static boolean isEndGame() {
        return robots[0].ended && robots[1].ended && robots[2].ended;
    }
}
