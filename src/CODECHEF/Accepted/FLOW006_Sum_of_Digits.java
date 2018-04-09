package CODECHEF.Accepted;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: CODECHEF
 * @Categories: Practice(Beginner)
 * @Problem: FLOW006 : Sum of Digits
 * @Link: https://www.codechef.com/problems/FLOW006
 * @Timelimit: 1 sec
 * @Status: AC
 * @Memory: 4468M
 * @Submission: 2018-04-09 16:41:33
 * @Runtime: 0.05
 * @Solution:
 * @Note:
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FLOW006_Sum_of_Digits {

    public FLOW006_Sum_of_Digits() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int sum = 0;
            char[] c = br.readLine().toCharArray();
            int size = c.length;
            for (int i = 0; i < size; i++) {
                sum += (c[i] - '0');
            }
            bw.append(sum + "\n");
        }
        bw.flush();
    }
}
