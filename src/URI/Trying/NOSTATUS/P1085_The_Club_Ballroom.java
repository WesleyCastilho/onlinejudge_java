/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1086 - The Club Ballroom
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1086
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: shellSort + Greedy algorithm
 * @Note:
 */
package URI.Trying.NOSTATUS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class P1085_The_Club_Ballroom {

    static int[] plankWidth, plankHigth;
    static LinkedList<Integer> pickedW, pickedH; 
    static int n, m, l, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] st = input.split(" ");
            n = Integer.parseInt(st[0]);//width
            m = Integer.parseInt(st[1]);//higth
            l = Integer.parseInt(br.readLine());//1 - 100 cm 
            k = Integer.parseInt(br.readLine());
            st = br.readLine().split(" ");//planks
            int answer = 0;
            int width = l * Math.min(n, m);
            if ((l * k) >= width) {
                int c1 = 0;
                int c2 = 0;
                plankWidth = new int[k];
                plankHigth = new int[k];
                for (int i = 0; i < k; i++) {
                    int plank = Integer.parseInt(st[i]);
                    if (plank <= n) {
                        plankWidth[c1++] = plank;
                    }
                    if (plank <= m) {
                        plankHigth[c2++] = plank;
                    }
                }
                shellSort(plankWidth);
                shellSort(plankHigth);
                for (int i = 0; i < c1; i++) {
                    System.out.print(plankWidth[i] + " ");
                }
                System.out.println("");
                //width
                int usedA = 0, usedB = 0;
                for (int i = 0; i < c1; i++) {

                }
                //higth
                for (int i = 0; i < c2; i++) {

                }
                answer = usedA < usedB ? usedA : usedB;
            }
            bw.append((answer > 0 ? answer : "impossivel") + "\n");
        }
        bw.flush();
    }

    //Performs a shell sort on an array of ints.
    static void shellSort(int[] array) {
        int h = 1;
        while (h < array.length) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            h = h / 3;
            for (int k = 0; k < h; k++) {
                for (int i = h + k; i < array.length; i += h) {
                    int key = array[i];
                    int j = i - h;
                    while (j >= 0 && array[j] < key) {
                        array[j + h] = array[j];
                        j -= h;
                    }
                    array[j + h] = key;
                }
            }
        }
    }

}
