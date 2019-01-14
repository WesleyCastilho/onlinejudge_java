package URI.Trying.RTE;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1774 - Routers
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1774
 * @Level: 2
 * @Timelimit: 1 sec
 * @Status: RTE
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.IOException;
import java.util.Scanner;

public class P1907_Colouring_Game_Scenarios {

    static int R, C;
    static char[][] paper;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] st = sc.nextLine().split(" ");
        R = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);
        paper = new char[1025][1025];
        visited = new boolean[1025][1025];
        for (int i = 0; i < R; ) {
            String s = sc.nextLine();
            if (s.isEmpty()) continue;
            for (int j = 0; j < C; j++) {
                paper[i][j] = s.charAt(j);
            }
            i++;
        }
        int totalClick = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (paper[i][j] == '.' && !visited[i][j]) {
                    visited[i][j] = true;
                    BFS(i, j);
                    totalClick++;
                }
            }
        }

        System.out.println(totalClick);
    }

    static void BFS(int r, int c) {
        //top
        if (r > 0 && hasPoint(r - 1, c)) {
            visited[r - 1][c] = true;
            BFS(r - 1, c);
        }

        //left
        if (c > 0 && hasPoint(r, c - 1)) {
            visited[r][c - 1] = true;
            BFS(r, c - 1);
        }

        //right
        if (c < C - 1 && hasPoint(r, c + 1)) {
            visited[r][c + 1] = true;
            BFS(r, c + 1);
        }

        //bottom
        if (r < R - 1 && hasPoint(r + 1, c)) {
            visited[r + 1][c] = true;
            BFS(r + 1, c);
        }

    }

    static boolean hasPoint(int r, int c) {
        return paper[r][c] == '.' && !visited[r][c];
    }

}
