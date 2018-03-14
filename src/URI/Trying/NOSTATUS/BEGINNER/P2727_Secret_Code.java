package URI.Trying.NOSTATUS.BEGINNER;

import java.io.*;

/**
 * Created by teerapat on 3/13/2018.
 */
public class P2727_Secret_Code {

    public static void main(String[] args) throws IOException {
        for(int i = 0; i < 26;i++){
            System.out.println((i+1)+") "+(char)('a' + i));
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            for (; n >= 0; n--) {
                input = br.readLine();
                for (char c : input.toCharArray()) {

                }
//                bw.append(+"\n");
            }

        }
        bw.flush();
    }

}
