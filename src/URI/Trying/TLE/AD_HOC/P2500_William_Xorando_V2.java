package URI.Trying.TLE.AD_HOC;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: AD-HOC
 * @Problem: 2500 - William Xorando
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2500
 * @Timelimit: 1 sec
 * @Status: TLE
 * @Submission:
 * @Runtime:
 * @Solution: Bitset
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.BitSet;


public class P2500_William_Xorando_V2 {

    private static final InputStreamReader ir = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(ir);
    private static final OutputStreamWriter ow = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(ow);

    public static void main(String[] args) throws IOException {
        String input;
        while (!(input = br.readLine()).equals("0 0 0")) {
            String[] st = input.split(" ");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);
            int k = Integer.parseInt(st[2]);
            BitSet[] bsArr = new BitSet[n];
            st = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                bsArr[i] = convertToBitset(Long.parseLong(st[i]));
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int q = 0; q < n; q++) {
                        if (q != j) {
                            bsArr[j].xor(bsArr[q]);
                        }
                    }
                }
                for (int j = 1; j < n; j++) {
                    bsArr[0].xor(bsArr[j]);
                }
            }

            long answer = convertToLong(bsArr[k - 1]);
            bw.append(answer + "\n");
        }
        bw.flush();
    }

    public static BitSet convertToBitset(long value) {
        BitSet bits = new BitSet();
        int index = 0;
        while (value != 0L) {
            if (value % 2L != 0) {
                bits.set(index);
            }
            ++index;
            value = value >>> 1;
        }
        return bits;
    }

    public static long convertToLong(BitSet bits) {
        long value = 0L;
        for (int i = 0; i < bits.length(); ++i) {
            value += bits.get(i) ? (1L << i) : 0L;
        }
        return value;
    }

}
