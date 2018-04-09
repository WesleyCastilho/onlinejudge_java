package CODECHEF.Accepted;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: CODECHEF
 * @Categories: Practice(Beginner)
 * @Problem: TSORT : Turbo Sort
 * @Link: https://www.codechef.com/problems/TSORT
 * @Timelimit: 3.0475 secs
 * @Status: AC
 * @Memory: 4468M
 * @Submission: 2018-04-09 15:57:32
 * @Runtime: 0.39
 * @Solution: counting Sort
 * @Note:
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TSORT_Turbo_Sort {

    public TSORT_Turbo_Sort() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        int i = 0;
        while (i < n) {
            int now = Integer.parseInt(br.readLine());
            data[i++] = now;
        }
        int max = 0;
        for (i = 0; i < n; i++) {
            if (max < data[i]) max = data[i];
        }
        data = countingSort(data, max);
        i = 0;
        while (i < n) {
            bos.write((data[i++] + "\n").getBytes());
        }
        bos.flush();
    }

    public int[] countingSort(int[] theArray, int maxValue) {

        int numCounts[] = new int[maxValue + 1];

        for (int num : theArray) {
            numCounts[num]++;
        }

        int[] sortedArray = new int[theArray.length];
        int currentSortedIndex = 0;

        for (int num = 0; num < numCounts.length; num++) {
            int count = numCounts[num];

            for (int i = 0; i < count; i++) {

                sortedArray[currentSortedIndex] = num;
                currentSortedIndex++;
            }
        }

        return sortedArray;
    }


}
