/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: Ad-Hoc
 * @Problem: 1569 - Snakes and Ladders
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1569
 * @Timelimit: 1 sec
 * @Status: WA 10%
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI.Trying.WA;

import java.io.*;
import java.util.*;

public class P1569_Snakes_and_Ladders {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        OutputStream out = new BufferedOutputStream(System.out);
        int[] playersIndex;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] st = br.readLine().split(" ");
            int players = Integer.parseInt(st[0]) + 1;
            int total_snake_ladder = Integer.parseInt(st[1]);
            int dice = Integer.parseInt(st[2]);
            playersIndex = new int[players];
            Arrays.fill(playersIndex, 1);
            int[] snake_ladder = new int[1000];
            while (total_snake_ladder-- > 0) {
                st = br.readLine().split(" ");
                int start = Integer.parseInt(st[0]);
                int end = Integer.parseInt(st[1]);
                snake_ladder[start] = end;
            }

            int p = 1;
            boolean gameOver = false;

            int roll;
            for (int i = 0; i < dice; ++i) {
                roll = Integer.parseInt(br.readLine());
                if (!gameOver) {


                    playersIndex[p] += roll;
                    if (playersIndex[p] > 100) {
                        playersIndex[p] = 100;
                    }
                    if (snake_ladder[playersIndex[p]] != 0) {
                        playersIndex[p] = snake_ladder[playersIndex[p]];
                    }
                    if (playersIndex[p] == 100) {
                        gameOver = true;
                    }
                    p++;
                    p %= players;
                    if (p == 0) {
                        p = 1;
                    }
                }

            }

            for (int i = 1; i < players; i++) {
                out.write(("Position of player " + i + " is " + playersIndex[i] + ".\n").getBytes());
            }
        }
        out.flush();
    }


}
