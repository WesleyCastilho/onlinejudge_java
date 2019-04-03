package URI.Trying.WRITING.AD_HOC;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class P1657_Automatic_Correction_of_Misspellings {

    public P1657_Automatic_Correction_of_Misspellings() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> dictionary = new TreeSet<String>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String word = br.readLine();
            dictionary.add(word);
        }
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            String word = br.readLine();
            if (dictionary.contains(word)) {
                bw.append(word + " is correct\n");
            } else {
                bw.append(word + " is a misspelling of " + "\n");
            }
        }
        bw.flush();
    }


}
