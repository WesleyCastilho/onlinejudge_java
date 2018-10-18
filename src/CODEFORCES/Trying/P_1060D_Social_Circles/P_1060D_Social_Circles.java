package CODEFORCES.Trying.P_1060D_Social_Circles;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: CODEFORCES
 * @Categories:
 * @Problem: 1060D_Social_Circles
 * @Link: http://codeforces.com/problemset/problem/1060/D
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Memory:
 * @Solution: DP find min
 * @Note:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class P_1060D_Social_Circles {

    static int n;
    static Guest[] guest;
    static int minimum;

    static private class Circle {
        Guest start;
        Guest end;
    }

    static private class Guest {
        int id;
        int L, R;
        Guest left;
        Guest right;

        public Guest(int l, int r) {
            L = l;
            R = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] st;

        if (n == 1) {
            st = br.readLine().split(" ");
            int l = Integer.parseInt(st[0]);
            int r = Integer.parseInt(st[1]);
            System.out.println((l > r ? l : r) + 1);
            return;
        }

        guest = new Guest[n];
        minimum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            int l = Integer.parseInt(st[0]);
            int r = Integer.parseInt(st[1]);
            guest[i] = new Guest(l, r);
            guest[i].id = i + 1;
        }

        for (int i = 0; i < n; i++) {
            Circle c = new Circle();
            c.start = guest[i];
            c.end = guest[i];
            boolean[] v = new boolean[n];
            v[i] = true;
            int sum = guest[i].L + guest[i].R + 1;
            find(c, v, sum, 1);
        }

        System.out.println(minimum);
    }

    static void find(Circle c, boolean[] v, int sum, int level) {

        if (level == 3) {
            Guest cur = c.start;
            while (cur != null) {
                System.out.print(cur.id);
                cur = cur.right;
                if (cur != null) System.out.print("-");
            }
            System.out.println("\nSum=" + sum);
            minimum = sum;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                v[i] = true;
                //test connect Left
                int sumLeft = sum + (Math.abs(c.end.R - guest[i].L) + Math.abs(c.start.L - guest[i].R)) + 1;
                Circle tmpC1 = new Circle();
                Guest tmpG1 = new Guest(guest[i].L, guest[i].R);
                tmpG1.right = tmpC1.start;
                tmpC1.start = tmpG1;
                tmpC1.end = c.end;
                find(tmpC1, v, sumLeft, level + 1);

                //test connect Right
                int sumRight = sum + (Math.abs(c.start.L - guest[i].R) + Math.abs(c.end.R - guest[i].L)) + 1;
                Circle tmpC2 = new Circle();
                Guest tmpG2 = new Guest(guest[i].L, guest[i].R);
                if (tmpC2.end != null) {
                    tmpC2.end.right = tmpG2;
                }
                tmpC2.end = tmpG2;
                tmpC2.start = c.start;
                find(tmpC2, v, sumRight, level + 1);

                v[i] = false;
            }
        }

    }

}


