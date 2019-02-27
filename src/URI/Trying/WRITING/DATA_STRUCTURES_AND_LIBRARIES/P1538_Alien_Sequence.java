package URI.Trying.WRITING.DATA_STRUCTURES_AND_LIBRARIES;

import java.io.*;
import java.util.HashMap;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: DATA STRUCTURE AND LIBRARIES
 * @Problem: 1538 - Alien Sequence
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1538
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: หา วิธีแปลง binary ไปเป็น alien sequence
 * @Note:
 */
public class P1538_Alien_Sequence {

    BufferedReader br;
    BufferedWriter bw;
    HashMap<Integer, String> memory = new HashMap<Integer, String>();

    public P1538_Alien_Sequence() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            if (input.equals("0")) break;


            int i = Integer.parseInt(input);
            String answer = memory.get(i);
            if (answer != null) {
                bw.append(answer + "\n");
            } else {
                String s = Integer.toBinaryString(i);
                for (int j = 0; j < s.length(); j++) {

                }
                answer = s;

                bw.append(answer + "\n");
                memory.put(i, answer);
            }
//            String s = String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0');
        }
        bw.flush();
    }
}
