package URI.Trying.NOSTATUS.STRING;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: STRING
 * @Problem: 2587 - Jetiqui
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2587
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.*;
import java.util.LinkedList;

public class P2587_Jetiqui {
    public static void main(String[] a) throws IOException {
        File file_in = new File("src/URI/Trying/NOSTATUS/STRING/input.txt");
        File file_out = new File("src/URI/Trying/NOSTATUS/STRING/output.txt");
        BufferedReader br = new BufferedReader(new FileReader(file_in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file_out));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            char[] c1 = br.readLine().toCharArray();
            char[] c2 = br.readLine().toCharArray();
            char[] c3 = br.readLine().toCharArray();
            int size = c1.length;
            boolean chk = true;
            loop:
            for (int i = 0; i < size; i++) {
                if (c3[i] == '_') {
                    if (c1[i] == c2[i]) {
                        chk = false;
                        break loop;
                    }
                } else {
                    if(c1[i] != c3[i] && c3[i] != c2[i]){
                        chk = false;
                        break loop;
                    }
                }
            }
            bw.append(chk ? "Y\n" : "N\n");

        }

        bw.flush();

    }


}

