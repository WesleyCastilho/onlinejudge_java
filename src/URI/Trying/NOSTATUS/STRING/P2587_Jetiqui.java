package URI.Trying.NOSTATUS.STRING;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: STRING
 * @Problem: 2587 - Jetiqui
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2587
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.*;
import java.util.LinkedList;

public class P2587_Jetiqui {
    public static void main(String[] a) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        loop:
        while (n-- > 0) {
            String w1 = br.readLine();
            String w2 = br.readLine();
            char[] incom = br.readLine().toCharArray();
            LinkedList<Integer> starIndex = new LinkedList<Integer>();
            LinkedList<Integer> equeIndex = new LinkedList<Integer>();
            int index = 0;
            for (char c : incom) {
                if (c == '_') {
                    starIndex.add(index);
                } else {
                    equeIndex.add(index);
                }
                index++;
            }
            for (int i : starIndex) {
                if (w1.charAt(i) == w2.charAt(i)) {
                    bw.append("N\n");
                    continue loop;
                }
            }
            for (int i : equeIndex) {
                if (w1.charAt(i) != w2.charAt(i)) {
                    bw.append("N\n");
                    continue loop;
                }
            }
            bw.append("Y\n");
        }
        bw.flush();
    }
}
