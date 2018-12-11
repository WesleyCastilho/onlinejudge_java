package URI.Trying.NOSTATUS.AD_HOC.english;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: AD-HOC
 * @Problem: 1840 - The Prisoner of Azkaban
 * @Link: https://www.urionlinejudge.com.br/repository/UOJ_1840_en.html
 * @Timelimit: 1 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution: simulator ไพ่ดัมมี่
 * @Note: ทำ simulator ไพ่ดัมมี่
 */
public class P1840_The_Prisoner_of_Azkaban {

    static class Player {
        String name;
        int score;

        public Player(String name) {
            this.name = name;
            this.score = 0;
        }
    }

    static Player[] player = new Player[4];
    static int winnerScore;
    static int winner;
    static int round;

    static int cardStartValue[];//[0] = ระดับการด์, [1] = ชนิด

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        round = Integer.parseInt(st[0]);
        String cardStart = st[1];
        cardStartValue = getCardValue(cardStart);
        for (int i = 0; i < 4; i++) {
            st = br.readLine().split(" ");
            String name = st[0];
            int x = Integer.parseInt(st[1]);
            player[x] = new Player(name);
        }


        for (int i = 0; i < round; i++) {
            st = br.readLine().split(" ");
            int[][] cardValue = new int[4][2];
            for (int j = 0; j < 4; j++) {
                cardValue[j] = getCardValue(st[j]);
            }

            System.out.println("start="+cardStartValue[0] + "/" + cardStartValue[1]);
            for (int j = 0; j < 4; j++) {
                System.out.print(cardValue[j][0] + "/" + cardValue[j][1] + " ");
            }
            System.out.println();
        }


        System.out.println();
    }


    static int[] getCardValue(String card) {
        int[] result = new int[2];
        char c1 = card.charAt(0);
        char c2 = card.charAt(1);

        switch (c1) {
            case 'Q':
                result[0] = 8;
                break;
            case 'J':
                result[0] = 9;
                break;
            case 'K':
                result[0] = 10;
                break;
            case 'A':
                result[0] = 11;
                break;
            default:
                result[0] = c1 - '0';
        }

        switch (c2) {
            case 'D':
                result[1] = 1;
                break;
            case 'S':
                result[1] = 2;
                break;
            case 'H':
                result[1] = 3;
                break;
            case 'C':
                result[1] = 4;
                break;
        }

        return result;
    }

}
