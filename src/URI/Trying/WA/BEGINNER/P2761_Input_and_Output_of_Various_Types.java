package URI.Trying.WA.BEGINNER;

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

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class P2761_Input_and_Output_of_Various_Types {

    static int a;
    static float b;
    static char c;
    static String d;

    public static void main(String[] args) throws IOException {
        File file = new File("src/URI/Trying/WA/BEGINNER/P2761_input.txt");
        Scanner sc = new Scanner(new FileReader(file));
        DecimalFormat df = new DecimalFormat("0.000000");
        a = sc.nextInt();
        b = sc.nextFloat();
        c = sc.next().charAt(0);
        d = "";
        int i = 0;
        while (sc.hasNext()) {
            d += ((i++ > 0 ? " " : "") + sc.next());
        }
        System.out.println(a + "" + df.format(b) + "" + c + "" + d);
        System.out.printf("%-8d%-8.6f%-8s%-8s\n", a, b, c, d);
        System.out.printf("%10d%10f%10s%10s\n", a, b, c, d);
    }


}
