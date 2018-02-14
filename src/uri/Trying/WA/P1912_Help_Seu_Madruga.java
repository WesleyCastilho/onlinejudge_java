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
    static Integer[] c;

    public static void main(String[] args) throws IOException {
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
            c = new Integer[n];
            int i = 0;
            for (String s : st) {
                sum += c[i] = Integer.parseInt(st[i++]);
            }
            if (sum == a) {
                bw.append(":D\n");
            } else if (sum < a) {
                bw.append("-.-\n");
            } else {
                Arrays.sort(c, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                });
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

}
