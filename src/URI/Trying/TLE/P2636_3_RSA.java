package URI.Trying.TLE;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 2698 - Daunting Device
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2698
 * @Timelimit: 1 sec
 * @Status: TLE
 * @Submission:
 * @Runtime:
 * @Solution: find last of 3 factor
 * @Note: https://www.calculatorsoup.com/calculators/math/factors.php
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class P2636_3_RSA {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while (!(in = br.readLine()).equals("0")) {
            long n = Long.parseLong(in);
            int[] result = find3FactorRSAPrime(n);
            bw.append(in + " = " + result[0] + " x " + result[1] + " x " + result[2] + "\n");
            bw.flush();
        }
        bw.flush();
    }

    static int[] find3FactorRSAPrime(long n) {
        int P = 0, Q = 0, R = 0;
        int size = (int) Math.round(Math.sqrt(n));
        for (int i = 1; i < size; i++) {
            if (n % i == 0) {
                P = Q;
                Q = R;
                R = i;
            }
        }
        return new int[]{P, Q, R};
    }


}
