/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories:
 * @Problem:
 * @Link:
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI.Trying.NOSTATUS.BEGINNER;


import java.util.Scanner;

public class P2708_Tourists_in_the_Huacachina_Park {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int adventure_tourists = 0;
        int adventure_jeep = 0;
        String in;
        while (sc.hasNext()) {
            in = sc.next();
            if (in.equals("ABEND")) break;
            int tourist = Integer.parseInt(sc.next());
            if (in.equals("SALIDA")) {
                adventure_jeep++;
                adventure_tourists += tourist;
            } else {
                if (adventure_jeep > 0) {
                    adventure_jeep--;
                }
                if (adventure_tourists >= tourist) {
                    adventure_tourists -= tourist;
                }
            }

        }
        System.out.println(adventure_tourists);
        System.out.println(adventure_jeep);
    }

}
