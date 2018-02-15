package th.in.devboom.coj.WA;

/**
 * Created by Teerapat-BSD on 2/5/2018.
 * WA
 * http://coj.uci.cu/24h/problem.xhtml?pid=1028
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class P1028_All_in_All {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while ((in = br.readLine()) != null) {
            if (in.isEmpty()) continue;
            String[] st = in.trim().split(" ");
            char[] s = st[0].toCharArray();
            char[] t = st[1].toCharArray();
            boolean[] marker1 = new boolean[s.length];
            boolean[] marker2 = new boolean[t.length];

            //build maker for removeLetter
            for (int i = 0; i < s.length; i++) {
                char c = s[i];
                if (!marker1[i]) {
                    for (int j = i; j < s.length; j++) {
                        if (s[j] == c) {
                            marker1[j] = true;
                        }
                    }
                    for (int j = 0; j < t.length; j++) {
                        if (t[j] == c && !marker2[j]) {
                            marker2[j] = true;
                        }
                    }
                }
            }


            String tmp = "";
            for (int i = 0; i < t.length; i++) {
                if (marker2[i]) {
                    tmp += t[i];
                }
            }
            t = tmp.toCharArray();

            boolean found = false;
            if (tmp.length() >= st[0].length()) {
                loop:
                for (int j = 0; j < t.length; j++) {
                    if (s[0] == t[j]) {
                        int i = 1;
                        for (int k = j + 1; i < s.length && k < t.length; k++, i++) {
                            if (s[i] != t[k]) {
                                break;
                            }
                        }
                        if (i == s.length) {
                            found = true;
                            break loop;
                        }
                    }
                }
            }

            bw.append(found ? "Yes\n" : "No\n");
        }
        bw.flush();
    }

}
