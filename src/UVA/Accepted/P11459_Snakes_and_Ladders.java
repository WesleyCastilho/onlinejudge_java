package UVA.Accepted;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 11459 - Snakes and Ladders
 * @Link: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2454
 * @Timelimit: 10 sec
 * @Status: Accepted
 * @Submission: 2018-03-14 05:57:56
 * @Runtime: 0.230
 * @Solution:
 * @Note:
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11459_Snakes_and_Ladders {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
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
                System.out.printf("Position of player %d is %d.\n", i, playersIndex[i]);
            }
        }
    }

}
