package URI.Trying.WA.GRAPH;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: GRAPH
 * @Problem: 1082 : Connected Components
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1082
 * @Timelimit: 1 sec
 * @Status: WA 100% (WTF)
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class P1082_Connected_Components {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
        int t = 1;
        int tc = Integer.parseInt(br.readLine());
        while (t <= tc) {
            String[] st = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);
            char[] component = new char[n];
            char[] componentSet = new char[n];
            for (int i = 'a', c = 0; c < n; i++, c++) {
                component[c] = (char) i;
                componentSet[c] = (char) i;
            }

            while (m-- > 0) {
                st = br.readLine().split(" ");
                char a = st[0].charAt(0);
                char b = st[1].charAt(0);
                char oldSet = componentSet[b - 'a'];
                componentSet[b - 'a'] = componentSet[a - 'a'];
                for (int i = 0; i < n; i++) {
                    if (componentSet[i] == oldSet) {
                        componentSet[i] = componentSet[a - 'a'];
                    }
                }
            }


            Set<Character>[] set = new TreeSet[n];
            for (int i = 0; i < n; i++) {
                if (set[componentSet[i] - 'a'] != null) {
                    set[componentSet[i] - 'a'].add(component[i]);
                } else {
                    set[componentSet[i] - 'a'] = new TreeSet<Character>();
                    set[componentSet[i] - 'a'].add(component[i]);
                }

            }

            bw.append("Case #" + t + ":\n");
            int countSet = 0;
            for (Set s : set) {
                if (s == null) continue;
                countSet++;
                Iterator iter = s.iterator();
                while (iter.hasNext()) {
                    bw.append(((char) iter.next()) + ",");
                }
                bw.newLine();
            }
            bw.append(countSet + " connected components\n\n");
            t++;
            bw.flush();
        }

    }
}
