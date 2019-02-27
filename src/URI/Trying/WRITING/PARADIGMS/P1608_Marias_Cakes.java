package URI.Trying.WRITING.PARADIGMS;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: PARADIGMS
 * @Problem: 1608 - Maria's Cakes
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1608
 * @Level: 2
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: DP, 0/1 knapsack bottom up
 * @Note:
 */

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.LinkedList;

public class P1608_Marias_Cakes {

    static int D, I, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (--t > 0) {
            String[] st = br.readLine().split(" ");
            D = Integer.parseInt(st[0]);
            I = Integer.parseInt(st[1]);
            B = Integer.parseInt(st[2]);
            st = br.readLine().split(" ");
            int[] p = new int[I];//price of one unit of each ingredient
            for (int i = 0; i < I; i++) p[i] = Integer.parseInt(st[i]);
            LinkedList<Integer>[] c = new LinkedList[B];
            for (int i = 0; i < B; i++) {
                c[i] = new LinkedList();
                st = br.readLine().split(" ");
                for (String s : st) {
                    c[i].add(Integer.parseInt(s));
                }
            }
            /*
            D=10 I=2 B=2
            p=[3, 4]
            1 0 2
            1 1 1
             */


            int answer = 0;


            bw.append(answer + "\n");//maximum number of cakes of a single type that can be baked
        }
        bw.flush();
    }


}

