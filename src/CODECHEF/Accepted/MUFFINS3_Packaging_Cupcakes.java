package CODECHEF.Accepted;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: CODECHEF
 * @Categories: Practice(Beginner)
 * @Problem: MUFFINS3 : Packaging Cupcakes
 * @Link: https://www.codechef.com/problems/MUFFINS3
 * @Timelimit: 1 secs
 * @Status: AC
 * @Memory: 4468M
 * @Submission: 2018-04-09 16:22:53
 * @Runtime: 0.06
 * @Solution:
 * @Note:
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MUFFINS3_Packaging_Cupcakes {

    public MUFFINS3_Packaging_Cupcakes() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            bw.append(((x / 2) + 1) + "\n");
        }
        bw.flush();
    }
}
