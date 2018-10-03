package URI.Trying.NOSTATUS.AD_HOC;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: Ad-Hoc
 * @Problem: 2418 : Carnaval
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2418
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class P2418_Carnaval {

    public static void main(String[] args) throws IOException {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.UP);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        double[] x = new double[5];
        double sum = 0.0;
        double answer = 0.0;
        for (int i = 0; i < 5; i++) {
            sum += x[i] = Double.parseDouble(st[i]);
        }
        double tmp = ((sum * 100.0) / 50.0);
        System.out.println(tmp);
        answer = ((tmp * 30.0) / 100.0);
        System.out.println(df.format(answer));
    }
}
