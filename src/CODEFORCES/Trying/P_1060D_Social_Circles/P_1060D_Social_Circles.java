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

import java.io.*;

public class P_1060D_Social_Circles {

    static int n;
    static Guest[] guest;

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
        BufferedReader br = new BufferedReader(new FileReader("in.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            int l = Integer.parseInt(st[0]);
            int r = Integer.parseInt(st[1]);
            guest[i] = new Guest(l, r);
            guest[i].id = i;
        }

        Circle c = new Circle();
        c.start = guest[0];
        c.end = guest[0];

        boolean[] used = new boolean[n];
        used[0] = true;
        int sum = 0;
        for (int count = 1; count < n; count++) {
            int minimum = Integer.MAX_VALUE;
            Guest minimumGuest = null;
            char direct = ' ';
            for (int i = 1; i < n; i++) {
                if (!used[i]) {
                    int right = Math.abs(c.end.R - guest[i].L);
                    int left = Math.abs(c.start.L - guest[i].R);
                    if (left <= right && minimum > left) {
                        minimumGuest = guest[i];
                        direct = 'L';
                        minimum = left;
                    } else if (right <= left && minimum > right) {
                        minimumGuest = guest[i];
                        direct = 'R';
                        minimum = right;
                    }
                }
            }

            used[minimumGuest.id] = true;
            System.out.println(direct);
            switch (direct) {
                case 'L':
                    minimumGuest.right = c.start;
                    c.start.left = minimumGuest;
                    c.start = minimumGuest;
                    break;
                case 'R':
                    minimumGuest.left = c.end;
                    c.end.right = minimumGuest;
                    c.end = minimumGuest;
                    break;
            }
            sum += minimum;


            Guest cur = c.start;
            while (cur != null) {
                System.out.print(cur.id + " ");
                cur = cur.right;
            }
            System.out.println();
        }
        System.out.println(sum + n);
    }


}


