package URI.Trying.NOSTATUS.GRAPH;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1148 - Countries at War
 * @Link: https://www.urionlinejudge.com.br/repository/UOJ_1148_en.html
 * @Level:
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;

public class P1148_Countries_at_War {
    static private int n, e, k;

    static private Pair[][] map;

    static private class Pair {
        Country country1;
        Country country2;
        int H;

        public Pair(Country country1, Country country2, int h) {
            this.country1 = country1;
            this.country2 = country2;
            H = h;
        }
    }

    static private class Country {
        int id;
        LinkedList<Country> link;

        public Country(int id) {
            link = new LinkedList<>();
            this.id = id;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] st = input.split(" ");
            n = Integer.parseInt(st[0]);
            e = Integer.parseInt(st[1]);
            map = new Pair[n + 1][n + 1];
            Country[] countries = new Country[n + 1];
            for (int i = 1; i <= n; i++) {
                countries[i] = new Country(i);
            }
            for (int i = 1; i <= e; i++) {
                st = br.readLine().split(" ");
                int c1 = Integer.parseInt(st[0]);
                int c2 = Integer.parseInt(st[1]);
                int h = Integer.parseInt(st[2]);
                map[c1][c2] = new Pair(countries[c1], countries[c2], h);
            }
            printMap();

            k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = br.readLine().split(" ");
                int o = Integer.parseInt(st[0]);
                int d = Integer.parseInt(st[1]);

            }


        }
        bw.flush();
    }

    static void printMap() {
        System.out.print(" ");
        for (int i = 1; i <= n; i++)
            System.out.print(" " + i);
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.print(i);
            for (int j = 1; j <= n; j++) {
                System.out.print(map[i][j] != null ? " " + map[i][j].H : " 0");
            }
            System.out.println();
        }
    }

}
