/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: Ad-Hoc
 * @Problem: 2684 - Help Professor Webscript!!
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2684
 * @Timelimit: 1 sec
 * @Status: WA 50%
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI.Trying.WA.ADHOC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class P2684_Help_Professor_Webscript {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<String> stack = new LinkedList<String>();
        int n = Integer.parseInt(br.readLine());
        String input;
        while (n > 0) {
            input = br.readLine();
            int type = Integer.parseInt(input.substring(0, 1));
            String html = input.substring(2, input.length());
            char[] c = html.toCharArray();
            int size = c.length;
            int count;
            switch (type) {
                case 1:
                    count = 0;
                    loop:
                    for (int i = 0; i < size; i++) {
                        switch (c[i]) {
                            case '<':
                                count++;
                                break;
                            case '>':
                                count--;
                                break;
                        }
                    }
                    bw.append(count == 0 ? "Successful !!\n" : "error\n");
                    break;
                case 0:
                    boolean successful = true;
                    loop:
                    for (int i = 0; i < size - 2; i++) {
                        if (c[i] == '>') {
                            successful = false;
                            break;
                        }
                        if (c[i] == '<') {
                            if (c[i + 1] == '/') {
                                i += 2;
                                String s = "<";
                                boolean error = true;
                                int j = i;
                                for (; j < size; j++) {
                                    if (c[j] == ' ') continue;
                                    if (c[j] == '>') {
                                        s+= ">";
                                        error = false;
                                        break;
                                    }
                                    s += c[j];
                                }
//                                System.out.println("error="+error);
//                                System.out.println("stack.isEmpty()="+stack.isEmpty());
//                                System.out.println("s="+s);
//                                System.out.println(">>> "+stack.peekLast());
                                if (!error && !stack.isEmpty() && s.equals(stack.pollLast())) {
                                    successful = true;
                                } else {
                                    successful = false;
                                    break loop;
                                }
                                i = j;
                            } else {
                                String s = "<";
                                boolean error = true;
                                int j = i + 1;
                                for (; j < size; j++) {
                                    if (c[j] == '>') {
                                        s += c[j];
                                        error = false;
                                        if (!s.equals("<meta>")) {
                                            stack.add(s);
                                        }
                                        break;
                                    }
                                    if (c[j] == ' ') {
                                        continue;
                                    }
                                    s += c[j];
                                }

                                if (error) {
                                    successful = false;
                                    break loop;
                                }
                                i = j;
                            }
                        }
                    }
                    bw.append(successful && stack.size() == 0 ? "Successful !!\n" : "error\n");
                    break;
            }
            if (--n == 0) {
                break;
            }
            stack.clear();
        }
        bw.flush();
    }

}