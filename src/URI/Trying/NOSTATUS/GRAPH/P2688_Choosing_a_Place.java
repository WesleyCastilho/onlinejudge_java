package URI.Trying.NOSTATUS.GRAPH;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class P2688_Choosing_a_Place {

    class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public P2688_Choosing_a_Place() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] data = new int[13][13];
        LinkedList<Point> chair = new LinkedList<Point>();
        for (int i = 0; i < 13; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < 13; j++) {
                data[i][j] = Integer.parseInt(st[j]);
                if (data[i][j] == 0) {
                    chair.add(new Point(i, j));
                }
            }
        }
        Point p = chair.get(0);

        bw.append("linha > " + p.i + " coluna > " + p.j);
        bw.flush();
    }


}
