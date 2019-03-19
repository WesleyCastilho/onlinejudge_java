/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: PARADIGMS
 * @Problem: 1900 - Null Sequences
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1900
 * @Level:
 * @Timelimit:
 * @Status: RTE
 * @Submission:
 * @Runtime:
 * @Solution: brute force แบ่ง permutation ทุกเคส ไม่ซ้ำกัน โดยหาว่ามีกี่เซทที่ผลรวมเป็น 0
 * @Note:
 */

package URI.Trying.WRITING.PARADIGMS;

import java.io.IOException;
import java.util.Scanner;

public class P1900_Null_Sequences {

    static int N;
    static int[] number;
    static int nullSequences = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        number = new int[N];
        boolean isFound = false;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x <= 0) isFound = true;
            number[i] = x;
        }
        if (isFound) {
            int[] m = new int[N];
            permutation(1, m, number[0], 1);

        }
        System.out.println(nullSequences);
    }


    static void permutation(int i, int[] m, int sum, int r) {
        for (int j = i; j < N; j++) {
            if (m[j] == 0) {
                m[j] = 1;
                permutation(j + 1, m, sum + number[j], r + 1);
            }
        }
        if (sum == 0) nullSequences++;
    }

}