package URI.Accepted.AcceptedByAnotherLanguage.BEGINNER;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: BEGINNER
 * @Problem: 2758 - Floating Number Input and Output
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2758
 * @Timelimit: 1 sec
 * @Status: WA 5%
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note: this problem Accepted by c++
 */

import java.util.Locale;
import java.util.Scanner;

public class P2758_Floating_Number_Input_and_Output {

    static float a, b;
    static double c, d;

    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        Scanner sc = new Scanner(System.in);
        a = sc.nextFloat();
        b = sc.nextFloat();
        c = sc.nextDouble();
        d = sc.nextDouble();
        System.out.printf("A = %f, B = %f\n", a, b);
        System.out.printf("C = %f, D = %f\n", c, d);
        System.out.printf("A = %.1f, B = %.1f\n", a, b);
        System.out.printf("C = %.1f, D = %.1f\n", c, d);
        System.out.printf("A = %.2f, B = %.2f\n", a, b);
        System.out.printf("C = %.2f, D = %.2f\n", c, d);
        System.out.printf("A = %.3f, B = %.3f\n", a, b);
        System.out.printf("C = %.3f, D = %.3f\n", c, d);
        System.out.printf("A = %.3E, B = %.3E\n", a, b);
        System.out.printf("C = %.3E, D = %.3E\n", c, d);
        System.out.printf("A = %.0f, B = %.0f\n", a, b);
        System.out.printf("C = %.0f, D = %.0f\n", c, d);
    }


}
