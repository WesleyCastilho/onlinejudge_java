package SPOJ.Trying.runtime_error;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: SPOJ
 * @Problem: Prime Generator
 * @Link: https://www.spoj.com/problems/PRIME1/
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


public class Prime_Generator {

    static long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
    static int[] prime = new int[100001];
    static int[] primeNegative = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] st = br.readLine().split(" ");
            int a = Integer.parseInt(st[0]);
            int b = Integer.parseInt(st[1]);
            if (a < min && b > max) {
                for (int i = a; i <= b; i++) {
                    if (isPrime(i) == 1) {
                        prime[i] = 1;
                        bw.append(i + "\n");
                        continue;
                    }
                }
                if (a < min) {
                    min = a;
                }
                if (b > max) {
                    max = b;
                }
            } else if (a >= min && b <= max) {
                for (int i = a; i <= b; i++) {
                    if (prime[i] == 1) {
                        bw.append(i + "\n");
                    }
                }
            } else if (a < min) {
                for (int i = a; i < min; i++) {
                    if (isPrime(i) == 1) {
                        prime[i] = 1;
                        bw.append(i + "\n");
                        continue;
                    }
                }
                for (int i = (int) min; i < b; i++) {
                    if (isPrime(i) == 1) {
                        prime[i] = 1;
                        bw.append(i + "\n");
                        continue;
                    }
                }
                min = a;
            } else if (b > max) {
                for (int i = a; i < max; i++) {
                    if (prime[i] == 1) {
                        bw.append(i + "\n");
                    }
                }
                for (int i = (int) max; i < b; i++) {
                    if (isPrime(i) == 1) {
                        prime[i] = 1;
                        bw.append(i + "\n");
                        continue;
                    }
                }
                max = b;
            }

            bw.newLine();
        }
        bw.flush();
    }

    static int isPrime(int num) {
        if (num <= 1) return 0;
        if (num % 2 == 0 && num > 2) return 0;
        for (int i = 3; i < num / 2; i += 2) {
            if (num % i == 0)
                return 0;
        }
        return 1;
    }

}
