/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1556 Removing Letters
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1556
 * @Timelimit: 4 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:permulation tree
 * @Note:
 */
package URI2.Trying.TLE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

public class P1556_Removing_Letters {

    private static TreeSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            set = new TreeSet<String>();
            int length = input.length();
            int max = 2;
            while (max <= length) {
                max *= 2;
            }
            System.out.println(max);
            String letter;
            for (int i = 1; i <= max; i++) {
                letter = "";
                String digit = Integer.toString(i, 2);
                for (int j = digit.length() - 1, k = length - 1; j >= 0; j--, k--) {
                    if (digit.charAt(j) == '1') {
                        letter = input.charAt(k) + letter;
                    }
                }
                if (!set.contains(letter)) {
                    set.add(letter);
                }
            }

            for (String s : set) {
                bw.append(s + "\n");
            }
            bw.newLine();
            bw.flush();
        }
        bw.flush();
    }

}
