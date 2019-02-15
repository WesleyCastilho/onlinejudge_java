package URI.Trying.NOSTATUS.MATHEMATICS;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1219 - Colourful Flowers
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1219
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class P1219_Colourful_Flowers {

    private static int a, b, c;
    private final static double PI = 3.1415926535897;

    public static void main(String[] args) throws IOException {
        Timestamp d = new Timestamp(new Date().getTime());
        String sd = new SimpleDateFormat("dd/MM/yyyy",new Locale("th","th")).format(d);
        String st = new SimpleDateFormat("hh:mm aa", new Locale("en","en")).format(d);
        System.out.println(new SimpleDateFormat("dd/MM/yyyy",new Locale("th","th")).format(d)+" "+new SimpleDateFormat("hh:mm aa", new Locale("en","en")).format(d));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String in;
//        while ((in = br.readLine()) != null) {
//            String[] st = in.split(" ");
//            a = Integer.parseInt(st[0]);
//            b = Integer.parseInt(st[1]);
//            c = Integer.parseInt(st[2]);
//            // p = a + b + c /2
//            double p = (a + b + c) / 2.0;
//            //Area = sqr( p (p-a)(p-b)(p-c))
//            double PA = p-a;
//            double PB = p-b;
//            double PC = p-c;
//            double A = Math.sqrt(p * PA * PB * PC);
//            System.out.println("p="+p);
//            System.out.println("A="+A);
////            System.out.println(PI * Math.pow(c, 2));
//        }
//        bw.flush();
    }

}
