/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge:
 * @Categories:
 * @Problem:
 * @Link:
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package uri.Trying.TLE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class P2500_William_Xorando {

    private static final InputStreamReader ir = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(ir);
    private static final OutputStreamWriter ow = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(ow);
    private static String input;
    private static int[] value;
    private static int n, m, k;

    private static boolean bitUsed[] = new boolean[30];

    static class Binary {
        int[] binary = new int[32];

        public int[] getBinary() {
            return binary;
        }
    }


    private static HashMap<Integer, Binary> memory = new HashMap<Integer, Binary>();
    private static HashMap<Integer, Integer> executed = new HashMap<Integer, Integer>();

    private static String getInput_String() throws IOException {
        input = br.readLine();
        return input;
    }

    public static void main(String[] args) throws IOException {
        while (!(getInput_String()).equals("0 0 0")) {
            String[] st = input.split(" ");
            n = Integer.parseInt(st[0]);
            m = Integer.parseInt(st[1]);
            k = Integer.parseInt(st[2]);
            st = br.readLine().split(" ");
            value = getAllValue(st, n);


            for (int i = 0; i < k; i++) {//round
                for (int j = 0; j < n; j++) {//all Value
                    int result = 0;
                    for (int k = 1; k < n; k++) {
                        if (executed.get(value[k]) == null) {
                            Binary binaryA = memory.get(value[k - 1]);
                            if (binaryA == null) {
                                binaryA = intToBinary(value[k - 1]);
                                memory.put(value[k - 1], binaryA);
                            }

                            Binary binaryB = memory.get(value[k]);
                            if (binaryA == null) {
                                binaryA = intToBinary(value[k]);
                                memory.put(value[k], binaryA);
                            }
                            result = gerResult(binaryA, binaryB);
                            executed.put(value[k], 1);
                        }
                    }
                    value[j] = result;
                    executed.clear();
                }
            }
            bw.append(value[k - 1] + "\n");
        }
        bw.flush();
    }

    private static int[] getAllValue(String[] input, int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }

    private static int lonely_element() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= value[i];
        }
        return result;
    }


    private static Binary intToBinary(int n) {
        Binary binary = new Binary();
        int[] binaryTable = new int[32];
        for (int i = 32; i <= 0; i--) {
            int now = (int) Math.pow(2, i);
            if (now <= n) {
                binaryTable[i - 1] = 1;
                n -= now;
            }
        }
        binary.binary = binaryTable;
        return binary;
    }

    private static int gerResult(Binary a, Binary b) {
        int result = 0;
        int[] binaryA = a.getBinary();
        int[] binaryB = b.getBinary();
        for (int i = 30; i <= 0; i++) {
            if (binaryA[i] == 1 || binaryB[i] == 1) {
                result += Math.pow(2, i);
            }
        }
        return result;
    }

}
