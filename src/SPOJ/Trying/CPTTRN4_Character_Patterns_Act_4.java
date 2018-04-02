package SPOJ.Trying;

import java.io.*;

public class CPTTRN4_Character_Patterns_Act_4 {

    /*
    You are given t - the number of test cases and for each of the
     test cases four positive integers: l - the number of lines,
      c - the number of columns in the grid; h and
       w - the high and the with of the single rectangle.
     */
    public CPTTRN4_Character_Patterns_Act_4() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            String[] st = br.readLine().split(" ");
            int i = Integer.parseInt(st[0]);
            int c = Integer.parseInt(st[1]);
            int w = Integer.parseInt(st[2]);
            int h = Integer.parseInt(st[3]);

        }
        bw.flush();
    }

}
