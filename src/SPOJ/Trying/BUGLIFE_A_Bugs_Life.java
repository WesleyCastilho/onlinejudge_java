package SPOJ.Trying;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: Sphere Online Judge
 * @Categories: classical
 * @Problem: BUGLIFE - A Bug’s Life
 * @Link: http://www.spoj.com/problems/BUGLIFE/
 * @Timelimit: 1 sec
 * @Status: WA
 * @Memory:
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

public class BUGLIFE_A_Bugs_Life {

    public BUGLIFE_A_Bugs_Life() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int round = 1;
        while (true) {
            String[] st = br.readLine().split(" ");
//            int a = Integer.parseInt(st[0]);
            int b = Integer.parseInt(st[1]);
            Set<Integer> M = new TreeSet<Integer>();
            Set<Integer> F = new TreeSet<Integer>();
            for (int i = 0; i < b; i++) {
                st = br.readLine().split(" ");
                M.add(Integer.parseInt(st[0]));
                F.add(Integer.parseInt(st[1]));
            }
            boolean found = false;
            for (int m : M) {
                if (F.contains(m)) {
                    found = true;
                    break;
                }
            }

            bw.append("Scenario #" + (round) + ":\n");
            bw.append(found ? "Suspicious bugs found!\n" : "No suspicious bugs found!\n");
            if (--t == 0) break;
            round++;
        }
        bw.flush();
    }

}
