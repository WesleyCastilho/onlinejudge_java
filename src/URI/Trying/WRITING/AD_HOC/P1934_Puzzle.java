/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1934 Puzzle
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1934
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: DP find value of all variable
 * @Note:
 */
package URI.Trying.WRITING.AD_HOC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class P1934_Puzzle {

    private static TreeMap<String, Integer> map = new TreeMap<String, Integer>();
    private static int[] R, C;

    private static class Pair {
        int value;
        String key;

        public Pair(String key) {
            this.value = 0;
            this.key = key;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        R = new int[n];
        C = new int[m];

        Pair[][] pair = new Pair[n][m];
        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                String key = st[j];
                pair[i][j] = new Pair(key);
                map.put(key, 0);
            }
            R[i] = Integer.parseInt(st[m]);
        }
        st = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            C[i] = Integer.parseInt(st[i]);
        }

        solv(pair);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            bw.append(entry.getKey() + " " + entry.getValue() + "\n");
        }
        bw.flush();
    }

    static void solv(Pair[][] pairs) {

    }

}
