/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: Ad-Hoc
 * @Problem: 2254 Japanese Daisy Game
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2254
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI.Trying.WA.ADHOC;

import java.io.*;
import java.util.ArrayList;

public class P2254_Japanese_Daisy_Game {

    static ArrayList<Character> list = new ArrayList<>();
    static ArrayList<Character> listTmp;

    static {
        list.add('N');
        list.add('M');
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {

            listTmp = new ArrayList<>();

            for (int j = list.size() - 1; j >= 0; j--) {
                listTmp.add(list.get(j));
//                System.out.println("ssss");
            }
            list.addAll(listTmp);
            char c = list.get(list.size() - 1) == 'N' ? 'M' : 'N';
            list.add(c);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        System.out.println("sss");
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            bw.append("she loves " + (list.get(n) == 'N' ? "not" : "me") + "\n");
            bw.flush();
        }
        bw.flush();
    }

}
