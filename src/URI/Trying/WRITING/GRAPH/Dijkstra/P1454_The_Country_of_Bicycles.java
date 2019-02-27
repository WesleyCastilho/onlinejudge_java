package URI.Trying.WRITING.GRAPH.Dijkstra;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1454 - The Country of Bicycles
 * @Link: https://www.urionlinejudge.com.br/repository/UOJ_1454_en.html
 * @Level:
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note: ยังไม่ได้คำตอบ
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class P1454_The_Country_of_Bicycles {

    static int n, m;
    static int[][] costTable;
    static int[] p;


    private static class City {
        int id;
        int d;
        LinkedList<City> link;

        public City(int id) {
            this.id = id;
            this.d = Integer.MAX_VALUE;
            this.link = new LinkedList<>();
        }

        void addLink(City city) {
            this.link.add(city);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while (!(in = br.readLine()).equals("0 0")) {
            String[] st = in.split(" ");
            n = Integer.parseInt(st[0]);
            m = Integer.parseInt(st[1]);
            City[] city = new City[n + 1];

            costTable = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                city[i] = new City(i);
            }
            for (int i = 0; i < m; i++) {
                st = br.readLine().split(" ");
                int source = Integer.parseInt(st[0]);
                int destination = Integer.parseInt(st[1]);
                int cost = Integer.parseInt(st[2]);
                costTable[source][destination] = cost;
//                costTable[destination][source] = cost;
                city[source].addLink(city[destination]);
            }
            Comparator<City> comparable = new Comparator<City>() {
                @Override
                public int compare(City city1, City city2) {
                    if (city1.d < city2.d) {
                        return -1;
                    } else if (city1.d > city2.d) {
                        return 1;
                    }
                    return 0;
                }
            };

            int t = Integer.parseInt(br.readLine());
            PriorityQueue<City> minHeap;
            while (t-- > 0) {
                st = br.readLine().split(" ");
                int s = Integer.parseInt(st[0]);
                int d = Integer.parseInt(st[1]);
                minHeap = new PriorityQueue<>(n + 1, comparable);
                city[s].d = 0;
                minHeap.add(city[s]);
                p = new int[n + 1];
                while (!minHeap.isEmpty()) {
                    City xCity = minHeap.poll();
                    for (City cur : xCity.link) {
                        if (costTable[xCity.id][cur.id] < cur.d) {
                            p[cur.id] = xCity.id;
                            cur.d = costTable[xCity.id][cur.id];
                            minHeap.add(cur);
                        }
                    }
                }
                System.out.println();
                for (int i = 1; i < n; i++) System.out.print(i < 10 ? "  " + i : " " + i);
                System.out.println();
                for (int i = 1; i < n; i++) System.out.print(p[i] < 10 ? ("  " + p[i]) : " " + p[i]);
                System.out.println();

                int sum = 0;
                int e = d;
                while (p[e] != e) {
                    sum += costTable[p[e]][e];
                    e = p[e];
                }
                System.out.println("answer=" + sum);
//                bw.append("answer=" + sum + "\n");
            }


        }
        bw.flush();
    }

}
