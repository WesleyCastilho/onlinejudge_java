package AIZU.Trying.ITP1;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: AIZU ONLINE JUDGE
 * @Categories: ITP1
 * @Problem: ITP1_9_D - Transformation
 * @Link: judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_9_D
 * @Timelimit: 1 sec
 * @Status: Accepted
 * @Memory: 24512 KB
 * @Submission: 2018-10-08 15:59
 * @Runtime: 00:04 s
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class ITP1_9_D_Transformation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] text = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            int s = Integer.parseInt(command[1]);
            int e = Integer.parseInt(command[2]);
            switch (command[0]) {
                case "replace":
                    char[] rArr = command[3].toCharArray();
                    for (int j = s, c = 0; j <= e; j++, c++) {
                        text[j] = rArr[c];
                    }
                    break;
                case "reverse":
                    String tmp = new String(text).substring(s, e + 1);
                    for (int j = s, c = (e - s); j <= e; j++, c--) {
                        text[j] = tmp.charAt(c);
                    }
                    break;
                case "print":
                    tmp = new String(text).substring(s, e + 1);
                    bw.append(tmp + "\n");
                    break;
            }
        }
        bw.flush();
    }
}
