/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: DATASTRUCTURE
 * @Problem: 1527 - Guilds
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1527
 * @Level:
 * @Timelimit: 2 sec
 * @Status: 20% WA
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */

package URI.Trying.WA.DATASTRUCTURE;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1527_Guilds {

    private static int N, M;
    private static int[] playerPoint;
    private static int[] guild;
    private static int[] guildSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while (!(in = br.readLine()).equals("0 0")) {
            String[] st = in.split(" ");
            N = Integer.parseInt(st[0]);
            M = Integer.parseInt(st[1]);
            playerPoint = new int[N + 1];
            guild = new int[N + 1];
            guildSize = new int[N + 1];
            st = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {
                playerPoint[i] = Integer.parseInt(st[i - 1]);
                guild[i] = i;
                guildSize[i] = 1;
            }
            int totalWar = 0;
            for (int i = 0; i < M; i++) {
                st = br.readLine().split(" ");
                int a = Integer.parseInt(st[1]);
                int b = Integer.parseInt(st[2]);
                int groupA = findGroup(a);
                int groupB = findGroup(b);
                switch (st[0]) {
                    case "1":
                        if (groupA != groupB) {
                            unionGroup(groupA, groupB);
                        }
                        break;
                    case "2":
                        if (groupA != groupB && playerPoint[groupA] > playerPoint[groupB]) {
                            totalWar++;
                        }
                        break;
                }
            }
            bw.append(totalWar + "\n");
        }
        bw.flush();
    }


    static void unionGroup(int guildA, int guildB) {
        if (guildSize[guildA] > guildSize[guildB]) {
            guild[guildB] = guildA;
            playerPoint[guildA] += playerPoint[guildB];
        } else if (guildSize[guildB] > guildSize[guildA]) {
            guild[guildA] = guildB;
            playerPoint[guildB] += playerPoint[guildA];
        } else {
            guild[guildB] = guildA;
            guildSize[guildA]++;
        }
    }

    static int findGroup(int g) {
        if (guild[g] == g) return g;
        return findGroup(guild[g]);
    }

}