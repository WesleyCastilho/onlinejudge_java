package URI.Trying.NOSTATUS.GRAPH;

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
 * @Solution:
 * @Note:
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P1928_Memory_Game {

    static int N;

    private static class Card {
        int id;
        int value;
        LinkedList<Card> link;

        public Card(int id, int value) {
            this.id = id;
            this.value = value;
            link = new LinkedList<>();
        }

        void addLink(Card card) {
            link.add(card);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Card[] cards = new Card[N];
        String[] st = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st[i]);
            cards[i] = new Card(i, value);
        }

        for (int i = 0; i < N - 1; i++) {
            st = br.readLine().split(" ");
            int s = Integer.parseInt(st[0]);
            int d = Integer.parseInt(st[1]);
            cards[s].addLink(cards[d]);
        }


    }


}
