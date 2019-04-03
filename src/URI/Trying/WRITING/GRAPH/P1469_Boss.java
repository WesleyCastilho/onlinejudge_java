package URI.Trying.WRITING.GRAPH;


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
 * @Note: ***** คำตอบยังไม่ถูก
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;

public class P1469_Boss {
    static int N, M, I;
    static Employee[] employee;
//    static int[][] direct;

    private static class Employee {
        int id;
        int age;
        LinkedList<Employee> boss;
        LinkedList<Employee> downLine;

        public Employee(int id, int age) {
            this.boss = new LinkedList<>();
            this.downLine = new LinkedList<>();
            this.id = id;
            this.age = age;
        }


        void addDownline(Employee employee) {
            this.downLine.add(employee);
        }

        void addBoss(Employee employee) {
            this.boss.add(employee);
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
            employee = new Employee[N + 1];
//            direct = new int[N][N];

            st = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {
                int age = Integer.parseInt(st[i - 1]);
                employee[i] = new Employee(i, age);
            }

            for (int i = 0; i < M; i++) {
                st = br.readLine().split(" ");
                int boss = Integer.parseInt(st[0]);
                int downline = Integer.parseInt(st[1]);
                employee[boss].addDownline(employee[downline]);
                employee[downline].addBoss(employee[boss]);
            }

            for (int i = 0; i < I; i++) {
                st = br.readLine().split(" ");
                String c = st[0];

                if (c.equals("T")) {//two employers that must swap places
                    int a = Integer.parseInt(st[1]);
                    int b = Integer.parseInt(st[2]);
                    swapEmployer(employee[a], employee[b]);
                } else if (c.equals("P")) {
                    Integer x = Integer.parseInt(st[1]);
                    int youngBossAge = Integer.MAX_VALUE;
                    int[] v = new int[N + 1];
                    LinkedList<Employee> q = new LinkedList<>();
                    for (Employee boss : employee[x].boss) {
                        v[boss.id] = 1;
                        q.add(boss);
                    }
                    while (!q.isEmpty()) {
                        Employee curBoss = q.poll();
                        if (curBoss.boss != null) {
                            for (Employee boss : curBoss.boss) {
                                if (v[boss.id] == 0) {
                                    v[boss.id] = 1;
                                    q.add(boss);
                                    if (youngBossAge > boss.age) youngBossAge = boss.age;
                                }
                            }
                        }
                    }
                    // representing the number of an employer. The last instruction is of type query
                    bw.append((youngBossAge == Integer.MAX_VALUE ? "*" : youngBossAge) + "\n");
                }
            }
            bw.flush();
        }
        bw.flush();
    }


    static void swapEmployer(Employee employee1, Employee employee2) {
        Employee temp = employee1;
        employee1.age = employee2.age;
        employee1.id = employee2.id;
        employee1.downLine = employee2.downLine;
        employee1.boss = employee2.boss;
        employee2.age = temp.age;
        employee2.id = temp.id;
        employee2.downLine = temp.downLine;
        employee2.boss = temp.boss;
    }

}
