package URI.Trying.NOSTATUS.STRING;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: String
 * @Problem: 2692 - Zoeiro Keyboard
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2692
 * @Timelimit: 1 sec
 * @Status: Presentation error  , WA10%
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
import java.io.*;

public class P2692_Zoeiro_Keyboard {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        char[] mapping = new char[256];
        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            char c1 = st[0].charAt(0);
            char c2 = st[1].charAt(0);
            if (mapping[c1] == '\0') {
                mapping[c1] = c2;
            }
            if (mapping[c2] == '\0') {
                mapping[c2] = c1;
            }
        }
        for (int i = 0; i < m; ) {
            String input = br.readLine();
            if (input.isEmpty()) continue;

            char[] letter = input.toCharArray();
            for (char c : letter) {
                if (mapping[c] != '\0') {
                    bw.append(mapping[c]);
                } else {
                    bw.append(c);
                }
            }
            i++;
        }
        bw.flush();
    }
}
