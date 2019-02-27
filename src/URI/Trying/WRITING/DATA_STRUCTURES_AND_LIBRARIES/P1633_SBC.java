package URI.Trying.WRITING.DATA_STRUCTURES_AND_LIBRARIES;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: DATA STRUCTURE AND LIBRARIES
 * @Problem: 1633 - SBC
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1633
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: Priority Queue
 * @Note:
 * @Tags: Priority Queue
 */

import java.io.*;

public class P1633_SBC {

    static class PriorityQueue {
        Process firstProcess;
        Process lastProcess;

        public PriorityQueue() {
            firstProcess = null;
            lastProcess = null;
        }

        public void insertProcess(Process newProcess) {
            if (firstProcess == null) {
                firstProcess = newProcess;
                lastProcess = newProcess;
            } else if (newProcess.start > lastProcess.start) {
                lastProcess.nextProcess = newProcess;
                newProcess.prevProcess = lastProcess;
                lastProcess = newProcess;
            } else {
                Process process = firstProcess;
                while (process != null) {
                    if (process.start > newProcess.start) {
                        if (process.times > newProcess.times) {
                            Process next = process.nextProcess;
                            process.nextProcess = newProcess;
                            next.prevProcess = newProcess;

                            newProcess.prevProcess = process;
                            newProcess.nextProcess = next;
                            return;
                        }
                    }
                    process = process.nextProcess;
                }
                lastProcess.nextProcess = newProcess;
                newProcess.prevProcess = lastProcess;
                lastProcess = newProcess;
            }
        }

        public void executeProcess(Process process) {
            if (process.equals(firstProcess)) {
                firstProcess = firstProcess.nextProcess;
                if (firstProcess != null) {
                    firstProcess.prevProcess = null;
                    if (firstProcess.equals(lastProcess)) {
                        lastProcess = firstProcess;
                    }
                    return;
                }

                lastProcess = null;
            } else if (process.equals(lastProcess)) {
                lastProcess = lastProcess.prevProcess;
                if (lastProcess != null) {
                    lastProcess.nextProcess = null;
                    if (lastProcess.equals(firstProcess)) {
                        firstProcess = lastProcess;
                    }
                    return;
                }

                firstProcess = null;
            } else {
                Process prev = process.prevProcess;
                Process next = process.nextProcess;

                if (prev != null) {
                    prev.nextProcess = next;
                }
                if (next != null) {
                    next.prevProcess = prev;
                }
            }

        }

        public Process getNextProcess(int time) {
            Process process = firstProcess;
            Process nearProcess = null;
            int nearTime = Integer.MAX_VALUE;
            while (process != null) {
                int processTime = process.start;
                if (time == process.start) {
                    return process;
                }
                if (processTime < nearTime) {
                    nearTime = processTime;
                    nearProcess = process;
                }
                process = process.nextProcess;
            }
            return nearProcess;
        }

        public boolean isEmpty() {
            return this.firstProcess == null;
        }

    }

    static class Process {
        int id = 0;
        int start = 0;
        int times = 0;
        Process nextProcess = null;
        Process prevProcess = null;

        public Process(int id, int start, int times) {
            this.id = id;
            this.start = start;
            this.times = times;
        }

        int getStart() {
            return this.start;
        }

        int getTimes() {
            return this.times;
        }

        boolean equals(Process b) {
            return this.id == b.id;
        }
    }

    static PriorityQueue priorityQueue;

    public static void main(String[] args) throws IOException {

        File inputFile = new File("src/URI/Trying/WRITING/DATA_STRUCTURES_AND_LIBRARIES/input/P1633_input.txt");
        File outputFile = new File("src/URI/Trying/WRITING/DATA_STRUCTURES_AND_LIBRARIES/output/P1633_output.txt");
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);

            priorityQueue = new PriorityQueue();
            for (int i = 0; i < n; i++) {
                String[] st = br.readLine().split(" ");
                int start = Integer.parseInt(st[0]);
                int time = Integer.parseInt(st[1]);
                Process process = new Process((i + 1), start, time);//id, start, time
                priorityQueue.insertProcess(process);
            }

            int totalTimes = 0, wait = 0, time = 0;
            Process process = priorityQueue.firstProcess;
            while (!priorityQueue.isEmpty()) {
                totalTimes += wait;
                time = (process.start + process.times);
                priorityQueue.executeProcess(process);
                if(time > priorityQueue.lastProcess.times) {
                    wait = 0;
                }
                System.out.println(time);
                process = priorityQueue.getNextProcess(time);

//                process = process.nextProcess;
            }
            print();


            System.out.println(totalTimes);
            bw.append(totalTimes + "\n");
        }
        bw.flush();
    }

    static void print() {
        Process process = priorityQueue.firstProcess;
        Process prev = null;
        while (process != null) {
            System.out.println((prev != null ? "(" + prev.start + "," + prev.times + ")" : "null ") +
                    " <--(" + process.start + "," + process.times + ") -->" +
                    (process.nextProcess != null ? "(" + process.nextProcess.start + "," + process.nextProcess.times + ")" : "null "));
            prev = process;
            process = process.nextProcess;

        }
    }


}
