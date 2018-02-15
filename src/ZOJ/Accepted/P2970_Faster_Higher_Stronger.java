package accepted;

/**
 *
 * @author Teerapat Phokhonwong
 */
//ZOJ 2970 Faster, Higher, Stronger http://acm.zju.edu.cn/onlinejudge/showProblem.do?problemId=1969
//Accepted 2015-06-08 03:30:14 Run Time(ms) = 146 Run Memory(KB) = 6831
import java.util.Scanner;
public class P2970_FasterHigherStronger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int round = sc.nextInt();
        for (int i = 0; i < round; i++) {
            String check = "";
            check = sc.next();
            int answer = 0;
            int ntest = sc.nextInt();	
            if (check.equalsIgnoreCase("Faster")) {		
                for (int j = 0; j < ntest; j++) {
                    int faster = sc.nextInt();
                    if(j==0) answer = faster;
                    if(faster<=answer) answer = faster;
                }			
                System.out.println(answer);
            }else if ( check.equalsIgnoreCase("higher")||check.equalsIgnoreCase("Stronger") ) {
                for (int j = 0; j < ntest; j++) {
                    int HigherAndStronger = sc.nextInt();
                    if(j==0)answer = HigherAndStronger;
                    if(HigherAndStronger>=answer) answer = HigherAndStronger;
                }
                System.out.println(answer);
            }
        }
    }
}
