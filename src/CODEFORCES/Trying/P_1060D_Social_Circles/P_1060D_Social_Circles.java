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

public class P_1060D_Social_Circles {

    static int n;
    static Guest[] guest;
    static Circle[] circle;
    static int answer;

    static private class Circle implements Cloneable {
        int sum;
        Guest start;
        Guest end;

        public Circle(Guest g, int sum) {
            this.start = g;
            this.end = g;
            this.sum = sum;
        }

        int getLeft() {
            return this.start.L;
        }

        int getRight() {
            return this.end.R;
        }

        int getSum() {
            int sum = 0;
            int emptyL = this.start.L;
            int emptyR = this.end.R;

            Guest cur = start.right;
            while (cur != end) {
                sum += cur.L;
                cur = cur.right;
            }
            sum += this.end.L;
            sum -= Math.abs(emptyL - emptyR);
            return sum;
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
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

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
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
        circle = new Circle[n];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            int l = Integer.parseInt(st[0]);
            int r = Integer.parseInt(st[1]);
            guest[i] = new Guest(l, r);
            guest[i].id = i + 1;
            circle[i] = new Circle(guest[i], (l + r) + 1);
        }


        for (int i = 0; i < n; i++) {
            boolean[] v = new boolean[n];
            v[i] = true;
            find(circle[i], v, 2);
        }

        System.out.println(answer);
    }

    static void find(Circle c, boolean[] v, int level) throws CloneNotSupportedException {
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                v[i] = true;
                //Connect Left
                Circle tmp = (Circle) c.clone();
                tmp.start.left = guest[i];
                guest[i].right = tmp.start;
                tmp.start = guest[i];
                if (level < n) {
                    find(tmp, v, level + 1);
                } else if (level == n) {
                    int sum = tmp.getSum();
                    if (answer > sum) {
                        answer = sum;
                    }
                }

                //Connect Right
                tmp = (Circle) c.clone();
                tmp.end.right = guest[i];
                guest[i].left = tmp.end;
                tmp.end = guest[i];
                if (level < n) {
                    find(tmp, v, level + 1);
                } else if (level == n) {
                    int sum = tmp.getSum();
                    if (answer > sum) {
                        answer = sum;
                    }
                }
            }
        }
    }

}


