package th.in.devboom.coj.accepted;


/**
 * Created by Teerapat-BSD on 2/2/2018.
 * Date : 2018-02-02 03:20:27
 * Judgment : Accepted
 * Time : 184
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1059_Numeric_Parity {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("0")) {
            int x = Integer.parseInt(input);
            String binary = Integer.toBinaryString(x);
            int count = 0;
            for (char c : binary.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            bw.append("The parity of " + binary + " is " + count + " (mod 2).\n");
        }
        bw.flush();
    }
}
