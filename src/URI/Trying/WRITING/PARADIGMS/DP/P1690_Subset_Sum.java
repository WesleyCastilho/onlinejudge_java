/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: PARADIGMS
 * @Problem: 1690 - Subset Sum
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1690
 * @Level:
 * @Timelimit:
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

package URI.Trying.WRITING.PARADIGMS.DP;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;

public class P1690_Subset_Sum {

    static int N;
    static private HashSet<String> subSet;
    static private HashSet<Integer> sumSet;

    static private class Subset {
        int lastIndex;
        String set;

        public Subset(int lastIndex, String set) {
            this.lastIndex = lastIndex;
            this.set = set;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            N = Integer.parseInt(br.readLine());
            int[] number = new int[N];
            String[] st = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                number[i] = Integer.parseInt(st[i]);
            }
            subSet = new HashSet<>();
            sumSet = new HashSet<>();
            LinkedList<Subset> Q = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                subSet.add(number[i] + "");
                Q.add(new Subset(i, number[i] + ""));
            }

            int max = 0, min = Integer.MAX_VALUE;
            while (!Q.isEmpty()) {
                Subset s = Q.poll();
                if (s.set.length() == N) break;
                for (int i = s.lastIndex + 1; i < N; i++) {
                    String tmp = s.set + "," + number[i];
                    if (!subSet.contains(tmp)) {
                        subSet.add(tmp);
                        int sum = getSum(tmp);
                        sumSet.add(sum);
                        if (max < sum) {
                            max = sum;
                        }
                        if (min > sum) {
                            min = sum;
                        }
                        Q.add(new Subset(i, tmp));
                    }
                }
            }

            int[] allSum = new int[max + 1];
            for (int sum : sumSet) {
                allSum[sum] = 1;
//                System.out.println(set);
//                System.out.println("sum=" + getSum(set));
            }

            for (int i = min; i <= max + 1; i++) {
                if (allSum[i] == 0) {
                    bw.append(i + "\n");
                    break;
                }
            }
        }
        bw.flush();
    }


    static int getSum(String set) {
        int sum = 0;
        String[] st = set.split(",");
        for (int i = 0; i < st.length; i++) {
            sum += Integer.parseInt(st[i]);
        }
        return sum;
    }

}