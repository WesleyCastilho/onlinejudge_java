package URI.Trying.NOSTATUS.DATA_STRUCTURES_AND_LIBRARIES;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 2065 - Supermarket Line
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2065
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: find totalTime process by Priority Queue for Cashier and Client
 * @Note:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2065_Supermarket_Line {

    static int N, M;
    static int[] v, c;
    static int totalTime;

    private static class Cashiers {
        int id;
        boolean isBusy;

        public Cashiers(int id) {
            this.id = id;
        }
    }


    private static class Process {
        int endTime;
        Process nextProcess;

        public Process(int endTime) {
            this.endTime = endTime;
        }
    }

    private static class PriorityQ {
        Process firstProcess;
        int max;
        int curSize;

        public PriorityQ(int size) {
            this.curSize = 0;
            this.max = size;
        }

        boolean isFull() {
            return curSize == max;
        }

        void addProcess(Process process) {
            if (firstProcess == null) {
                firstProcess = process;
            } else {
                Process cur = firstProcess;
                while (cur.endTime < process.endTime) {
                    cur = cur.nextProcess;
                }
                if (cur == firstProcess) {
                    process.nextProcess = cur;
                    firstProcess = process;
                } else {
                    cur.nextProcess = process;
                }
            }

        }

        boolean isNotEmpty() {
            return firstProcess != null;
        }

        void process() {
            Process cur = firstProcess;
            while (cur != null) {
                cur = cur.nextProcess;
            }
            firstProcess = cur;
        }

        int pull() {
            return firstProcess.endTime;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);
        v = new int[N];
        c = new int[M];
        st = br.readLine().split(" ");
        Cashiers[] cashiers = new Cashiers[N];
        for (int i = 0; i < N; i++) {
            cashiers[i] = new Cashiers(i);
            v[i] = Integer.parseInt(st[i]);
        }


        //solve
        //Priority cashier for client
        totalTime = 0;

        PriorityQ priorityQ = new PriorityQ(N);

        st = br.readLine().split(" ");
        for (int j = 0; j < M; j++) {
            c[j] = Integer.parseInt(st[j]);
        }

        int clientQ = 0;
        while (true) {
            for (; clientQ < M; clientQ++) {
                if (!priorityQ.isFull()) {
                    int endTime = totalTime + (v[cashiers[clientQ++].id] * c[clientQ]);
                    Process process = new Process(endTime);
                    priorityQ.addProcess(process);
                }
            }
            if (!priorityQ.isNotEmpty()) break;
            totalTime = priorityQ.pull();
        }

        System.out.println(totalTime);
    }

}
