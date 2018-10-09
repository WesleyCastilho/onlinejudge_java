package AIZU.Trying.ITP1;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: AIZU ONLINE JUDGE
 * @Categories: ITP1
 * @Problem: ITP1_11_A - Dice I
 * @Link: http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_11_A
 * @Timelimit: 1 sec
 * @Status: WA ???
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution: การหมุนของลูกเต๋า
 * @Note:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ITP1_11_A_Dice_I {

    static class Dice {
        int[] faceValue = new int[7];
        int topIndex;

        int current;

        public Dice(String[] face) {
            this.faceValue[1] = Integer.parseInt(face[0]);
            this.faceValue[2] = Integer.parseInt(face[1]);
            this.faceValue[3] = Integer.parseInt(face[2]);
            this.faceValue[4] = Integer.parseInt(face[3]);
            this.faceValue[5] = Integer.parseInt(face[4]);
            this.faceValue[6] = Integer.parseInt(face[5]);
            this.topIndex = 1;
            resetCurrent();
        }


        public void chagne(char direction) {
            switch (this.topIndex) {
                case 1://number 1
                    switch (direction) {
                        case 'N':
                            this.topIndex = 6;
                            break;
                        case 'S':
                            this.topIndex = 2;
                            break;
                        case 'W':
                            this.topIndex = 3;
                            break;
                        case 'E':
                            this.topIndex = 4;
                            break;
                    }
                    break;
                case 2:
                    switch (direction) {
                        case 'N':
                            this.topIndex = 6;
                            break;
                        case 'S':
                            this.topIndex = 1;
                            break;
                        case 'W':
                            this.topIndex = 4;
                            break;
                        case 'E':
                            this.topIndex = 3;
                            break;
                    }
                    break;
                case 3:
                    switch (direction) {
                        case 'N':
                            this.topIndex = 6;
                            break;
                        case 'S':
                            this.topIndex = 1;
                            break;
                        case 'W':
                            this.topIndex = 5;
                            break;
                        case 'E':
                            this.topIndex = 2;
                            break;
                    }
                    break;
                case 4:
                    switch (direction) {
                        case 'N':
                            this.topIndex = 6;
                            break;
                        case 'S':
                            this.topIndex = 1;
                            break;
                        case 'W':
                            this.topIndex = 5;
                            break;
                        case 'E':
                            this.topIndex = 2;
                            break;
                    }
                    break;
                case 5:
                    switch (direction) {
                        case 'N':
                            this.topIndex = 6;
                            break;
                        case 'S':
                            this.topIndex = 1;
                            break;
                        case 'W':
                            this.topIndex = 3;
                            break;
                        case 'E':
                            this.topIndex = 4;
                            break;
                    }
                    break;
                case 6:
                    switch (direction) {
                        case 'N':
                            this.topIndex = 2;
                            break;
                        case 'S':
                            this.topIndex = 1;
                            break;
                        case 'W':
                            this.topIndex = 4;
                            break;
                        case 'E':
                            this.topIndex = 3;
                            break;
                    }
                    break;
            }
            resetCurrent();
        }

        void resetCurrent() {
            this.current = this.faceValue[this.topIndex];
        }

    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        Dice dice = new Dice(st);
        for (char c : br.readLine().toCharArray()) {
            System.out.println(dice.current + " to " + c);
            dice.chagne(c);
        }
        System.out.println(dice.current);
    }


}
