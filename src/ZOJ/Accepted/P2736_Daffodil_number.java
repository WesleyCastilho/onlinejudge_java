package ZOJ.Accepted;

/**
 *
 * @author Teerapat Phokhonwong
 */
//ZOJ 2736 Daffodil number http://acm.zju.edu.cn/onlinejudge/showProblem.do?problemId=1736
//Accepted 2012-07-05 20:06:26 Run Time(ms) = 90 Run Memory(KB) = 844
import java.util.Scanner;
public class P2736_Daffodil_number {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            int sum = 0;
            for (int i = 0; i < s.length(); i++){ 		
                sum += (int)(Math.pow(s.charAt(i)-'0', 3));
            }
            System.out.println(s.equals(""+sum) ? "Yes":"No");				
        }
    }   
}
