/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1912 Help Seu Madruga
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1912
 * @Timelimit: 4 sec
 * @Status: WA 90%
 * @Submission:
 * @Runtime:
 * @Solution: sort and binary search
 * @Note:
 */
package URI.Trying.WA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

public class P1912_Help_Seu_Madruga {

    static int n, a;
    static int[] c;

    public P1912_Help_Seu_Madruga() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        DecimalFormat df = new DecimalFormat("0.0000");
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] st = input.split(" ");
            n = Integer.parseInt(st[0]);
            a = Integer.parseInt(st[1]);
            st = br.readLine().split(" ");
            int size = st.length;
            double sum = 0;
            c = new int[n];
            int i = 0;
            for (String s : st) {
                sum += c[i] = Integer.parseInt(st[i++]);
            }
            if (sum < a) {
                bw.append("-.-\n");
            } else if (sum == a) {
                bw.append(":D\n");
            } else {
//                Arrays.sort(c, new Comparator<Integer>() {
//                    @Override
//                    public int compare(Integer o1, Integer o2) {
//                        return o2.compareTo(o1);
//                    }
//                });


                bw.append(df.format(binarysearch()) + "\n");

            }
            bw.flush();
        }
        bw.flush();
    }

    static double calc(double v2) {
        double ans = 0.0;
        for (int i = n - 1; i >= 0; --i) {
            if (v2 < c[i]) {
                return ans;
            }

            ans += (double) c[i] - v2;
        }
        return ans;
    }

    static double binarysearch() {
        double b = 0.;
        double e = (double) c[n - 1];
        double mid;

        while (b <= e) {
            mid = (b + e) / 2.0;
            double d = calc(mid);

            if (Math.abs(d - (double) a) < -10000) {
                return mid;
            }

            if (d < a) {
                e = mid;
            } else {
                b = mid;
            }

        }
        return -1;
    }

    void mergeSort(int[] data, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(data, left, mid);
        mergeSort(data, mid + 1, right);
        merge(data, left, mid, right);
    }

    void merge(int[] data, int left, int mid, int right) {
        int[] tmp = new int[(mid - left) + (right - mid)];
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                tmp[k] = data[j++];
                continue;
            }
            if (j > right) {
                tmp[k] = data[i++];
                continue;
            }
            tmp[k] = (data[i] < data[j]) ? data[i++] : data[j++];
        }
        //copy t to data
        for (int k = left; k <= right; k++) {
            data[k] = tmp[k];
        }
    }

}
