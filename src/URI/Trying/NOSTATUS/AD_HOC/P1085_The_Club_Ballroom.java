/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1086 - The Club Ballroom
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1086
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: QuickSort + Greedy algorithm
 * @Note:
 */
package URI.Trying.NOSTATUS.AD_HOC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1085_The_Club_Ballroom {

    public P1085_The_Club_Ballroom() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] plank;
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] st = input.split(" ");
            int n = Integer.parseInt(st[0]);//width
            int m = Integer.parseInt(st[1]);//higth
            int l = Integer.parseInt(br.readLine());//1 - 100 cm
            int k = Integer.parseInt(br.readLine());
            st = br.readLine().split(" ");//planks
            int answer = 0;
            int width = l * Math.min(n, m);
            if ((l * k) < width) {
                bw.append("impossivel\n");
            } else {
                int c1 = 0;
                int c2 = 0;
                plank = new int[k];
                for (int i = 0; i < k; i++) {
                    plank[i] = Integer.parseInt(st[i]);
                }

                //Iterator Node
//                Node cur = plankList.getFirstNode();
//                while (cur != null) {
//                    System.out.print(" " + cur.data);
//                    cur = cur.next;
//                }
//                System.out.println();

                //width Test
                int usedA = 0;

                //higth Test

//                answer = usedA < usedB ? usedA : usedB;
                bw.append((answer > 0 ? answer : "impossivel") + "\n");
            }
        }
        bw.flush();
    }

    boolean build(int[] plank, int n, int width, int height, boolean[] used) {
//        build(plank);
        return false;
    }


}
