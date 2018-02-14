package uri.Trying.NOSTATUS;


/**
 * Created by teerapat on 1/30/2018.
 * https://www.urionlinejudge.com.br/judge/en/problems/view/2718
 */

import java.io.*;
import java.math.BigInteger;

public class P2718_Christmas_Lights {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int max = 50;
        while (n-- > 0) {
            BigInteger d = new BigInteger(br.readLine());
            char[] binary = d.toString(2).toCharArray();
            int size = binary.length;
            int last = 0;
            int[] burnedSize = new int[1000];
            int count = 0;
            boolean counted = false;
            for (int i = 0; i < size; i++) {
                if (binary[i] == '1') {
                    count++;
                    counted = true;
                } else if (counted && binary[i] == '0') {
                    counted = false;
                    int j = last;
                    System.out.println(count);
                    burnedSize[j] = count;
                    if (j > 0) {
                        for (; j < 1000 && j > 0; j--) {
                            if (burnedSize[j] > burnedSize[j - 1]) {
                                int tmp = burnedSize[j];
                                burnedSize[j] = burnedSize[j - 1];
                                burnedSize[j - 1] = tmp;
                            }
                        }
                    }
                    last++;
                    count = 0;
                }
            }

            int total = 0;

//            System.out.println(binary);
        }
        bw.flush();

    }
}
