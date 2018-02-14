/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Jusge
 * @Categories: Data Structures
 * @Problem: 1500 - Horrible Queries
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1500
 * @Timelimit: 4 sec
 * @Status: TLE
 * @Submission:
 * @Runtime:
 * @Solution: Segment Tree
 * @Note:
 */
package uri.Trying.TLE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1500_Horrible_Queries {

    private static class FenwickTree {

        int[] array;

        public FenwickTree(int size) {
            this.array = new int[size + 1];
        }

    }

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);
        FenwickTree fenwickTree;
        int t = Integer.parseInt(br.readLine());
        int n, c;
        while (t-- > 0) {
            String[] st = br.readLine().split(" ");
            n = Integer.parseInt(st[0]);
            c = Integer.parseInt(st[1]);
            fenwickTree = new FenwickTree(n);
            while (c-- > 0) {
                st = br.readLine().split(" ");
                int start = Integer.parseInt(st[1]) - 1;
                int end = Integer.parseInt(st[2]);
                if (st[0].equals("0")) {
                    int value = Integer.parseInt(st[3]);
                    for (int i = start; i < end; i++) {
//                            fenwickTree.update(i, value);
                    }

                } else if (st[0].equals("1")) {//                        bw.append(fenwickTree.rsq(start, end) + "\n");

                }
            }
        }
        bw.flush();
    }

}
