package ZOJ.Trying;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: ZOJ
 * @Problem:
 * @Link:
 * @Timelimit: 2 Seconds
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note: a :  B, D, A
 * b :  A, C, E, D, F, B
 * c :  D, B, D
 * d :  F, E, C
 * e :  E, A, F
 * f :  C, F, B
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class P1009_Enigma {

    class Machine {
        public Machine() {
        }
    }

    static int step = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        char[] key = br.readLine().toCharArray();
        char[] rotor = br.readLine().toCharArray();
        char[] display = br.readLine().toCharArray();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            while (n-- > 0) {
                String input = br.readLine();
                char[] cin = input.toCharArray();
                for (char c : cin) {
                    bw.append(getDisplay(c));
                    step++;
                    step %= 5;
                }
            }

        }
        bw.flush();
    }

    static char getDisplay(char keypress) {
        switch (keypress) {
            case 'A':
                switch (step) {
                    case 0:
                        return 'B';
                    case 1:
                        return 'D';
                    case 2:
                        return 'A';
                    case 3:
                        return ' ';
                    case 4:
                        return ' ';
                    case 5:
                        return ' ';
                }
                break;
            case 'B':
                switch (step) {
                    case 0:
                        return 'A';
                    case 1:
                        return 'C';
                    case 2:
                        return 'E';
                    case 3:
                        return 'D';
                    case 4:
                        return 'F';
                    case 5:
                        return 'B';
                }
                break;
            case 'C':
                switch (step) {
                    case 0:
                        return 'D';
                    case 1:
                        return 'B';
                    case 2:
                        return 'D';
                    case 3:
                        return ' ';
                    case 4:
                        return ' ';
                    case 5:
                        return ' ';
                }
                break;
            case 'D':
                switch (step) {
                    case 0:
                        return 'F';
                    case 1:
                        return 'E';
                    case 2:
                        return 'C';
                    case 3:
                        return ' ';
                    case 4:
                        return ' ';
                    case 5:
                        return ' ';
                }
                break;
            case 'E':
                switch (step) {
                    case 0:
                        return 'E';
                    case 1:
                        return 'A';
                    case 2:
                        return 'F';
                    case 3:
                        return ' ';
                    case 4:
                        return ' ';
                    case 5:
                        return ' ';
                }
                break;
            case 'F':
                switch (step) {
                    case 0:
                        return 'C';
                    case 1:
                        return 'F';
                    case 2:
                        return 'B';
                    case 3:
                        return ' ';
                    case 4:
                        return ' ';
                    case 5:
                        return ' ';
                }
                break;
        }
        return ' ';
    }
}
