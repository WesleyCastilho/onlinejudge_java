/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge:
 * @Categories:
 * @Problem:
 * @Link:
 * @Level:
 * @Timelimit:
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

package URI.Trying.WRITING.PARADIGMS;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class P1395_Numbers_and_Operations {

    private static class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static class

    static HashMap<Pair, Long> additionMemory;
    static HashMap<Pair, Long> multiplicationMemory;
    static HashMap<Pair, Long> subtractionMemory;
    static HashMap<Pair, Long> divisionMemory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while (!(in = br.readLine()).equals("0")) {
            String[] st = br.readLine().split(" ");
            int a = Integer.parseInt(st[0]);
            int n = Integer.parseInt(st[1]);
            additionMemory = new HashMap<Pair, Long>();
            multiplicationMemory = new HashMap<Pair, Long>();
            subtractionMemory = new HashMap<Pair, Long>();
            divisionMemory = new HashMap<Pair, Long>();
            int[] number = new int[n];
            for (int i = 0; i < n; i++) {
                number[i] = Integer.parseInt(st[i + 2]);
            }


        }
        bw.flush();
    }

}