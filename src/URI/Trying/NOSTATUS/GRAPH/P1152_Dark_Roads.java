package URI.Trying.NOSTATUS.GRAPH;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1270 - Optical Fiber
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1270
 * @Level:
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: หาทางไปทุกเมืองที่สั้นที่สุด และ หาทางที่ยาวที่สุด แล้วมาลบกัน เพื่อหาความต่าง
 * @Note:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;

public class P1152_Dark_Roads {

    static int N, M;
    static int cost[][];

    static private class City {
        int id;
        LinkedList<City> link;

        public City(int id) {
            this.id = id;
            this.link = new LinkedList<>();
        }

        void addLink(City c) {
            this.link.add(c);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;
        int answer = 0;
        while (!(in = br.readLine()).equals("0 0")) {
            String[] st = in.split(" ");
            N = Integer.parseInt(st[0]);
            M = Integer.parseInt(st[1]);
            cost = new int[N][M];
            City[] cities = new City[N];
            for (int i = 0; i < N; i++) {
                cities[i] = new City(i);
            }
            for (int i = 0; i < M; i++) {
                st = br.readLine().split(" ");
                int s = Integer.parseInt(st[0]);
                int d = Integer.parseInt(st[1]);
                int c = Integer.parseInt(st[2]);
                cities[s].addLink(cities[d]);
                cost[s][d] = c;
                cost[d][s] = c;
            }

            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;


            System.out.println(max - min);
        }
    }

}
