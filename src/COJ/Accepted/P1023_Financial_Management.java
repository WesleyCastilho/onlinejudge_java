package th.in.devboom.coj.accepted;

/**
 * Created by Teerapat-BSD on 1/29/2018.
 * Judgment : Accepted
 * Time : 250
 * Date : 2018-01-29 04:12:34
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class P1023_Financial_Management {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat df = new DecimalFormat("0.00");
        double answer = 0.00;
        for (int i = 0; i < 12; i++) {
            answer += Double.parseDouble(br.readLine());
        }
        answer = answer / 12;
        System.out.println("$" + df.format(answer));
    }
}
