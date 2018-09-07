package URI.Trying.NOSTATUS.STRING;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: STRING
 * @Problem: 1519 - Abbreviations
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1519
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.*;
import java.net.URL;

public class P1519_Abbreviations {

    public P1519_Abbreviations() throws IOException {
        URL path = P1519_Abbreviations.class.getResource("input/P1519_input.txt");
        File f = new File(path.getFile());
        BufferedReader br = new BufferedReader(new FileReader(f));

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        String[] composed;
        String text = "";
        while ((input = br.readLine()) != null) {
            text += input;
        }

        //find answer


        bw.flush();
    }
}
