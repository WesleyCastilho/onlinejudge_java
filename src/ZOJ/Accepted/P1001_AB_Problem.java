package accepted;

/**
 *
 * @author Teerapat Phokhonwong
 */
//ZOJ 1001 A + B Problem http://acm.zju.edu.cn/onlinejudge/showProblem.do?problemId=1
//2013-03-16 18:43:13 	Accepted  Run Time(ms) = 0 Run Memory(KB) = 211
import java.util.Scanner;
public class P1001_A_plus_B_Problem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a+b);
		}
	}

}
