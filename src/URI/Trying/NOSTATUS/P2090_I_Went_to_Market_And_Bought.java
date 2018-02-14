/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge:
 * @Categories:
 * @Problem:
 * @Link:
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI.Trying.NOSTATUS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class P2090_I_Went_to_Market_And_Bought {

    static BigInteger n, k, index;

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] st = input.split(" ");
            n = BigInteger.valueOf(Long.parseLong(st[0]));
            k = BigInteger.valueOf(Long.parseLong(st[1]));
            index = k.mod(n);
            st = br.readLine().split(" ");
            bw.append(st[index.intValue()] + "\n");
        }
        bw.flush();
    }

}
