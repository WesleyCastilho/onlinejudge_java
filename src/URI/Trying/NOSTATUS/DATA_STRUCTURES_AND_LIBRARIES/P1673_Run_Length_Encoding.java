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
package URI.Trying.NOSTATUS.DATA_STRUCTURES_AND_LIBRARIES;

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
            char last = c[0];
            int count = 1;
            int i = 1;
            String out = "";
            for (; i < length; i++) {
                if (last == c[i]) {
                    count++;
                } else {
                    out += getLastOutput(count, last, out);
                    count = 1;
                }
                last = c[i];
            }
            if (count > 0) {
                out += getLastOutput(count, last, out);
            }
            bw.append(out + "\n");
            bw.flush();
        }
        bw.flush();
    }

    static String getLastOutput(int count, char lastLetter, String lastOutput) {
        if (lastLetter == '1') {
            if (count == 1) {
                return (lastOutput.charAt(lastOutput.length() - 1) == 1 ? "1" : "") + lastLetter + "1";// count == 1
            }
            String outputPattern = "";
            while (count >= 9) {
                outputPattern += "9" + lastLetter;
                count -= 9;
            }
            outputPattern += count + "" + lastLetter;
            return outputPattern;
        }


        if (count > 1) {
            if (count >= 9) {
                String outputPattern = "";
                while (count >= 9) {
                    outputPattern += "9" + lastLetter;
                    count -= 9;
                }
                if (count > 0) {
                    outputPattern += count + "" + lastLetter;
                }
                return outputPattern;
            }
            return count + "" + lastLetter;
        }

        return (lastOutput.charAt(lastOutput.length() - 1) == 1 ? "1" : "") + lastLetter + "1";// count == 1
    }


}
