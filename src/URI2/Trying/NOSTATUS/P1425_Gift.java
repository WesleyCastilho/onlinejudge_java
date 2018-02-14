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
package URI2.Trying.NOSTATUS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class P1425_Gift {

    static int n, m;
    static boolean visited[];
    static Deque<Integer> queue;

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] in = input.split(" ");
            n = Integer.parseInt(in[0]);
            m = Integer.parseInt(in[1]);
            if (m == 1) {
                bw.append("Let me try!\n");
                continue;
            }
            visited = new boolean[n];
            queue = new LinkedList<Integer>();
            boolean possible = false;
            visited[0] = true;
            queue.add(1);
            while (!queue.isEmpty()) {
                int now = queue.pollFirst();
                int forward = (2 * (now + 1)) - 1;
                System.out.println("forward="+forward);
                if (forward == m) {
                    possible = true;
                    break;
                } else if (forward < n && !visited[forward]) {
                    add(forward);
                }
                int backward = now - ((now - 1) - 1);
                System.out.println("backward="+backward);
                if (backward == m) {
                    possible = true;
                    break;
                } else if (backward > 0 && !visited[backward]) {
                    add(backward);
                }
            }
            bw.append(possible ? "Let me try!\n" : "Don't make fun of me!\n");
        }
        bw.flush();
    }

    static void add(int ith) {
        visited[ith] = true;
        queue.add(ith);
    }

}
