package accepted;

/**
 *
 * @author Teerapat Phokhonwong
 */
//ZOJ 1292 Integer Inquiry http://acm.zju.edu.cn/onlinejudge/showProblem.do?problemId=292
//Accepted 2012-07-04 20:46:35 Run Time(ms) = 150 Run Memory(KB) = 633
import java.math.BigInteger;
import java.util.Scanner;

public class P1292_IntegerInquiry {
    
    public static void main(String [] argn){
	Scanner sc = new Scanner(System.in);
	int x = sc.nextInt();
	
	BigInteger result;
	for (int i = 0; i < x; i++) { 
            result = BigInteger.ZERO;
            while (true) {
                String x2 =  sc.next();
                if (x2.equals("0")) {			
                    break;
                }
                BigInteger big = new BigInteger(x2);
                result = result.add(big);		 			 						
            }	
            System.out.println(result);
            if (i<x-1) {
                System.out.println();
            }		
	}
    }
    
}
