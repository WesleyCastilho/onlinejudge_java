package URI.Trying.NOSTATUS.GRAPH;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1469 - Boss
 * @Link: https://www.urionlinejudge.com.br/repository/UOJ_1469_en.html
 * @Level:
 * @Timelimit: 1 sec
 * @Status:
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

public class P1469_Boss {
    static int N, M, I;
    static Employee[] employee;
    static int[][] direct;

    private static class Employee {
        int id;
        int age;

        public Employee(int id, int age) {
            this.id = id;
            this.age = age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while ((in = br.readLine()) != null) {
            String[] st = in.split(" ");
            N = Integer.parseInt(st[0]);
            M = Integer.parseInt(st[1]);
            I = Integer.parseInt(st[2]);
            employee = new Employee[N];
            direct = new int[N][N];

            st = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                int age = Integer.parseInt(st[i]);
                employee[i] = new Employee(i, age);
            }

            for (int i = 0; i < M; i++) {
                st = br.readLine().split(" ");
                int source = Integer.parseInt(st[0]);
                int destination = Integer.parseInt(st[1]);
                direct[source][destination] = 1;
            }

            for (int i = 0; i < I; i++) {
                st = br.readLine().split(" ");
                String c = st[0];
                Integer x = Integer.parseInt(st[1]);
                if (c.equals("T")) {//two employers that must swap places

                } else if (c.equals("P")) {
                    int answer = 0;


                    // representing the number of an employer. The last instruction is of type query
                    bw.append(answer + "\n");
                }
            }
        }
        bw.flush();
    }

}
