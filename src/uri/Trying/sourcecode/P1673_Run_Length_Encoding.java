/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: DATA STRUCTURES AND LIBRARIES
 * @Problem: 1673 - Run Length Encoding
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1673
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package  uri.Trying.sourcecode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1673_Run_Length_Encoding {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);
        String input;
        while ((input = br.readLine()) != null) {
            char[] c = input.toCharArray();
            int length = c.length;
            int lastCount = 0;
            char last = c[0];
            int count = 1;
            String output = "";
            int i = 1;
            for (; i < length; i++) {
                if (last == c[i]) {
                    count++;
                } else {
                   
                    output += (count + "" + c[i - 1]);
                    
                    last = c[i];
                    lastCount = count;
                    count = 1;
                }
            }
            output += (count + "" + c[i - 1]);
            bw.append(output + "\n");
            bw.flush();
        }
        bw.flush();
    }

}
