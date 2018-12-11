/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1934 Puzzle
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1934
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI.Trying.NOSTATUS.AD_HOC.english;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class P1934_Puzzle {

    private static TreeMap<String, Integer> map = new TreeMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        int[] sumRow = new int[n];
        int[] sumColum = new int[m];

        String[][] table = new String[n][m];
        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                String key = st[j];
                table[i][j] = key;
                map.put(key, 0);
            }
            sumRow[i] = Integer.parseInt(st[m]);
        }
        st = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            sumColum[i] = Integer.parseInt(st[i]);
        }
        
        

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            bw.append(entry.getKey() + " " + entry.getValue() + "\n");
        }
        bw.flush();
    }

}
