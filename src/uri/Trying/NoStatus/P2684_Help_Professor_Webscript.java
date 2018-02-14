/*
@Online Judge: 
@Problem No: 
@Problem Name: 
@ProblemLink: 
@Status: 
@Runtime: 
@Submission: 
 */
package uri.Trying.NOSTATUS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2684_Help_Professor_Webscript {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String input;
        while (n-- > 0) {
            input = br.readLine();
            int type = Integer.parseInt(input.substring(0, 1));
            String html = input.substring(2, input.length());
            boolean success = true;
            if(type == 1){
                
            }
            else{
                
            }
            
            bw.append((success ? "Successful !!":"error")+ "\n");
        }
        bw.flush();
    }

}
