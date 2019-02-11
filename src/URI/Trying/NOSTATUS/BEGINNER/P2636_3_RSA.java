package URI.Trying.NOSTATUS.BEGINNER;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 2698 - Daunting Device
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2698
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: find last of 3 factor
 * @Note: Created by Teerapat-BSD on 2/9/2018.   https://www.calculatorsoup.com/calculators/math/factors.php
 */

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;

public class P2636_3_RSA {

    static HashMap<Long, RSAPrime> memory = new HashMap<Long, RSAPrime>();
    static HashMap<Long, Boolean> prime = new HashMap<Long, Boolean>();

    static class RSAPrime {
        long P, Q, R;
        long result;

        public RSAPrime() {

        }

        public RSAPrime(long p, long q, long r) {
            this.P = p;
            this.Q = q;
            this.R = r;
            this.result = this.P * this.Q * this.R;
        }

        public long getP() {
            return P;
        }

        public long getQ() {
            return Q;
        }

        public long getR() {
            return R;
        }

        long getResult() {
            return result;
        }
    }

    private static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        long factor = 1;
        long number = 105;
        long a;
        long tmp = 1;
        long last = 0;
        while (true) {
            a = number / tmp;
//            System.out.println(a);
            if (a == last) break;
            if (number % a == 0) {
                System.out.println(tmp + " " + a);
                factor = a;
                last = a;
            }
            tmp++;
        }
        System.out.println(factor);

        //105 sqr = 10

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String in;
//        while (!(in = br.readLine()).equals("0")) {
//            long n = Long.parseLong(in);
//
//            NumberFormat formatter = new DecimalFormat("#0.00000");
//            long start = System.currentTimeMillis();
//            RSAPrime rsa = memory.get(n);
////            System.out.println(rsa == null);
//            if (rsa == null) {
//                rsa = findRSAPrime(n);
//            }
//            long end = System.currentTimeMillis();
//            double totalTime = (end - start) / 1000d;
//            bw.append(in + " = " + rsa.getP() + " x " + rsa.getQ() + " x " + rsa.getR() + "  runtime:" + formatter.format(totalTime) + "\n");
//            bw.flush();
//        }
//        bw.flush();
    }

    static RSAPrime findRSAPrime(long result) {
        RSAPrime output = new RSAPrime();
        loop1:
        for (long p = 0; p < result; p++) {

            if (!isPrime(p)) {
                continue loop1;
            }

            loop2:
            for (long q = p + 1; q < result; q++) {

                if (!isPrime(q)) {
                    continue loop2;
                }

                loop3:
                for (long r = q + 1; r < result; r++) {
                    if (!isPrime(r)) {
                        continue loop3;
                    }

                    RSAPrime rsa = new RSAPrime(p, q, r);
                    long a = rsa.getResult();
                    memory.put(a, rsa);
                    if (a == result) {
                        output = rsa;
                        break loop1;
                    } else {

                    }


                }
            }
        }
        return output;
    }
}
