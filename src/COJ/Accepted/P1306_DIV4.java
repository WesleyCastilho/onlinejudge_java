package th.in.devboom.coj.accepted;


/**
 * Created by Teerapat-BSD on 2/2/2018.
 * Judgment : Accepted
 * Time : 233
 * Date : 2018-02-01 23:31:54
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;

public class P1306_DIV4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            BigDecimal b = new BigDecimal(br.readLine());
            bw.append(b.remainder(new BigDecimal("4")).compareTo(BigDecimal.ZERO) == 0 ? "YES\n" : "NO\n");
        }
        bw.flush();
    }
}
