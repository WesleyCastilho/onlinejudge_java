package SPOJ.Trying;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: Sphere Online Judge
 * @Categories: basics
 * @Problem: EMO - Emoticons
 * @Link: http://www.spoj.com/problems/EMO/
 * @Timelimit: 1 sec
 * @Status: TLE
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

class EMO_Emoticons {

    public EMO_Emoticons() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("#")) {
            input = input.trim();
            int size = input.length();
            char[] c = input.toCharArray();
            char last = ' ';
            for (int i = 0; i < size; i++) {
                if (last == ' ' && (c[i] == ':' || c[i] == '-')) {
                    String tmp = "";
                    int j = i;
                    for (; j < size; j++) {
                        if (c[j] == ' ') break;
                        tmp += c[j];
                    }

                    if (tmp.equals(":P") || tmp.equals("-_-") || tmp.equals(":/") || tmp.equals(":O")) {
                        bw.append(tmp + " ");
                    }
                    i = j;
                } else {
                    bw.append(c[i]);
                }
                last = c[i];
            }
            bw.newLine();
        }
        bw.flush();
    }
}
