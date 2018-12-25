package URI.Trying.WA;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: BEGINNER
 * @Problem: 2779 - Album of the Cup
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2779
 * @Timelimit: 2 sec
 * @Status: WA 5%
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.*;
import java.util.Scanner;

public class P2779_Album_of_the_Cup {


    public static void main(String[] args) throws IOException {
        File f = new File("src/URI/Trying/NOSTATUS/BEGINNER/test.txt");
        Scanner sc = new Scanner(f);
//        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int stored = 0;
        boolean[] collection = new boolean[n];
        while (sc.hasNext()) {
            int x = sc.nextInt();
            if (x > n || x < 1) continue;
            if (!collection[x - 1]) {
                collection[x - 1] = true;
                stored++;
            }
        }
        System.out.println(n - stored);
    }

}
