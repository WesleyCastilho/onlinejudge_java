package URI.Trying.NOSTATUS.CONPUTATIONAL_GEOMETRY;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 2518 - FNDI's Staircase
 * @Link: https://www.urionlinejudge.com.br/repository/UOJ_2518_en.html
 * @Timelimit: 1 sec
 * @Status:
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
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class P2518_FNDIs_Staircase {

    private static double N, H, C, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        DecimalFormat df = new DecimalFormat("0.0000");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        String in;
        while ((in = br.readLine()) != null) {
            N = Double.parseDouble(in);//step
            String[] st = br.readLine().split(" ");
            H = Double.parseDouble(st[0]);//high
            C = Double.parseDouble(st[1]);//long
            L = Double.parseDouble(st[2]);//wide

            //กว้าง * ยาว = พื้นที่สี่เหลี่ยมผืนผ้า
            double answer = 0;
            double d1 = (C * L);
            double d2 = (L * H);

            bw.append(df.format(answer) + "\n");
            bw.flush();
        }
        bw.flush();
    }


}
