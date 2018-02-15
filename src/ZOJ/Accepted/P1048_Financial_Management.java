package ZOJ.Accepted;

/**
 *
 * @author Teerapat Phokhonwong
 */
//ZOJ 1048 Financial Management http://acm.zju.edu.cn/onlinejudge/showProblem.do?problemId=48
//Accepted 2013-07-22 19:32:31 Run Time(ms) = 30 Run Memory(KB) = 422

import java.text.DecimalFormat;
import java.util.Scanner;
public class P1048_Financial_Management {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.##");
	double sum = 0;
	int count = 0;
	for (int i = 0; i < 12 ; i++) {	
            double m = sc.nextDouble();
            sum +=m;
	}
	System.out.println("$"+df.format(sum/12));
    }
}
