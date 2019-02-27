package URI.Trying.WRITING.GRAPH;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1790 - Detecting Bridges
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1790
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: counting bridges in graph
 * @Note:
 */

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;


public class P1790_Detecting_Bridges {
    
    private class connection {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String in;
        while ((in = br.readLine()) != null) {
            String[] st = in.split(" ");
            int c = Integer.parseInt(st[0]);
            int p = Integer.parseInt(st[1]);

            for (int i = 0; i < p; i++) {
                st = br.readLine().split(" ");
                int a = Integer.parseInt(st[0]);
                int b = Integer.parseInt(st[1]);

            }

            bw.flush();
        }
        bw.flush();

    }

}
