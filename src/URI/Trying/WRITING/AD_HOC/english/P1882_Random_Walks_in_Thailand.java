/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1882 Random Walks in Thailand
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1882
 * @Timelimit: 4 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: -Graph Problem หาจำนอนเงินน้อยที่สุด ที่จะสามารถเดินทาง ทุกเกาะ
 * @Note:
 */

package URI.Trying.WRITING.AD_HOC.english;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class P1882_Random_Walks_in_Thailand {

    private static int N, M, F;
    private static double minimumCost;
    private static Island[] island;
    private static int[][] boatCost;

    private static class Island {
        int id;
        LinkedList<Island> link;

        public Island(int id) {
            this.id = id;
            this.link = new LinkedList<>();
        }

        void addLink(Island island) {
            this.link.add(island);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        DecimalFormat df = new DecimalFormat("0.000");
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            F = Integer.parseInt(br.readLine());
            island = new Island[N];
            boatCost = new int[N][N];
            for (int i = 0; i < N; i++) island[i] = new Island(i);
            for (int i = 0; i < M; i++) {
                String[] st = br.readLine().split(" ");
                int a = Integer.parseInt(st[0]);
                int b = Integer.parseInt(st[1]);
                int c = Integer.parseInt(st[2]);

                island[a].addLink(island[b]);
                island[b].addLink(island[a]);
                boatCost[a][b] = c;
                boatCost[b][a] = c;
            }
            minimumCost = 0;



            bw.append(df.format(minimumCost) + "\n");
        }
        bw.flush();
    }

}
