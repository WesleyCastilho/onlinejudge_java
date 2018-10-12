package URI.Trying.TLE;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: BEGINNER
 * @Problem: 2720 - Large Presents
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2720
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: Sorted List
 * @Note:
 */

import URI.Trying.NOSTATUS.STRING.P1519_Abbreviations;

import java.io.*;
import java.net.URL;
import java.util.*;

public class P2720_Large_Presents {

    static int n, k, id, heigth, width, length;

    static class Gift implements Comparable {
        int id;
        int size;

        public Gift(int id, int size) {
            this.id = id;
            this.size = size;
        }


        @Override
        public int compareTo(Object o) {
            Gift gift2 = (Gift) o;
            int comp1 = this.size == gift2.size ? 0 : this.size < gift2.size ? -1 : 1;
            if (comp1 == 0) {
                if (this.id < gift2.id) {
                    return 1;
                } else if (this.id > gift2.id) {
                    return -1;
                }
            }
            return comp1;
        }
    }

    public static void main(String[] args) throws IOException {
        URL path = P2720_Large_Presents.class.getResource("input/P2720_input.txt");
        File f = new File(path.getFile());

        Scanner sc = new Scanner(f);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            Gift[] giftArr = new Gift[n];
            createLoop:
            for (int i = 0; i < n; i++) {
                id = sc.nextInt();
                heigth = sc.nextInt();
                width = sc.nextInt();
                length = sc.nextInt();
                int size = heigth + width * length;
                giftArr[i] = new Gift(id, size);
            }

            Arrays.sort(giftArr);

            boolean printed = false;
            for (int i = 0; i < k; i++) {
                if (!printed) {
                    printed = true;
                } else {
                    bw.append(" ");
                }
                bw.append(giftArr[i].id + "");
            }
            bw.append("\n");
            bw.flush();
        }

    }


}
