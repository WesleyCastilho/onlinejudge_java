/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1086 - The Club Ballroom
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1086
 * @Timelimit: 1 sec
 * @Status: TLE
 * @Submission:
 * @Runtime:
 * @Solution: QuickSort + Greedy algorithm
 * @Note:
 */
package URI.Trying.TLE.AD_HOC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

class P1085_The_Club_Ballroom {

    public P1085_The_Club_Ballroom() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] plank;
        boolean[] used;
        String input;
        loop:
        while (!(input = br.readLine()).equals("0 0")) {
            String[] st = input.split(" ");
            int width = Integer.parseInt(st[0]);//width
            int high = Integer.parseInt(st[1]);//high
            int plankWidth = Integer.parseInt(br.readLine());//plank width [1 - 100] cm
            int n = Integer.parseInt(br.readLine());
            input = br.readLine();
            if ((100 * high) % (plankWidth) != 0 && (100 * width) % (plankWidth) != 0) {
                bw.append("impossivel\n");
                continue loop;
            }

            st = input.split(" ");//get planks
            plank = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += plank[i] = Integer.parseInt(st[i]);
            }
            quickSort(plank, 0, n - 1);

            //Find By Height
            int size = (width * 100) / plankWidth;
            used = new boolean[n];
            int picked = 0;
            int line = 0;
            Set<Integer> failedHistory = new TreeSet<Integer>();
            for (int i = 0; i < n; i++) {
                if (!failedHistory.contains(plank[i])) {
                    boolean ok = false;
                    sum = 0;
                    int k = 0;
                    int[] pick = new int[n];
                    for (int j = i; j < n; j++) {
                        if (!used[j]) {
                            int tmp = (plank[j] + sum);
                            if (tmp == high) {
                                pick[k] = j;
                                k++;
                                ok = true;
                                break;
                            }
                            if (tmp < high) {
                                sum += plank[j];
                                pick[k] = j;
                                k++;
                            }
                        }
                    }
                    if (ok) {
                        ++line;
                        picked += k;
                        if (line == size) {
                            bw.append(picked + "\n");
                            continue loop;
                        }
                        for (int p = 0; p < k; p++) {
                            used[pick[p]] = true;
                        }
                    } else {
                        failedHistory.add(plank[i]);
                    }
                }
            }


            //Find By Width
            failedHistory.clear();
            used = new boolean[n];
            picked = 0;
            line = 0;
            size = (high * 100) / plankWidth;
            for (int i = 0; i < n; i++) {
                if (!failedHistory.contains(plank[i])) {
                    boolean ok = false;
                    sum = 0;
                    int k = 0;
                    int[] pick = new int[n];
                    for (int j = i; j < n; j++) {
                        if (!used[j]) {
                            int tmp = (plank[j] + sum);
                            if (tmp == width) {
                                pick[k] = j;
                                k++;
                                ok = true;
                                break;
                            }
                            if (tmp < width) {
                                sum += plank[j];
                                pick[k] = j;
                                k++;
                            }
                        }
                    }
                    if (ok) {
                        ++line;
                        picked += k;
                        if (line == size) {
                            bw.append(picked + "\n");
                            continue loop;
                        }
                        for (int p = 0; p < k; p++) {
                            used[pick[p]] = true;
                        }
                    } else {
                        failedHistory.add(plank[i]);
                    }
                }
            }

            bw.append("impossivel" + "\n");
        }

        bw.flush();
    }

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] >= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }


    void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

}
