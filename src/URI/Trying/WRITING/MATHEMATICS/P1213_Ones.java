package URI.Trying.WRITING.MATHEMATICS;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1213 - Ones
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1213
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class P1213_Ones {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while ((in = br.readLine()) != null) {
            int n = Integer.parseInt(in);
            bw.append(findMultiplyCount(n) + "\n");
            bw.flush();
        }
        bw.flush();
    }

    static int findMultiplyCount(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (i % n != 0 ) {
                count++;
            }
        }
        return count;
    }

}
