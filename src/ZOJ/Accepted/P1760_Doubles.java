package ZOJ.Accepted;

/**
 *
 * @author Teerapat Phokhonwong
 */
//ZOJ 1760 Doubles http://acm.zju.edu.cn/onlinejudge/showProblem.do?problemId=760
//Accepted 2012-07-05 21:53:43  Run Time(ms) = 40 Run Memory(KB) = 422
import java.util.ArrayList;
import java.util.Scanner;
public class P1760_Doubles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int x;
        while (true ) {
            int count = 0;
            arr.clear();
            while (true) {
                x = sc.nextInt();
                if (x==0||x==-1) {
                    break;
                }
                arr.add(x);
            }
            if (x==-1) {
                break;
            }
            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < arr.size(); j++) {
                    if (arr.get(i)==arr.get(j)*2) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
