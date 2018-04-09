package URI.Trying.NOSTATUS.DATA_STRUCTURES_AND_LIBRARIES;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: DATA STRUCTURES AND LIBRARIES
 * @Problem: 1452 - Gloud Computing
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1452
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class P1452_Gloud_Computing {

    class Application {
        Set<String> client;
        int online = 0;

        public Application() {
            client = new TreeSet<>();
        }

        public void addUser(String name) {
            client.add(name);
        }

        public boolean found(String name) {
            return client.contains(name);
        }
    }

    public P1452_Gloud_Computing() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] st = input.split(" ");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);
            Application[] app = new Application[n];
            for (int i = 0; i < n; i++) {
                app[i] = new Application();
                st = br.readLine().split(" ");
                int size = st.length;
                for (int j = 1; j < size; j++) {
                    app[i].addUser(st[j]);
                }
            }
            int total = 0;
            for (int i = 0; i < m; i++) {
                st = br.readLine().split(" ");
                int size = st.length;
                int count = 0;
                for (int j = 1; j < size; j++) {
                    int connect = 0;
                    String name = st[j];
                    for (int k = 0; k < n; k++) {
                        if (app[k].found(name)) connect++;
                    }
                    if (connect > count) count = connect;
                }
                total += count;
            }
            bw.append(total + "\n");
        }
        bw.flush();
    }
}
