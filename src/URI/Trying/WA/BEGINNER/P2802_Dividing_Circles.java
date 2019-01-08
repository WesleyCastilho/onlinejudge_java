package URI.Trying.WA.BEGINNER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class P2802_Dividing_Circles {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //(n^2+n+2)/2
        long x = (long) (Math.pow(2, n - 1) - Math.floor((n - 1) / 5));
        System.out.println(x);
    }
}
