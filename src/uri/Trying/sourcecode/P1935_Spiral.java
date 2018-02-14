/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge:
 * @Categories:
 * @Problem:
 * @Link:
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package  uri.Trying.sourcecode;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;

public class P1935_Spiral {

    public static void main(String[] args) throws IOException {
        for (int i = 1 ; i <= 40; i++) {
            System.out.println(i);
        }
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        OutputStream out = new BufferedOutputStream(System.out);
        String[] st = br.readLine().split(" ");
        BigInteger size = new BigInteger(st[0]);
        BigInteger end = new BigInteger(st[1]);
        BigInteger row = BigInteger.ONE, colum = BigInteger.ONE;

        //-1 = less than, 0 = equal to, 1 = greater than 
        if (size.compareTo(end) >= 0) {
            colum = end;
        } else {
            //first move 
            //right
            BigInteger max = size;
            BigInteger min = BigInteger.ONE;
            colum = max;
            BigInteger move = max;
//            System.out.println("right move=" + move.toString());
            loop:
            while (true) {
                max = max.subtract(BigInteger.ONE);//max--
                min = min.add(BigInteger.ONE);//min++
                //down
                switch ((move.add(max)).compareTo(end)) {
                    case 0://equal
                        row = end;
                        break loop;
                    case 1://greater than 
                        row = row.add(end.subtract(move));
                        break loop;
                    case -1://less than
                        row = max;
                        move = move.add(max);
                        break;
                }
//                System.out.println("down move=" + move.toString());

                //left
                switch ((move.add(max)).compareTo(end)) {
                    case 0://equal
                        colum = min;
                        break loop;
                    case 1://greater than 
                        colum = colum.subtract(end.subtract(move));
                        break loop;
                    case -1://less than
                        colum = min;
                        move = move.add(max);
                        break;
                }
//                System.out.println("left move=" + move.toString());
                max = max.subtract(BigInteger.ONE); //max--
                min = min.add(BigInteger.ONE); //min++

                //up
                switch ((move.add(max)).compareTo(end)) {
                    case 0://equal
                        row = min;
                        break loop;
                    case 1://greater than 
                        row = row.subtract(end.subtract(move));
                        break loop;
                    case -1://less than
                        row = min;
                        move = move.add(max);
                        break;
                }
//                System.out.println("up move=" + move.toString());

                //right
                switch ((move.add(max)).compareTo(end)) {
                    case 0://equal
                        colum = max;
                        break loop;
                    case 1://greater than 
                        colum = colum.add(end.subtract(move));
                        break loop;
                    case -1://less than
                        colum = max;
                        move = move.add(max);
                        break;
                }
//                System.out.println("right move=" + move.toString());
//                out.write((row.toString() + " " + colum.toString() + "\n").getBytes());
//                out.flush();
            }
        }
        out.write((row.toString() + " " + colum.toString() + "\n").getBytes());
        out.flush();
    }

}
