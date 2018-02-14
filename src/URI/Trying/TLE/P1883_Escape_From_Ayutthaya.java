/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1883 Escape From Ayutthaya
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1883
 * @Timelimit: 1 sec
 * @Status: Time limit exceeded
 * @Submission: 2/15/16, 10:06:56 PM
 * @Runtime: 2.000
 * @Solution: customize A* Algorithm for find shortest path and simulation
 * @Note:
 */
package URI.Trying.TLE;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.LinkedList;

public class P1883_Escape_From_Ayutthaya {

    private static char[][] map;
    private static boolean[][] closed;
    private static int[][] heuristic;
    private static int[][] movementCost;
    private static int n, m;
    private static Point startPoint, goalPoint, fire;
    private static LinkedList<Point> spread;
    private static LinkedList<Point> shortedPath;
    private static Node openList_Header;

    private static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private static class Node {

        Node Parent;
        Node next;
        int value;
        Point point;

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private static void addNode(int value, Point point) {
        Node node = new Node();
        node.value = value;
        node.point = point;
        if (openList_Header == null) {
            openList_Header = node;
        } else {
            Node cur = openList_Header;
            Node prev = null;
            while (cur.next != null) {

                cur = cur.next;
            }
            cur.next = node;
        }
    }

    private static void removeNode() {
        openList_Header = openList_Header.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new BufferedOutputStream(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            spread = new LinkedList();
            shortedPath = new LinkedList();
            String[] st = br.readLine().split(" ");
            n = Integer.parseInt(st[0]);
            m = Integer.parseInt(st[1]);
            map = new char[n][m];
            heuristic = new int[n][m];
            movementCost = new int[n][m];
            for (int y = 0; y < n; y++) {
                map[y] = br.readLine().toCharArray();
                for (int x = 0; x < m; x++) {
                    switch (map[y][x]) {
                        case '#':
                            map[y][x] = '#';
                            closed[y][x] = true;
                            break;
                        case 'S':
                            startPoint = new Point(x, y);
                            closed[y][x] = true;
                            break;
                        case 'E':
                            goalPoint = new Point(x, y);
                            break;
                        case 'F':
                            fire = new Point(x, y);
                            spread.addFirst(fire);
                            closed[y][x] = true;
                            break;
                    }
                }
            }
            getHeuristic();
            boolean possible = true;
            if (heuristic[startPoint.y][startPoint.x] >= heuristic[fire.y][fire.x]) {
                possible = false;
            } else if (!AStarSearch()) {
                possible = false;
            } else if (simulate()) {
                possible = false;
            }
            out.write(((possible ? "Y" : "N") + "\n").getBytes());
        }
        out.flush();
    }

    private static boolean AStarSearch() {
        boolean posible = false;
        openList_Header = null;
        int h = 0;
        int g = 0;
        int x = 0;
        int y = 0;
        addNode(h + g, startPoint);
        while (openList_Header != null) {
            Point p = openList_Header.point;
            removeNode();
            //Left
            x = p.x - 1;
            y = p.y;
            if (map[y][x] != '#') {

            }
            //rigth
            x = p.x + 1;
            y = p.y;
            if (map[y][x] != '#') {

            }
            //top
            x = p.x;
            y = p.y - 1;
            if (map[y][x] != '#') {

            }
            //down
            x = p.x;
            y = p.y + 1;
            if (map[y][x] != '#') {

            }
            
        }

        return posible;
    }

    private static boolean simulate() {
        boolean canEscape = true;
        return canEscape;
    }

    private static int calculateHeuristic(int x, int y) {
        int dx = Math.abs(x - goalPoint.x);
        int dy = Math.abs(y - goalPoint.y);
        return dx + dy;
    }

    private static void getHeuristic() {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                switch (map[y][x]) {
                    case '#':
                    case 'E':
                        break;
                    default:
                        heuristic[y][x] = calculateHeuristic(x, y);
                        break;
                }
            }
        }
    }

}
