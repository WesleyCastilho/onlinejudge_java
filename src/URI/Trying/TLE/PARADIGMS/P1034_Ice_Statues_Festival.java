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
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class P1034_Ice_Statues_Festival {

    private static HashSet<Integer> memory;

    static int N, M, Minimum;
    static int[] block;

    private static class BlockSet {
        int sum;
        int r;

        public BlockSet(int sum, int r) {
            this.sum = sum;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] st = br.readLine().split(" ");
            N = Integer.parseInt(st[0]);
            M = Integer.parseInt(st[1]);
            st = br.readLine().split(" ");
            block = new int[N];
            for (int j = 0; j < N; j++) {
                block[j] = Integer.parseInt(st[j]);
            }
            memory = new HashSet<Integer>();
            Minimum = Integer.MAX_VALUE;
            for (int j = N - 1; j >= 0; j--) {
                LinkedList<BlockSet> stack = new LinkedList<BlockSet>();
                stack.add(new BlockSet(block[j], 1));
                memory.add(block[j]);

                while (!stack.isEmpty()) {
                    BlockSet blockSum = stack.poll();
                    if (blockSum.r >= Minimum) break;
                    if (blockSum.sum == M && blockSum.r < Minimum) {
                        Minimum = blockSum.r;
                        break;
                    }

                    for (int k = N - 1; k >= 0; k--) {
                        int x = blockSum.sum + block[k];
                        if (x > M) break;
                        if (!memory.contains(x)) {
                            memory.add(x);
                            stack.add(new BlockSet(x, blockSum.r + 1));
                        }
                    }
                }
            }
            System.out.println(Minimum);
        }

    }

}


