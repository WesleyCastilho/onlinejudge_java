package URI.Trying.WRITING.PARADIGMS;
/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: PARADIGMS
 * @Problem: 1395 -
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1395
 * @Level:
 * @Timelimit:
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */


import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P1395_Numbers_and_Operations {
    private static class pair {
        int a, b;

        public pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static class NumPair {
        int a, b;
        char op;
        int answer;

        public NumPair(int a, int b, char op, int answer) {
            this.a = a;
            this.b = b;
            this.op = op;
            this.answer = answer;
        }


    }


    private static class Solution {
        List<NumPair> history;
        int answer;

        public Solution() {
            history = new LinkedList<>();
        }

        void addSolution(NumPair pair) {
            history.add(pair);
        }
    }

    static Set<pair> memory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        mainLoop:
        while (!(in = br.readLine()).equals("0")) {
            String[] st = in.split(" ");
            int a = Integer.parseInt(st[0]);
            int n = Integer.parseInt(st[1]);
            memory = new HashSet<>();
            int[] number = new int[n];
            for (int i = 0; i < n; i++) {
                number[i] = Integer.parseInt(st[i + 2]);
            }


            Comparator<Solution> comparator = new Comparator<Solution>() {
                @Override
                public int compare(Solution s1, Solution s2) {
                    if (s1.answer > s2.answer) {
                        return 1;
                    } else if (s2.answer > s1.answer) {
                        return -1;
                    }
                    return 0;
                }
            };
            PriorityQueue<Solution> Q = new PriorityQueue<>(comparator);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        if (!memory.contains(new pair(number[i], number[j]))) {
                            memory.add(new pair(number[i], number[j]));
                            memory.add(new pair(number[j], number[i]));

                            Solution solution = null;

                            //addition
                            solution = new Solution();
                            solution.addSolution(new NumPair(number[i], number[j], '+', number[i] + number[j]));
                            Q.add(solution);

                            //multiplication
                            solution = new Solution();
                            solution.addSolution(new NumPair(number[i], number[j], '*', number[i] * number[j]));
                            Q.add(solution);

                            //subtraction
                            solution = new Solution();
                            solution.addSolution(new NumPair(number[i], number[j], '-', number[i] - number[j]));
                            Q.add(solution);

                            //division
                            solution = new Solution();
                            solution.addSolution(new NumPair(number[i], number[j], '/', number[i] / number[j]));
                            Q.add(solution);


                        }

                    }
                }
            }


            while (!Q.isEmpty()) {
                System.out.println("ss");
                Solution solution = Q.poll();
                int answer = solution.answer;
                if (answer == a) {
                    int i = 0;
                    for (NumPair pair : solution.history) {
                        if (i++ > 0) bw.newLine();
                        bw.append(pair.a + " " + pair.op + " " + pair.b + " = " + pair.answer);
                    }
                    bw.append(" <-\n");
                    continue mainLoop;
                }

                for (int i = 0; i < n; i++) {
                    if (!memory.contains(new pair(answer, number[i]))) {
                        memory.add(new pair(answer, number[i]));
                        memory.add(new pair(number[i], answer));

                        Solution sol = null;

                        //addition
                        sol = new Solution();
                        sol.addSolution(new NumPair(answer, number[i], '+', answer + number[i]));
                        Q.add(sol);

                        //multiplication
                        sol = new Solution();
                        sol.addSolution(new NumPair(answer, number[i], '*', answer * number[i]));
                        Q.add(sol);

                        //subtraction
                        sol = new Solution();
                        sol.addSolution(new NumPair(answer, number[i], '-', answer - number[i]));
                        Q.add(sol);

                        //division
                        sol = new Solution();
                        sol.addSolution(new NumPair(answer, number[i], '/', answer / number[i]));
                        Q.add(sol);

                    }
                }
            }


            bw.append("No solution\n");

        }
        bw.flush();
    }

}