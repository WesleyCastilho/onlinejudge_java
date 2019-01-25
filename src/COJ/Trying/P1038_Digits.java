package COJ.Trying;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: COJ
 * @Categories:
 * @Problem: 1038 - Digits
 * @Link: http://coj.uci.cu/24h/problem.xhtml?pid=1038
 * @Timelimit: 1 sec
 * @Status: TLE
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note: นับจำนวน digit 1 ในเลขฐาน 2 ที่แปลงจากจำนวนเต็มหลายๆหลัก
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.math.BigInteger;

public class P1038_Digits {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new BufferedOutputStream(System.out);
        String in;
        while (!(in = br.readLine()).equals("END")) {
            String binary = new BigInteger(in).toString(2);
            System.out.println(binary);
            int size = binary.length();
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (binary.charAt(i) == '1') {
                    count++;
                }
            }
            out.write((count + "\n").getBytes());
        }
        out.flush();
    }

}
