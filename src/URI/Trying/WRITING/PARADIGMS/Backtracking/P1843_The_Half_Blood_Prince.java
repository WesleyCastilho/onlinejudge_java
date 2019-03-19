/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: PARADIGMS
 * @Problem: 1843 - The Half-Blood Prince
 * @Link: https://www.urionlinejudge.com.br/repository/UOJ_1843_en.html
 * @Level:
 * @Timelimit: 8 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: Backtracking หาวิธีการจำ จำนวนการคลิก การเปลี่ยนแปลงสีของแต่ละกระดาน
 * @Note: หาจำนวนการคลิกน้อยที่สุด ที่จะทำให้ตารางเป็นสีเดียว
 */

package URI.Trying.WRITING.PARADIGMS.Backtracking;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1843_The_Half_Blood_Prince {

    private static int N, M;

    private static class Graph {
        int round;
        int totalColor;
        int[][] memory;
        int[][] grid;

        public Graph(int round, int[][] grid) {
            this.round = round;
            this.grid = grid;
            this.memory = new int[N][N];
            this.getTotalColor();
        }

        void getTotalColor() {
            this.totalColor = 0;
            int[] m = new int[10];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (m[grid[i][j]] == 0) {
                        m[grid[i][j]] = 1;
                        this.totalColor++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);
        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                int x = (c[j] - '0');
                grid[i][j] = x;
            }
        }

        Comparator<Graph> comparator = new Comparator<Graph>() {
            @Override
            public int compare(Graph g1, Graph g2) {
                if (g1.totalColor < g2.totalColor) {
                    return -1;
                } else if (g1.totalColor > g2.totalColor) {
                    return 1;
                } else if (g1.totalColor == g2.totalColor) {
                    if (g1.round < g2.round) return -1;
                    else if (g1.round > g2.round) return 1;
                }
                return 0;
            }
        };
        PriorityQueue<Graph> minHeap = new PriorityQueue<Graph>(comparator);
        //build Node connection
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                int[][] tmpGrid = grid;
                int[][] m = new int[N][M];
                m[y][x] = 1;
                changeColor(tmpGrid, m, 0, 0, grid[0][0], grid[y][x]);
                Graph g = new Graph(1, tmpGrid);
                minHeap.add(g);
            }
        }


        int minimum = Integer.MAX_VALUE;
        while (!minHeap.isEmpty()) {
            Graph g = minHeap.poll();
            int[][] tmpGrid = g.grid;
            int[][] m = new int[N][M];//memory
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    changeColor(tmpGrid, m, 0, 0, grid[0][0], grid[y][x]);
                    Graph newGraph = new Graph(1, tmpGrid);
                    minHeap.add(newGraph);
                }
            }

        }
        System.out.println(minimum);
    }

    static void changeColor(int[][] grid, int[][] m, int x, int y, int oldColor, int newColor) {
        //top
        if (y > 0 && m[y - 1][x] == 0 && grid[y][x] == oldColor) {
            m[y - 1][x] = 1;
            grid[y - 1][x] = newColor;
            changeColor(grid, m, x, y - 1, oldColor, newColor);
        }

        //left
        if (x > 0) {
            m[y][x - 1] = 1;
            grid[y][x - 1] = newColor;
            changeColor(grid, m, x - 1, y, oldColor, newColor);
        }

        //right
        if (x < M - 1) {
            m[y][x + 1] = 1;
            grid[y][x + 1] = newColor;
            changeColor(grid, m, x + 1, y, oldColor, newColor);
        }

        //bottom
        if (y < N - 1) {
            m[y + 1][x] = 1;
            grid[y + 1][x] = newColor;
            changeColor(grid, m, x, y + 1, oldColor, newColor);
        }
    }


}