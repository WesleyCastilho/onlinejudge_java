/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: Ad-Hoc
 * @Problem: 1569 - Snakes and Ladders
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1569
 * @Timelimit: 1 sec
 * @Status: WA 100%
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI.Trying.WA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P1569_Snakes_and_Ladders {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedReader br = new BufferedReader(ir);
        BufferedWriter bw = new BufferedWriter(ow);
        HashMap<Integer, Integer> snake_ladder;
        LinkedList<Integer> moveList;
        int[] playersIndex;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] st = br.readLine().split(" ");
            int players = Integer.parseInt(st[0]);
            int total_snake_ladder = Integer.parseInt(st[1]);
            int dice = Integer.parseInt(st[2]);
            playersIndex = new int[players + 1];
            Arrays.fill(playersIndex, 1);
            snake_ladder = new HashMap();
            while (total_snake_ladder-- > 0) {
                st = br.readLine().split(" ");
                int start = Integer.parseInt(st[0]);
                int end = Integer.parseInt(st[1]);
                if(start < 100 && end < 100) {
                    snake_ladder.put(start, end);
                    snake_ladder.put(end, start);
                }
            }

            boolean end = false;
            int p = 1;
            int x;
            for (int i = 0; i < dice; ++i, ++p) {
                x = Integer.parseInt(br.readLine());

                if (end) continue;
                if (p > players) p = 1;

                while (true) {
                    playersIndex[p] += x;
                    playersIndex[p] = min(playersIndex[p], 100);

                    if (playersIndex[p] == 100) {
                        end = true;
                        break;
                    }

                    Integer tail = snake_ladder.get(playersIndex[p]);
                    if (tail != null) {
                        playersIndex[p] = tail;
                    }

                    if (playersIndex[p] == 100) {
                        end = true;
                        break;
                    }

                    if (snake_ladder.get(playersIndex[p]) == null) break;
                }
            }

            for (int i = 1; i <= players; i++) {
                bw.append("Position of player " + i + " is " + playersIndex[i] + ".\n");
            }
        }

        bw.flush();
    }

    static int min(int p, int min) {
        return p > 100 ? 100 : p;
    }

}
