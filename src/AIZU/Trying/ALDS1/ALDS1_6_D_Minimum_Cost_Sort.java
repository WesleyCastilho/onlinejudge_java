package AIZU.Trying.ALDS1;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: AIZU ONLINE JUDGE
 * @Categories: ALDS1
 * @Problem: ALDS1_6_D - Minimum_Cost_Sort
 * @Link: http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_6_D
 * @Timelimit: 1 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution: find minimum swap 2 number
 * @Note:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ALDS1_6_D_Minimum_Cost_Sort {

    static int n, minimum;
    static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split(" ");
        number = new int[n];
        int i = 0;
        for (String s : st) {
            number[i++] = Integer.parseInt(s);
        }
        findMinimumWay(number, 0, 1, 1);
        System.out.println(minimum);
    }

    static void findMinimumWay(int[] num, int i, int j, int counting) {
        if (counting > minimum) return;
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
        if (isSorted(num)) {
            minimum = counting;
            return;
        } else {
            if (i < n && j + 1 < n) {
                findMinimumWay(num, i, j + 1, counting + 1);
            }
            if (i + 1 < n && j < n) {
                findMinimumWay(num, i + 1, j, counting + 1);
            }
        }
    }

    static boolean isSorted(int[] number) {
        for (int i = 1; i < n; i++) {
            if (number[i - 1] > number[i]) return false;
        }
        return true;
    }

}
