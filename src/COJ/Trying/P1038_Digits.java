package COJ.Trying;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: COJ
 * @Categories:
 * @Problem: 1038 - Digits
 * @Link: http://coj.uci.cu/24h/problem.xhtml?pid=1038
 * @Timelimit: 1 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.math.BigDecimal;

public class P1038_Digits {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new BufferedOutputStream(System.out);
        String in;
        while (!(in = br.readLine()).equals("END")) {
            BigDecimal number = new BigDecimal(in);
            out.write((digitCounting(number) + "\n").getBytes());
            out.flush();
        }
        out.flush();
    }

    static int digitCounting(BigDecimal n) {
        int count = 0;
        while (n.compareTo(BigDecimal.ZERO) > 0) {
            n = n.divide(new BigDecimal(2));
            System.out.println(n);
        }
        return count;
    }

}
