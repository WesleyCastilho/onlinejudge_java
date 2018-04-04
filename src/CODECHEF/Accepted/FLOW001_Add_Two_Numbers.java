package CODECHEF.Accepted;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: CODECHEF
 * @Categories: Practice(Beginner)
 * @Problem: FLOW001 : Add Two Numbers
 * @Link: https://www.codechef.com/problems/FLOW001
 * @Timelimit: 1 sec
 * @Status: AC
 * @Memory: 4468M
 * @Submission: 2018-04-04 10:34:48
 * @Runtime: 0.06s
 * @Solution:
 * @Note:
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FLOW001_Add_Two_Numbers {

    public FLOW001_Add_Two_Numbers() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while ((t-- > 0)) {
            String[] st = br.readLine().split(" ");
            int a = Integer.parseInt(st[0]);
            int b = Integer.parseInt(st[1]);
            bw.append((a + b) + "\n");
        }
        bw.flush();
    }

}
