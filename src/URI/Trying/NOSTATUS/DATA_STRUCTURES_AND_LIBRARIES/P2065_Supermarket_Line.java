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
 * @Note: แถวคอยตาม Cashier   *** ยังไม่เสร็จ ผลลัพธ์ยังไม่ถูก
 */

import MYTOOLS.DB_BufferedFileReader;

import java.io.*;
import java.util.LinkedList;

public class P2065_Supermarket_Line {

    static int N, M;
    static Integer[] v;
    static boolean[] isBusy;
    static int totalTime;

    private static class Cashiers {
        int id;

        public Cashiers(int id) {
            this.id = id;
        }
    }


    private static class Process {
        int endTime;
        Process nextProcess;
        int cashierId;

        public Process(int endTime, int cashierId) {
            this.endTime = endTime;
            this.cashierId = cashierId;
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
                Process prev = null;
                while (cur != null && cur.endTime > process.endTime) {
                    prev = cur;
                    cur = cur.nextProcess;
                }
                if (cur == firstProcess) {
                    process.nextProcess = cur;
                    firstProcess = process;
                } else {
                    prev.nextProcess = process;
                }
            }
            curSize++;

        }

        boolean isNotEmpty() {
            return firstProcess != null;
        }

        int pull() {
            if (firstProcess == null) return totalTime;

            Process p = firstProcess;
            isBusy[p.cashierId] = false;
            curSize--;
            while (p.nextProcess != null && p.endTime == p.nextProcess.endTime) {
                p = p.nextProcess;
                isBusy[p.cashierId] = false;
                curSize--;
            }
            firstProcess = p.nextProcess;
            return p.endTime;
        }


        void print() {
            Process cur = firstProcess;
            System.out.print("End Time Q>> [");
            while (cur != null) {
                System.out.print(cur.endTime + " ");
                cur = cur.nextProcess;
            }
            System.out.println("]");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new DB_BufferedFileReader("input/P2065_input.txt").build(P2065_Supermarket_Line.class);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);
        v = new Integer[N];
        st = br.readLine().split(" ");
        Cashiers[] cashiers = new Cashiers[N];
        isBusy = new boolean[N];
        for (int i = 0; i < N; i++) {
            cashiers[i] = new Cashiers(i);
            v[i] = Integer.parseInt(st[i]);
        }

        //solve
        //Priority cashier for client
        totalTime = 0;

        PriorityQ cashierQ = new PriorityQ(N);
        LinkedList<Integer> clientQ = new LinkedList<>();
        st = br.readLine().split(" ");
        for (int j = 0; j < M; j++) {
            clientQ.add(Integer.parseInt(st[j]));
        }

        while (!clientQ.isEmpty()) {
            for (Cashiers c : cashiers) {
                if (clientQ.isEmpty() || cashierQ.isFull()) break;
                if (!isBusy[c.id]) {
                    isBusy[c.id] = true;
                    int endTime = totalTime + (v[c.id] * clientQ.pollFirst());
                    Process process = new Process(endTime, c.id);
                    cashierQ.addProcess(process);
                }
            }

            totalTime = cashierQ.pull();
        }

        System.out.println(totalTime);
    }

}
