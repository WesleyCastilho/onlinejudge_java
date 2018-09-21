package URI.Trying.NOSTATUS.GRAPH;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class P2725_Christmas_Village {

    static int n, k, x, y;

    public static void main(String[] args) throws IOException {
        System.out.println(Math.sqrt(Math.pow(3-9,2) + Math.pow(8-2,2)));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] st = br.readLine().split(" ");
            n = Integer.parseInt(st[0]);
            k = Integer.parseInt(st[1]);
            int amountPaid = 0;
            int[][] map = new int[10001][10001];
            int maxX = 0, maxY = 0;
            while (n-- > 0) {
                st = br.readLine().split(" ");
                x = Integer.parseInt(st[0]);
                y = Integer.parseInt(st[1]);
                map[y][x] = 1;
                if (x > maxX) {
                    maxX = x;
                }
                if (y > maxY) {
                    maxY = y;
                }
            }


            for (int i = 1; i <= maxY; i++) {
                for (int j = 1; j <= maxX; j++) {
                    System.out.print(map[i][j] == 1 ? "X ": ". ");
                }
                System.out.println();
            }

            bw.append(amountPaid + "\n");
        }
        bw.flush();
    }
}
