package URI.Trying.WRITING.PARADIGMS;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: PARADIGMS
 * @Problem: 1432 - Triple-Free Binary Strings
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1432
 * @Level: 2
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note: โปรแกรมนี้ยังไม่เสร็จ
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;

public class P1432_Triple_Free_Binary_Strings {

    private static class BinaryPattern {
        int mode;
        LinkedList<String> binaryList;// mode 1
        String binary;//mode 2

        public BinaryPattern(int mode, String binary) {
            this.mode = mode;
            if (mode == 1) {
                binaryList = new LinkedList<String>();
                int n = binary.length();
                buildBinaryString(n);
            } else if (mode == 2) {
                this.binary = binary;
            }
        }

        void buildBinaryString(int n) {
            for (int i = 0; i <= n; i++) {
                int tmpI = i;
                String tmpS = "";
                while (tmpI > 0) {
                    tmpS = (tmpI % 2) + "" + tmpS;
                    tmpI /= 2;
                }
                System.out.println(tmpS);

                for (int j = tmpS.length() - 1; j <= n; j++) {
                    tmpS = "0" + tmpS;
                }
                binaryList.add(tmpS);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while (!(in = br.readLine()).equals("0")) {
            String[] st = in.split(" ");
            int n = Integer.parseInt(st[0]);
            String s = st[1];
            LinkedList<BinaryPattern> binaryList = new LinkedList<BinaryPattern>();
            String tmp = "";
            int mode = 0;

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '*') {
                    if (mode == 1) {
                        tmp += "*";
                    } else {
                        if (!tmp.isEmpty()) {
                            BinaryPattern binaryPattern = new BinaryPattern(2, tmp);
                            binaryList.add(binaryPattern);
                        }
                        tmp = "*";
                    }
                    mode = 1;
                } else {
                    if (mode == 2) {
                        tmp += "" + c;
                    } else {
                        if (!tmp.isEmpty()) {
                            BinaryPattern binaryPattern = new BinaryPattern(1, tmp);
                            binaryList.add(binaryPattern);
                        }
                        tmp = "" + c;
                    }
                    mode = 2;
                }
            }

//            for (BinaryPattern b : binaryList) {
//                if (b.mode == 1) {
//                    System.out.print(" ");
//                    for (String bs : b.binaryList) {
//                        System.out.println(bs);
//                    }
//                    System.out.print(" ");
//                } else if (b.mode == 2) {
//                    System.out.print(b.binary);
//                }
//            }

        }
        bw.flush();
    }

}
