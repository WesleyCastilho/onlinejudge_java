package AIZU.Trying.ITP1;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: AIZU ONLINE JUDGE
 * @Categories: ITP1
 * @Problem: ITP1_7_D - Matrix Multiplication
 * @Link: http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_7_D
 * @Timelimit: 1 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class ITP1_7_D_Matrix_Multiplication {
    static int m, n, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        m = Integer.parseInt(st[0]);
        n = Integer.parseInt(st[1]);
        l = Integer.parseInt(st[2]);
        int[][] A = new int[m][n];
        int[][] B = new int[n][l];
        int[][] C = new int[m][l];

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(st[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < l; j++) {
                B[i][j] = Integer.parseInt(st[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                C[i][j] = 0;
                for (int k = 0; k < l; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        for (int j = 0; j < m; j++) {
            for (int k = 0; k < l; k++) {
                bw.append(C[j][k] + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }
}
