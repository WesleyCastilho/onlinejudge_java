package URI.Trying.NOSTATUS.GRAPH;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: GRAPH
 * @Problem: 1082 : Connected Components
 * @Link:
 * @Level: 7
 * @Timelimit: 2 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: Divide and conquer algorithm
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class P1057_Going_Together {

    static char[][] map;
    static boolean[][] visited;
    static int size;

    static private class Robot {
        int id;
        int startX, startY;
        boolean taget;

        public Robot(int id, int y, int x) {
            this.id = id;
            this.startY = y;
            this.startX = x;
            this.taget = false;
        }
    }

    static private class Point {
        int x, y;
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
        while (n-- > 0) {
            size = Integer.parseInt(br.readLine());
            map = new char[size][size];
            visited = new boolean[size][size];
            Robot[] robots = new Robot[3];
            for (int i = 0; i < size; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < size; j++) {
                    switch (map[i][j]) {
                        case '.':
                            visited[i][j] = true;
                            break;
                        case 'A':
                            robots[0] = new Robot(0, j, i);
                            break;
                        case 'B':
                            robots[1] = new Robot(1, j, i);
                            break;
                        case 'C':
                            robots[2] = new Robot(2, j, i);
                            break;
                    }
                }
            }


        }
        bw.flush();
    }


    static int move(int y, int x) {
        //moveStep top, right, bottom, left
        for (int i = 0; i < 4; i++) {
            if (inMap(y + moveY[i], x + moveX[i])) {
                int newX = x + moveX[i], newY = y + moveY[i];
                if (visited[newY][newX]) {
                    continue;
                }


                if (map[newY][newX] == '.') {
                    visited[newY][newX] = true;
                    move(newY, newX);
                }
            }
        }
        return 0;
    }

    static boolean inMap(int y, int x) {
        return y < size && y > -1 && x < size && x > -1;
    }

}
