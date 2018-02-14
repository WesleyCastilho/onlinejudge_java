/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge:
 * @Categories:
 * @Problem:
 * @Link:
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package uri.Trying.NOSTATUS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Set;

public class P2064_Prant_and_the_Indecision {

    static int k, m, n;
    static String[] in;
    static char[] favorite;
    static Set<Character> nonRepeated, v;
    static LinkedList<Integer> index[];
    static String answer;

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        for (int i = 0; i < 26; i++) {
            index[i] = new LinkedList<Integer>();
        }
        in = br.readLine().split(" ");
        k = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        n = Integer.parseInt(in[2]);
        char[] s = br.readLine().toCharArray();
        for (char c : s) {
            nonRepeated.add(c);
        }
        favorite = br.readLine().toCharArray();
        for (int i = 0; i < m; i++) {
            if (nonRepeated.contains(favorite[i])) {
                continue;
            }
            index[favorite[i] - 'a'].add(i);
        }

        System.out.println(v.size() + "\n" + answer + "\n");
    }

}
