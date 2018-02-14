package URI2.Trying.NOSTATUS;

/**
 * Created by teerapat on 1/6/2018.
 * https://www.urionlinejudge.com.br/judge/en/problems/view/2724
 */
import java.io.*;
import java.util.LinkedList;

public class P2724_Help_Patatatitu {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int compoundsAmount = Integer.parseInt(br.readLine());
            LinkedList<String> compounds = new LinkedList<String>();
            for (int i = 0; i < compoundsAmount; i++) {
                compounds.add(br.readLine());
            }

            int experimentsAmount = Integer.parseInt(br.readLine());
            while (experimentsAmount-- > 0) {
                String experiment = br.readLine();
                boolean found = false;
                for (String s : compounds) {
                    if (experiment.indexOf(s) > -1) {
                        found = true;
                        break;
                    }
                }
                bw.append(found ? "Abortar" : "Prossiga");
                bw.newLine();
            }
            bw.newLine();
            bw.flush();
        }
        bw.flush();
    }
}
