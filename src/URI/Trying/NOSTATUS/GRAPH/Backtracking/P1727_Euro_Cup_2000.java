package URI.Trying.NOSTATUS.GRAPH.Backtracking;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1727 - Euro Cup 2000
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1727
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: Backtracking
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.HashMap;

public class P1727_Euro_Cup_2000 {

    private static HashMap<String, Team> teamTable;

    private static class Team {
        int id;
        String name;
        int score;
        int bestRank;
        int worstRank;

        public Team(int id, String name) {
            this.id = id;
            this.name = name;
            this.score = 0;
            this.bestRank = 0;
            this.worstRank = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while (!(in = br.readLine()).equals("0")) {
            int t = Integer.parseInt(in);
            Team[] team = new Team[t + 1];
            teamTable = new HashMap<>();
            for (int i = 1; i <= t; i++) {
                String teamName = br.readLine();
                team[i] = new Team(i, teamName);
                teamTable.put(teamName, team[i]);
            }

            int r = Integer.parseInt(br.readLine());
            for (int i = 0; i < r; i++) {
                String[] st = br.readLine().split(" ");
                String teamA_name = st[0];
                String teamB_name = st[1];
                Team teamA = teamTable.get(teamA_name);
                Team teamB = teamTable.get(teamB_name);
                int scoreTeamA = Integer.parseInt(st[2]);
                int scoreTeamB = Integer.parseInt(st[3]);
                if (scoreTeamA == scoreTeamB) {
                    teamA.score += 1;
                    teamB.score += 1;
                    teamTable.put(teamA_name, teamA);
                    teamTable.put(teamB_name, teamB);
                } else if (scoreTeamA > scoreTeamB) {
                    teamA.score += 3;
                    teamTable.put(teamA_name, teamA);
                } else if (scoreTeamB > scoreTeamA) {
                    teamB.score += 3;
                    teamTable.put(teamB_name, teamB);
                }
            }

            for (int i = 1; i <= t; i++) {
                bw.append("[score=" + team[i].score + "] " + team[i].name + " " + team[i].bestRank + "-" + team[i].worstRank + "\n");
            }
            bw.newLine();
            bw.flush();
        }
        bw.flush();
    }
}
