package th.in.devboom.coj.accepted;



/**
 * Created by Teerapat-BSD on 1/29/2018.
 * Judgment : Accepted
 * Time : 1759
 * Date : 2018-01-29 04:30:32
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class P1293_Powers_of_Two {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal bd = new BigDecimal("2");
        bd = bd.pow(Integer.parseInt(br.readLine()));
        System.out.println(bd);
    }
}
