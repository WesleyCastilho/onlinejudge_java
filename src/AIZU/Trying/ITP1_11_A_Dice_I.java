package AIZU.Trying;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: AIZU ONLINE JUDGE
 * @Categories:
 * @Problem:
 * @Link:
 * @Timelimit: 1 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.*;

public class ITP1_11_A_Dice_I {

    static class Dice {
        int[] face = new int[7];
        int top;
        int topValue;

        public Dice(String[] face) {
            this.face[1] = Integer.parseInt(face[0]);
            this.face[2] = Integer.parseInt(face[1]);
            this.face[3] = Integer.parseInt(face[2]);
            this.face[4] = Integer.parseInt(face[3]);
            this.face[5] = Integer.parseInt(face[4]);
            this.face[6] = Integer.parseInt(face[5]);
            this.top = 1;
            this.topValue = this.face[top];
        }

        public void W() {
            switch (top) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        }


        public void E() {
            switch (top) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        }

        public void N() {
            switch (top) {
                case 1:
                    top = 2;
                    topValue = face[top];
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        }

        public void S() {
            switch (top) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        Dice dice = new Dice(st);
        for (char c : br.readLine().toCharArray()) {
            switch (c) {
                case 'N':
                    dice.N();
                    break;
                case 'S':
                    dice.S();
                    break;
                case 'W':
                    dice.W();
                    break;
                case 'E':
                    dice.E();
                    break;
            }
        }
        bw.append(dice.topValue + "\n");
        bw.flush();
    }


}
