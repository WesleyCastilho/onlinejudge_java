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
package URI2.Trying.WA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class P2254_Japanese_Daisy_Game {

    public static void main(String[] args) throws IOException {
        String fileName = "P2254_input.txt";
//        String fileName = "2254_output.txt";
        File f = new File("D:\\Java Source Code\\Netbean Workspace\\URI Online Judge\\build\\classes\\Trying\\Input\\" + fileName);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            bw.append("she loves " + (n % 3 == 0 && n % 6 == 0 ? "not" : "me") + "\n");
        }
        bw.flush();
    }

}
