package URI.Trying.WRITING.BEGINNER;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories:
 * @Problem: 2648 - Tarot Sham Boast
 * @Link: https://www.urionlinejudge.com.br/repository/UOJ_2648_en.html
 * @Timelimit: 2 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution: order pattern
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class P2648_Tarot_Sham_Boast {
    static int n, s;

    static class Pattern implements Comparable {
        int patternId;
        String data;

        public Pattern(String data, int patternId) {
            this.data = data;
            this.patternId = patternId;
        }

        @Override
        public int compareTo(Object o) {
            Pattern p = (Pattern) o;
            if (p.data.compareTo(this.data) < 0) {
                return 1;
            } else if (p.data.compareTo(this.data) > 0) {
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        s = Integer.parseInt(st[1]);
        String[] p = new String[s];
        Pattern[] pattern = new Pattern[s];
        for (int i = 0; i < s; i++) {
            p[i] = br.readLine();
            String tmp = "";
            int size = p[i].length();
            for (int j = 0; j < size; j++) {
                switch (p[i].charAt(j)) {
                    case 'P':
                        if (j + 1 < size && p[i].charAt(j + 1) == 'P') {
                            tmp += "4";
                            j++;
                        } else {
                            tmp += "1";
                        }

                        break;
                    case 'S':
                        if (j + 1 < size && p[i].charAt(j + 1) == 'S') {
                            tmp += "6";
                            j++;
                        } else {
                            tmp += "2";
                        }
                        break;
                    case 'R':
                        if (j + 1 < size && p[i].charAt(j + 1) == 'R') {
                            tmp += "5";
                            j++;
                        } else {
                            tmp += "3";
                        }
                        break;
                }
            }
            for (int j = size - 1; j < n; j++) {
                tmp += "0";
            }
            pattern[i] = new Pattern(tmp, i);
        }
        Arrays.sort(pattern);
        for (int i = 0; i < s; i++) {
            bw.append(p[pattern[i].patternId] + "\n");
        }
        bw.flush();
    }

}
