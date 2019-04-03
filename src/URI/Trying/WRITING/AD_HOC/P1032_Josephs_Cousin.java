/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge:URI Online Judge 
 * @Categories: Ad-HOc
 * @Problem: 1032 - Joseph’s Cousin
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1032
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI.Trying.WRITING.AD_HOC;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;

public class P1032_Josephs_Cousin {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream bw = new BufferedOutputStream(System.out);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n;
        for (n = 1; n <= 3501; n++) {
            map.put(n, Josephus(n));
        }
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            bw.write((map.get(n) + "\n").getBytes());
        }
        bw.flush();

    }

    static int Josephus(int n) {
        boolean[] binary = new boolean[12];
        switch (n) {
            case 1:
            case 2:
            case 4:
            case 8:
            case 16:
            case 32:
            case 64:
            case 128:
            case 254:
            case 512:
            case 1024:
            case 2048:
                return 1;
            default:
                boolean isFirst = false;
                for (int i = 11; i >= 0; i--) {
                    int now = (int) Math.pow(2, i);
                    if (n - now >= 0) {
                        n -= now;
                        if (!isFirst) {
                            isFirst = true;
                        } else {
                            binary[i] = true;
                        }
                    }
                }
                int result = 0;
                for (int i = 0; i <= 11; i++) {
                    if (binary[i]) {
                        result += (int) Math.pow(2, i);
                    }
                }
                return result + 2;

        }
    }

}
