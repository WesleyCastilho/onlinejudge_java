package th.in.devboom.coj.accepted;


/**
 * Created by Teerapat-BSD on 2/2/2018.
 * Date : 2018-02-04 23:48:24
 * Judgment : Accepted
 * Time : 2964
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P1051_Div3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        System.out.println(find(x));
    }

    static int find(int n) {
        int count = 0;
        boolean chk = false;
        for (int i = 1; i <= n; i++) {
            if (chk) {
                count++;
                if (count % 2 == 0) {
                    chk = false;
                }
            } else {
                chk = true;
            }
        }
        return count;
    }
}
