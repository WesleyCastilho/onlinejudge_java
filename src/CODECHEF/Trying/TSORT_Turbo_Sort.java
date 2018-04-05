package CODECHEF.Trying;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: CODECHEF
 * @Categories:
 * @Problem: TSORT : Turbo Sort
 * @Link: https://www.codechef.com/problems/TSORT
 * @Timelimit: 1 sec
 * @Status: TLE
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TSORT_Turbo_Sort {

    public TSORT_Turbo_Sort() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        int i = 0;
        int count = 0;
        int min = 0;
        int max = 0;
        while (true) {
            int now = Integer.parseInt(br.readLine());
            if (min == 0 && max == 0) {
                min = now;
                max = now;
                data[0] = now;
            } else if (now <= min) {
                //ltmp -> tmp
                int k = 1;
                int tmp, ltmp = data[k - 1];
                for (; k <= count; k++) {
                    tmp = data[k];
                    data[k] = ltmp;
                    ltmp = tmp;
                }
                data[0] = now;
                min = data[0];
            } else if (now >= max) {
                data[count] = now;
                max = data[count];
            } else {
                int index = 0;
                for (int j = 1; j < count; j++) {
                    if (now <= data[j]) {
                        index = j;
                        int k = j + 1;
                        int tmp;
                        for (k = j + 1; k < count; k++) {
                            data[k] = data[k - 1];
                            tmp = data[k];
                        }
                        data[j] = now;
                        break;
                    }
                }
                data[index] = now;
            }
            if (++count == n) break;
        }
        i = 0;
        while (true) {
            bw.append(data[i] + "\n");
            if (++i == n) break;
        }
        bw.flush();
    }

}
