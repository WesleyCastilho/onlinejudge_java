package SPOJ.Trying;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: Sphere Online Judge
 * @Categories:
 * @Problem:
 * @Link:
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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CPTTRN5_Character_Patterns_Act_5 {

    public CPTTRN5_Character_Patterns_Act_5() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] st = br.readLine().split(" ");
            int i = Integer.parseInt(st[0]);
            int c = Integer.parseInt(st[1]);
            int s = Integer.parseInt(st[2]);
            //Print Top
            for (int o1 = 0; o1 < c; o1++) {
                    for (int o3 = 0; o3 < s; o3++) bw.append("*");
            }
            bw.newLine();

            for (int r1 = 0; r1 < i; r1++) {

            }

            bw.newLine();
        }
        bw.flush();
    }
}
