package URI.Trying.NOSTATUS.STRING;

import java.io.*;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 2132 - Not One More Canadian Game!
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2132
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

class P2132_Not_One_More_Canadian_Game {

    public P2132_Not_One_More_Canadian_Game() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] Automata = new int[][]{
                {2, 1}, {1, 2}
        };
        String input;
        int t = 1;
        while ((input = br.readLine()) != null) {
            char[] c = input.toCharArray();
            int size = c.length;
            int count = 0;
            int repeat = 0;
            for (int i = 0; i < size; i++) {
                if (repeat < 1) {
                    if (c[i] == 'b') {
                        repeat++;
                        count++;
                    }
                } else {
                    count++;

                }
            }
            bw.append("Palavra " + (t++) + "\n");
            bw.append( (int) Math.pow(2, count)-repeat + "\n");
            bw.newLine();
            bw.flush();
        }
        bw.flush();
    }
}
