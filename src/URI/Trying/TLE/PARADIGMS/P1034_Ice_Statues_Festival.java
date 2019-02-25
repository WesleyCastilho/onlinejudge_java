package URI.Trying.TLE.PARADIGMS;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: PARADIGMS
 * @Problem: 1034 - Ice Statues Festival
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1034
 * @Timelimit: 3 sec
 * @Status: TLE
 * @Submission:
 * @Runtime:
 * @Solution: DFS
 * @Note:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class P1034_Ice_Statues_Festival {


    private static class BlockSet {
        int sum;
        int r;

        public BlockSet(int sum, int r) {
            this.sum = sum;
            this.r = r;
        }
    }

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] st = br.readLine().split(" ");
            N = Integer.parseInt(st[0]);
            M = Integer.parseInt(st[1]);
            st = br.readLine().split(" ");
            int[] block = new int[N];
            for (int j = 0; j < N; j++) {
                block[j] = Integer.parseInt(st[j]);
            }

            int minimum = Integer.MAX_VALUE;
            TreeSet<Integer> memory = new TreeSet<Integer>();

            Comparator<BlockSet> comparator = new Comparator<BlockSet>() {

                @Override
                public int compare(BlockSet B1, BlockSet B2) {
                    if (B1.r > B2.r + 2) return 1;
                    if (B1.sum > B2.sum) return -1;
                    else if (B1.sum < B2.sum) return 1;
                    return 0;
                }
            };
            PriorityQueue<BlockSet> Q = new PriorityQueue<BlockSet>(comparator);
            for (int j = 0; j < N; j++) {
                memory.add(block[j]);
                Q.add(new BlockSet(block[j], 1));
            }
            loop:
            while (!Q.isEmpty()) {
                BlockSet now = Q.poll();
                for (int j = 0; j < N; j++) {
                    int x = now.sum + block[j];
                    if (x > M) continue;

                    int r = now.r + 1;
                    if (x == M && minimum > r) {
                        minimum = r;
                        continue;
                    }

                    if (!memory.contains(x)) {
                        memory.add(x);
                        Q.add(new BlockSet(x, r));
                    }
                }
            }
            System.out.println(minimum);
        }
    }

}
