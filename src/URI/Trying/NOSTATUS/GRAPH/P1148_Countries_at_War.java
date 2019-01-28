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
 * @Solution: BFS
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

    static private int[][] map;

    static private class Country {
        int id;
        LinkedList<Country> link;

        public Country(int id) {
            link = new LinkedList<>();
            this.id = id;
        }

        void addLink(Country country) {
            if (!link.contains(country))
                link.add(country);
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
            map = new int[n + 1][n + 1];
            Country[] country = new Country[n + 1];
            for (int i = 1; i <= n; i++) {
                country[i] = new Country(i);
            }
            for (int i = 1; i <= e; i++) {
                st = br.readLine().split(" ");
                int c1 = Integer.parseInt(st[0]);
                int c2 = Integer.parseInt(st[1]);
                int h = Integer.parseInt(st[2]);
                map[c1][c2] = h;
                country[c1].addLink(country[c2]);
            }

            boolean isFine = false;
            int answer = 0;
            k = Integer.parseInt(br.readLine());
            boolean[] v = new boolean[n + 1];
            for (int i = 0; i < k; i++) {
                st = br.readLine().split(" ");
                int start = Integer.parseInt(st[0]);
                int end = Integer.parseInt(st[1]);
                int[] p = new int[n + 1];
                LinkedList<Country> Q = new LinkedList<>();
                Q.add(country[start]);
                while (!Q.isEmpty()) {
                    Country cur = Q.pollFirst();
                    if (cur.id == end) {
                        isFine = true;
                        break;
                    }
                    for (Country c : cur.link) {
                        if (!v[c.id]) {
                            p[c.id] = cur.id;
                            Q.add(c);
                        }
                    }
                }
            }

            bw.append((isFine ? answer : "Nao e possivel entregar a carta") + "\n");
            bw.newLine();
        }
        bw.flush();
    }


}
