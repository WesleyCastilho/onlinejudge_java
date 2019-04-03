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

import java.io.*;

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
