package AIZU.Trying.ITP1;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: AIZU ONLINE JUDGE
 * @Categories:  ITP1
 * @Problem:
 * @Link:
 * @Timelimit: 1 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class ITP1_7_B_How_many_ways {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int answer;

    public static void main(String[] args) throws IOException {
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] st = input.split(" ");
            int n = Integer.parseInt(st[0]);
            int answer = Integer.parseInt(st[1]);

            for (int i = 1; i <= n; i++) {
                boolean[] used = new boolean[n + 1];
                used[i] = true;
                System.out.println("now >> " + i);
                System.out.println("x >> " + answer);
                dp(i, answer - i, used);
//                System.out.println("ssss");
            }

        }
        bw.flush();
    }

    static void dp(int now, int x, boolean[] used) throws IOException {
        ++now;
        System.out.println("now >> " + now);
        System.out.println("x >> " + x);
        if (now >= x) return;
        if (now == x) {
            used[now] = true;
            boolean printed = false;
            int i = 1;
            for (boolean t : used) {
                if (printed) bw.append("+ " + i);
                else bw.append(i + " ");
                i++;
            }
            bw.append(" = " + answer);
        } else {
            used[now] = true;
            dp(now, x - now, used);
        }
    }

}
