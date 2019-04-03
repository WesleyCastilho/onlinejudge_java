/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: AD-HOC
 * @Problem: 2927 - Unforeseen at Christmas
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2927
 * @Level:
 * @Timelimit:
 * @Status: WA100% WTF
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

package URI.Trying.WRITING.AD_HOC;

import java.util.Scanner;

public class P2927_Unforeseen_at_Christmas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();//student
        int C = sc.nextInt();//Total Computer
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int cantUse = C - (X + Y);
        System.out.println(cantUse > A ? "Igor feliz!" : cantUse == A ? "Igor bolado!" : "Caio, a culpa eh sua!");
    }

}