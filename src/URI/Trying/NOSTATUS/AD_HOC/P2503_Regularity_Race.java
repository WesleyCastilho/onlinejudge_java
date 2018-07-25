package URI.Trying.NOSTATUS.AD_HOC;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 2698 - Daunting Device
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2698
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.*;

public class P2503_Regularity_Race {

    int V, P, T;

    public P2503_Regularity_Race() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        V = Integer.parseInt(st[0]);//the average velocity (km/h) to be constant at race
        P = Integer.parseInt(st[1]);//On the second line there are P integer numbers indicating each base as distance (m) from the start point
        T = Integer.parseInt(st[2]);
        //ลงโทษ 1 แต้ม ต่อ 1 วินาที ใน 20 นาทีแรก
        //ลงโทษ 2 แต้ม ต่อ 1 วินาที ต่อมา ไม่เกิน 10 นาที
        int[] limit = new int[P];
        st = br.readLine().split(" ");
        for (int i = 0; i < P; i++) {
            limit[i] = Integer.parseInt(st[i]);
        }
        int[][] team = new int[T][P];
        for (int i = 0; i < T; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < P; j++) {
                team[i][j] = Integer.parseInt(st[j]);//distance(m) from start
            }
        }

        //60 m = 10000m
        //30 = 5000m
        //1min = 166.66666666666666666666666666667 M
        //60Sec = 166.66666666666666666666666666667 M
        //1sec = 2.7777777777777777777777777777778
        //20min = 3333.3333333333333333333333333334
        //10min = 1666.6666666666666666666666666667
        //3000M = 18min



        bw.flush();
    }


}
