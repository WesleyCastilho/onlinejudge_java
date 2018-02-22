/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: Ad-Hoc
 * @Problem: 2684 - Help Professor Webscript!!
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2684
 * @Timelimit: 1 sec
 * @Status: WA 60%
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note: Regular Expression
 */
package URI.Trying.WA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2684_Help_Professor_Webscript {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String input;
        while (n-- > 0) {
            input = br.readLine();
            int type = Integer.parseInt(input.substring(0, 1));
            String html = input.substring(2, input.length());
            char[] c = html.toCharArray();
            int size = c.length;
            int tags = 0;
            if (type == 1) {
                char last = ' ';
                loop:
                for (int i = 0; i < size; i++) {
                    switch (c[i]) {
                        case '/':
                            if (last == '<' || last == '>') {
                                tags = -1;
                                break loop;
                            }
                            break;
                        case '<':
                            tags++;
                            break;
                        case '>':
                            tags--;
                            break;
                        default:
                            break;
                    }
                    last = c[i];
                }
                bw.append((tags == 0 ? "Successful!!" : "error") + "\n");
            } else {
                boolean isOpenTag = false;
                boolean isCloseTag = false;
                loop:
                for (int i = 0; i < size; i++) {
                    switch (c[i]) {
                        case '<':
                            int j = i + 1;
                            if (j < size && c[j] == '/') {
                                isCloseTag = true;
                                i = j;
                                continue loop;
                            }
                            isOpenTag = true;
                            i = j;
                            break;
                        case '>':
                            if (!isCloseTag && !isOpenTag) {
                                tags = -1;
                                break loop;
                            }
                            if (isCloseTag) {
                                tags--;
                                isCloseTag = false;
                            }
                            if (isOpenTag) {
                                tags++;
                                isOpenTag = false;
                            }
                            break;
                        default:
                            break;
                    }
                }
                bw.append((tags == 0 && !isOpenTag && !isCloseTag ? "Successful!!" : "error") + "\n");
            }
        }
        bw.flush();
    }

}
