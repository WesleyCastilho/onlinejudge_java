/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: PARADIGMS
 * @Problem: 1649 - Annoying Painting Tool
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1649
 * @Level:
 * @Timelimit:
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: Greedy
 * @Note: หาวิธีวาดรูปให้ได้ตามผลลัพธ์ จำนวนน้อยที่สุด
 */

package URI.Trying.WRITING.PARADIGMS.Greedy;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1649_Annoying_Painting_Tool {

    private static int N, M, R, C;
    private static int[][] pic;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while (!(in = br.readLine()).equals("0 0 0 0")) {
            String[] st = in.split(" ");
            N = Integer.parseInt(st[0]);
            M = Integer.parseInt(st[1]);
            R = Integer.parseInt(st[2]);
            C = Integer.parseInt(st[3]);
            pic = new int[N + 1][M + 1];
            for (int i = 1; i <= N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    pic[i][j + 1] = s.charAt(j) - '0';
                }
            }

            //Greedy


        }
        bw.flush();
    }

}