/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: AD-HOC
 * @Problem: Drop Out
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1327
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI.Trying.NOSTATUS.AD_HOC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1327_Drop_Out {

    static int[][] shuffledDeck;
    static boolean[] dropout;
    static boolean[] winner;
    static String[] name;
    static int N;

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);
        String input;
        while (!(input = br.readLine()).equals("0")) {
            N = Integer.parseInt(input);
            name = br.readLine().split(" ");
            for (int i = 0; i < 4; i++) {
                dropout = new boolean[N];
                String[] cards = br.readLine().split(" ");
                int min = Integer.parseInt(cards[0]);
                int k = N;
                for (int j = 1, q = 1, index = 0; j < 13 && k > 0; j++) {
                    int now = Integer.parseInt(cards[j]);
                    System.out.println("now=" + now);
                    System.out.println("k=" + k);
                    if (min > now) {
                        min = now;
                        index = j % k;
                    }
                    if (++q == k) {
                        k--;
                        System.out.println("lost index=" + index);
                        System.out.println("k=" + k);
                        System.out.println("round min=" + min);
                        q = 1;
                        min = Integer.parseInt(cards[++j]);
                        System.out.println("min=" + min);
                    }
                }
            }
        }
        bw.flush();
    }

}
