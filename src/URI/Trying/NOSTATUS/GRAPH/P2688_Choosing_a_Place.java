package URI.Trying.NOSTATUS.GRAPH;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 2688 - Choosing a Place
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2688
 * @Timelimit: 1 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class P2688_Choosing_a_Place {

    class Point {
        int i, j;
        int value;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public P2688_Choosing_a_Place() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] data = new int[14][14];
        LinkedList<Point> chair = new LinkedList<Point>();

        for (int i = 1; i <= 13; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 1; j <= 13; j++) {
                data[i][j] = Integer.parseInt(st[j - 1]);
                if (i == 1 && j == 8) {
                    Point exit = new Point(i, j);
                    exit.value = data[i][j];
                    chair.add(exit);
                } else if (data[i][j] == 0) {
                    Point p = new Point(i, j);
                    p.value = data[i][j];
                    chair.add(p);
                }
            }
        }
        Point p = chair.get(0);

        bw.append("linha > " + p.i + " coluna > " + p.j);
        bw.flush();
    }

}
