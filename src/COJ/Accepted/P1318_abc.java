package th.in.devboom.coj.accepted;

/**
 * Created by Teerapat-BSD on 1/29/2018.
 * link : http://coj.uci.cu/24h/problem.xhtml?pid=1318
 * Time : 2043
 * Judgment : Accepted
 * Date : 2018-01-31 00:09:20
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1318_abc {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        String pattern = br.readLine();
        int[] sorted = new int[3];
        for (int i = 0; i <= 2; i++) {
            int x = Integer.parseInt(in[i]);
            sorted[i] = x;
            for (int j = i - 1, k = i; j >= 0; j--, k--) {
                if (sorted[j] > sorted[k]) {
                    int tmp = sorted[k];
                    sorted[k] = sorted[j];
                    sorted[j] = tmp;
                }
            }
        }
        int a = sorted[0];
        int b = sorted[1];
        int c = sorted[2];
        switch (pattern.charAt(0)) {
            case 'A':
                switch (pattern.charAt(1)) {
                    case 'B':
                        //ABC
                        System.out.println(a + " " + b + " " + c);
                        break;
                    case 'C':
                        //ACB
                        System.out.println(a + " " + c + " " + b);
                        break;
                }
                break;
            case 'B':
                switch (pattern.charAt(1)) {
                    case 'A':
                        //BAC
                        System.out.println(b + " " + a + " " + c);
                        break;
                    case 'C':
                        //BCA
                        System.out.println(b + " " + c + " " + a);
                        break;
                }
                break;
            case 'C':
                switch (pattern.charAt(1)) {
                    case 'A':
                        //CAB
                        System.out.println(c + " " + a + " " + b);
                        break;
                    case 'B':
                        //CBA
                        System.out.println(c + " " + b + " " + a);
                        break;
                }
                break;
        }
    }
}
