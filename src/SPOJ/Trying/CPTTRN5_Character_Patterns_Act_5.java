package SPOJ.Trying;


import java.io.*;

public class CPTTRN5_Character_Patterns_Act_5 {

    public CPTTRN5_Character_Patterns_Act_5() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] st = br.readLine().split(" ");
            int i = Integer.parseInt(st[0]);
            int c = Integer.parseInt(st[1]);
            int s = Integer.parseInt(st[1]);
            //Print Top
            for (int o1 = 0; o1 < c; o1++) {
                for (int o2 = 0; o2 < s; o2++) bw.append("*");
            }
            bw.newLine();

            for (int r1 = 0; r1 < i; r1++) {

            }

            bw.newLine();
        }
        bw.flush();
    }
}
