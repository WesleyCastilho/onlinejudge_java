package CODINGAME.Trying;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: Code in Game
 * @Categories:
 * @Problem:
 * @Link:
 * @Level:
 * @Timelimit: 2 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: Divide and conquer algorithm
 * @Note:
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class The_Descent {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // game loop
        while (true) {
            int max = 0;
            int maxIndex = 0;
            for (int i = 0; i < 8; i++) {
                int mountainH = Integer.parseInt(br.readLine()); // represents the height of one mountain, from 9 to 0. Mountain heights are provided from left to right.
                if (mountainH > max) {
                    max = mountainH;
                    maxIndex = i;
                }
            }

            System.out.println(maxIndex);
        }
    }

}
