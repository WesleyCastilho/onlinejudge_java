/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: PARADIGMS
 * @Problem: 1084 - Erasing and Winning
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1084
 * @Level: 6
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: DP backtracking
 * @Note: ** หาวิธี backtracking
 */

package URI.Trying.WRITING.PARADIGMS.DP;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;


public class P1084_Erasing_and_Winning {

    static HashSet<String> memory;

    static int N, D;
    static BigInteger maxValue;

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
        String in;
        while (!(in = br.readLine()).equals("0 0")) {
            String[] st = in.split(" ");
            N = Integer.parseInt(st[0]);
            D = Integer.parseInt(st[1]);

            int[] num = new int[N];
            String sNumber = br.readLine();
            for (int i = 0; i < N; i++) num[i] = (sNumber.charAt(i) - '0');
            maxValue = null;
            memory = new HashSet<>();

            Comparator<Subset> comparator = new Comparator<Subset>() {
                @Override
                public int compare(Subset s1, Subset s2) {
                    BigInteger a = new BigInteger(s1.set);
                    BigInteger b = new BigInteger(s2.set);
                    int comp = a.compareTo(b);
                    if (comp > 1) {
                        return 1;
                    } else if (comp < 1) {
                        return -1;
                    }
                    return 0;
                }
            };
            PriorityQueue<Subset> maxHeap = new PriorityQueue<>(comparator);
            for (int i = 0; i < N; i++) {
                maxHeap.add(new Subset(i, num[i] + ""));
            }


            while (!maxHeap.isEmpty()) {
                Subset s = maxHeap.poll();

                BigInteger newValue = new BigInteger(s.set);
                int setSize = newValue.toString().length();
                if (maxValue == null) {
                    maxValue = newValue;
                } else if (newValue.compareTo(maxValue) > 0) {
                    maxValue = newValue;
                }
                if (setSize == N - D) {
                    continue;
                }


                int lastIndex = s.lastIndex;
                for (int i = lastIndex + 1; i < N; i++) {
                    String tmp = s.set + num[i];
                    if (!memory.contains(tmp)) {
                        memory.add(tmp);
                        maxHeap.add(new Subset(i, tmp));
                    }
                }
            }

            bw.append(maxValue + "\n");

        }
        bw.flush();
    }

    static int compare(String a, String b) {
        System.out.println("a=" + a + "   b=" + b);
        BigInteger bigA = new BigInteger(a);
        BigInteger bigB = new BigInteger(b);
        return bigA.compareTo(bigB);
    }


}