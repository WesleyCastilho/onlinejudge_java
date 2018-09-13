package URI.Trying.NOSTATUS.AD_HOC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class P2693_Van {

    public P2693_Van() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, TreeSet<String>> map = new HashMap<>();
        String input;
        br.readLine();
        while ((input = br.readLine()) != null) {
            String[] st = input.split(" ");
            int x = Integer.parseInt(st[2]);
            TreeSet<String> set = map.get(x);
            if (set == null) {
                set = new TreeSet<>();
            }
            set.add(st[0]);
            map.put(x, set);
        }
        for (Map.Entry<Integer, TreeSet<String>> entry : map.entrySet()) {
            for (String s : entry.getValue()) {
                bw.append(s + " \n");
            }
        }
        bw.flush();
    }
}
