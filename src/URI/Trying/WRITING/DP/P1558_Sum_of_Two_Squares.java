/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: AD-HOC
 * @Problem: 1558 - Sum of Two Squares
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1558
 * @Level:
 * @Timelimit:
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: DP - หา 2 ตัวเลข ที่สามารถ รวมเป็นผลลัพธ์ได้
 * @Note:
 */

package URI.Trying.WRITING.DP;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1558_Sum_of_Two_Squares {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while ((in = br.readLine()) != null) {
            int n = Integer.parseInt(in);
            int[][] m = new int[10001][10001];
            bw.append((findSumOfTwo(1, 1, n, m) == n ? "YES" : "NO") + "\n");
        }
        bw.flush();
    }


    static int findSumOfTwo(int i, int j, int n, int[][] m) {
        if (m[i][j] == n) return m[i][j];
        return m[i][j + 1] = findSumOfTwo(i, j + 1, n, m);
    }

}