package th.in.devboom.coj.accepted;

/**
 * Created by Teerapat-BSD on 1/31/2018.
 * Judgment : Accepted
 * Time : 254
 * Date : 2018-01-31 00:29:28
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1003_General_Election {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            int m = Integer.parseInt(in[1]);
            int[] score = new int[n];

            for (int i = 0; i < m; i++) {
                in = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    score[j] += Integer.parseInt(in[j]);
                }
            }
            int max = 0;
            int winner = 0;
            for (int i = 0; i < n; i++) {
                if (max < score[i]) {
                    max = score[i];
                    winner = i + 1;
                }
            }
            bw.append(winner + "\n");
        }
        bw.flush();
    }
}
