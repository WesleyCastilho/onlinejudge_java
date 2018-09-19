package ZOJ.Trying;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: ZOJ
 * @Problem: 1028 : Flip and Shift
 * @Link: http://acm.zju.edu.cn/onlinejudge/showProblem.do?problemCode=1028
 * @Timelimit: 2 Seconds
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: circular queue
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class P1028_Flip_and_Shift {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            boolean goal = false;
            String[] st = br.readLine().split(" ");
            int size = Integer.parseInt(st[0]);
            int[] track = new int[size];
            for (int i = 0; i < size; i++) {
                track[i] = Integer.parseInt(st[i]);
            }



            bw.append((goal ? "YES" : "NO") + "\n");
        }
        bw.flush();
    }

}
