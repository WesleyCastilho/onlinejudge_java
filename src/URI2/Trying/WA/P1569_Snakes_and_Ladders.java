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
package URI2.Trying.WA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

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
            playersIndex = new int[players];
            Arrays.fill(playersIndex, 1);
            snake_ladder = new HashMap();
            while (total_snake_ladder-- > 0) {
                st = br.readLine().split(" ");
                int start = Integer.parseInt(st[0]);
                int end = Integer.parseInt(st[1]);
                snake_ladder.put(start, end);
                if (end != 100) {
                    snake_ladder.put(end, start);
                }
            }
            moveList = new LinkedList();
            for (int i = 0; i < dice; i++) {
                moveList.add(Integer.parseInt(br.readLine()));
            }
            int i = 0;
            Iterator<Integer> listIterator = moveList.iterator();
            while (listIterator.hasNext()) {
                int nextIndex = playersIndex[i] + listIterator.next();
                Integer head_tail = snake_ladder.get(nextIndex);
                if (head_tail != null) {
                    nextIndex = head_tail;
                }

                playersIndex[i] = nextIndex;
                if (playersIndex[i] >= 100) {
                    playersIndex[i] = 100;
                    break;
                }

                if (++i == players) {
                    i = 0;
                }
            }
            i = 1;
            for (; i <= players; i++) {
                bw.append("Position of player " + i + " is " + playersIndex[i - 1] + ".\n");
            }
        }
        bw.flush();
    }

}
