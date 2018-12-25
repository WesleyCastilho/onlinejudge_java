package URI.Trying.WA;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: BEGINNER
 * @Problem:
 * @Link:
 * @Timelimit: 1 sec
 * @Status: WA 5%
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P2761_Input_and_Output_of_Various_Types {

    static int a;
    static float b;
    static char c;
    static String d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextFloat();
        c = sc.next().charAt(0);
        d = sc.nextLine().trim();

        System.out.printf("%d%.6f%c%s", a, b, c, d);
        System.out.printf("%d\t%.6f\t%c\t%s", a, b, c, d);
        System.out.printf("%10d%10.6f%10s%10s\n", a, b, c, d);
    }


}
