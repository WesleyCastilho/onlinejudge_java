package th.in.devboom.coj.accepted;


/**
 * Created by Teerapat-BSD on 2/2/2018.
 * Date : 2018-02-02 04:39:07
 * Judgment : Accepted
 * Time : 2251
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1188_Cow_Multiplication {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        char[] a = st[0].toCharArray();
        int aSize = st[0].length();
        char[] b = st[1].toCharArray();
        int bSize = st[1].length();
        long answer = 0;
        for (int i = 0; i < aSize; i++) {
            int n1 = '0' - a[i];
            for (int j = 0; j < bSize; j++) {
                int n2 = '0' - b[j];
                answer += (n1 * n2);
            }
        }
        System.out.println(answer);
    }
}
