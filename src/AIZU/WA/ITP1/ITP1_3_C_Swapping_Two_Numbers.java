package AIZU.WA.ITP1;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: AIZU ONLINE JUDGE
 * @Categories:
 * @Problem: ITP1_3_C: Swapping Two Numbers
 * @Link: http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_3_C
 * @Timelimit: 1 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.*;

public class ITP1_3_C_Swapping_Two_Numbers {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] st = input.split(" ");
            int a = Integer.parseInt(st[0]);
            int b = Integer.parseInt(st[1]);
            bw.append((a < b ? st[1] + " " + st[0] : st[0] + " " + st[1]) + "\n");
        }
        bw.flush();
    }

}
