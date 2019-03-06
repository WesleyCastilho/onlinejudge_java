/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: AD-HOC
 * @Problem: 1896 - It's Time to Duel!
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1896
 * @Level:
 * @Timelimit:
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note: Brute Force เพื่อ หาคู่ของการด์ในสนาม ที่สามารถรวม เป็นการดในมือได้  *** คำตอบยังไม่ถูก
 */

package URI.Trying.WRITING.AD_HOC.english;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1896_Its_Time_to_Duel {

    private static int N, A, D, H;

    private static class Card {
        int id;
        int ATK, DEF, SKILL;

        public Card(int id, int ATK, int DEF, int SKILL) {
            this.id = id;
            this.ATK = ATK;
            this.DEF = DEF;
            this.SKILL = SKILL;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        A = Integer.parseInt(st[1]);
        D = Integer.parseInt(st[2]);
        H = Integer.parseInt(st[3]);
        Card[] card = new Card[N];

        for (int i = 0; i < N; i++) {
            st = br.readLine().split(" ");
            int ATK = Integer.parseInt(st[0]);
            int DEF = Integer.parseInt(st[1]);
            int SKILL = Integer.parseInt(st[2]);
            card[i] = new Card(i, ATK, DEF, SKILL);
        }

        boolean isFound = false;
        int[][] memory = new int[N][N];
        loop:
        for (int i = 0; i < N; i++) {
            Card a = card[i];
            for (int j = 0; j < N; j++) {
                if (j == i || memory[i][j] == 1) continue;
                memory[i][j] = 1;
                Card b = card[j];

                if (A == a.ATK + b.ATK || D == a.DEF + b.DEF || H == a.SKILL + b.SKILL) {
                    isFound = true;
                    break loop;
                }

            }
        }

        System.out.println(isFound ? "Y" : "N");
    }

}