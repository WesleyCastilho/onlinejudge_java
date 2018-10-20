package URI.Trying.WA;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories:
 * @Problem: 2749 - Output 3
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2749
 * @Timelimit: 1 sec
 * @Status: Presentation error
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
class P2749_Output_3 {

    public P2749_Output_3() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= 39; i++) bw.append("-");

        //line 2
        bw.append("\n|x = 35");
        for (int i = 8; i <= 39; i++) bw.append(" ");
        bw.append("|\n");

        //line 3
        bw.append("|");
        for (int i = 1; i <= 38; i++) bw.append(" ");
        bw.append("|\n");

        //line 4
        bw.append("|");
        for (int i = 1; i <= 17; i++) bw.append(" ");
        bw.append("x = 35");
        for (int i = 22; i < 37; i++) bw.append(" ");
        bw.append("|\n");

        //line 5
        bw.append("|");
        for (int i = 1; i <= 38; i++) bw.append(" ");
        bw.append("|\n");

        //line 6
        bw.append("|");
        for (int i = 1; i <= 32; i++) bw.append(" ");
        bw.append("x = 35|\n");


        for (int i = 1; i <= 39; i++) bw.append("-");
        bw.newLine();
        bw.flush();
    }

}
