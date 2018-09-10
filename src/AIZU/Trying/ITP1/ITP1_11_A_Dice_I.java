package AIZU.Trying.ITP1;

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
        int[] faceValue = new int[6];
        int topIndex;

        int current;
        int top;
        int left;
        int right;
        int bottom;

        public Dice(String[] face) {
            this.faceValue[1] = Integer.parseInt(face[0]);
            this.faceValue[2] = Integer.parseInt(face[1]);
            this.faceValue[3] = Integer.parseInt(face[2]);
            this.faceValue[4] = Integer.parseInt(face[3]);
            this.faceValue[5] = Integer.parseInt(face[4]);
            this.faceValue[6] = Integer.parseInt(face[5]);
            this.topIndex = 1;
            this.current = this.faceValue[this.topIndex];
        }


        public void chagne(char direction) {
            switch (direction) {
                case 'N':
                    switch (this.topIndex) {
                        case 1://number 1
                            this.topIndex = 2;
                            this.current = this.faceValue[2];
                            break;
                        case 2:
                            this.topIndex = 2;
                            this.current = this.faceValue[2];
                            break;
                        case 3:
                            this.topIndex = 6;
                            this.current = this.faceValue[6];
                            break;
                        case 4:
                            this.topIndex = 2;
                            this.current = this.faceValue[2];
                            break;
                        case 5:

                            break;
                        case 6:
                            this.topIndex = 1;
                            this.current = this.faceValue[1];
                            break;
                    }
                    break;
                case 'S':
                    break;
                case 'W':
                    break;
                case 'E':
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
            dice.chagne(c);
        }
        bw.append(dice.current + "\n");
        bw.flush();
    }


}
