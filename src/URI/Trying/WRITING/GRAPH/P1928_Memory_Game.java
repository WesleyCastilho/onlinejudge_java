package URI.Trying.WRITING.GRAPH;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1928 - Memory Game
 * @Link: https://www.urionlinejudge.com.br/repository/UOJ_1928_en.html
 * @Level: 2
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: find the largest total amount of points you can accumulate
 * @Note: ยังหาค่าแน่นอนไม่ได้
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1928_Memory_Game {

    static int N;

    private static class Card {
        int id;
        int value;

        public Card(int id, int value) {
            this.id = id;
            this.value = value;
        }

    }

    private static class Drawn {
        int number;
        Card card1;
        Card card2;

        public Drawn(int number, Card card1, Card card2) {
            this.number = number;
            this.card1 = card1;
            this.card2 = card2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Card[] card = new Card[N + 1];
        String[] st = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st[i - 1]);
            card[i] = new Card(i, value);
        }
        Drawn[] drawn = new Drawn[N];
        int largest = 0;
        for (int i = 1; i <= N; i++) {
            st = br.readLine().split(" ");
            int c1 = Integer.parseInt(st[0]);
            int c2 = Integer.parseInt(st[1]);
            drawn[i] = new Drawn(i, card[c1], card[c2]);
//            if (card[c1].value == card[c2].value) {
//                totalScore += card[c1].value;
//            }
        }

        System.out.println(largest);

    }


}
