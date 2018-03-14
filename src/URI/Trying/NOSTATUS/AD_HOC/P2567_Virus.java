package URI.Trying.NOSTATUS.AD_HOC;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem:
 * @Link:
 * @Timelimit:
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: หาทางจับคู่ลบกัน แล้วเหลือคำตอบที่มากที่สุด
 * @Note:
 */

import java.io.*;

public class P2567_Virus {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            n = Integer.parseInt(input);
            String[] st = br.readLine().split(" ");
            int[] virus = new int[n];
            for (int i = 0; i < n; i++) {
                virus[i] = Integer.parseInt(st[i]);
            }
            long max = 0;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = i - 1; j >= 0; j--) {
                    sum += (virus[i] - virus[j]);
                }
                for (int j = i + 1; j < n; j++) {
                    sum += (virus[i] - virus[j]);
                }
                if (max < sum) {
                    max = sum;
                }
            }
            bw.append(max + "\n");
        }
        bw.flush();
    }


}
