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
package URI.Trying.WA;

import java.io.*;

public class P2254_Japanese_Daisy_Game {

    public static void main(String[] args) throws IOException {
//        String fileName = "P2254_input.txt";
////        String fileName = "2254_output.txt";
//        File f = new File("D:\\Java Source Code\\Netbean Workspace\\URI Online Judge\\build\\classes\\Trying\\Input\\" + fileName);
//        FileReader fr = new FileReader(f);
//        BufferedReader br = new BufferedReader(fr);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            System.out.println("n="+n);
            System.out.println("n5="+n%5);
            System.out.println("n3="+n%3);
            int a = n % 5;
            int b = n % 3;
            bw.append("she loves " + ((a == 0 || b == 0) ? "not" : "me") + "\n");
            bw.flush();
        }
        bw.flush();
    }

}
