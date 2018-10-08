package AIZU.Trying.ITP1;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: AIZU ONLINE JUDGE
 * @Categories: ITP1
 * @Problem:
 * @Link:
 * @Timelimit: 1 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ITP1_10_A_Distance {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        double x1 = Double.parseDouble(st[0]);
        double y1 = Double.parseDouble(st[1]);
        double x2 = Double.parseDouble(st[2]);
        double y2 = Double.parseDouble(st[3]);
        BigDecimal d = new BigDecimal(Math.sqrt((Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0))));
        System.out.printf("%.81f\n", Double.parseDouble(d.toString()));
    }
}
