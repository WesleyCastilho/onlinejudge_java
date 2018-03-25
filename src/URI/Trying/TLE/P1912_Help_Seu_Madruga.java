/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 1912 Help Seu Madruga
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1912
 * @Timelimit: 4 sec
 * @Status: TLE
 * @Submission:
 * @Runtime:
 * @Solution: sort and binary search  (this algorithm Solved by python)
 * @Note:
 */
package URI.Trying.TLE;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

class P1912_Help_Seu_Madruga {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        DecimalFormat df = new DecimalFormat("0.0000");
        while (true) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            if (n == 0 && a == 0) break;
            double sum = 0;
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                sum += data[i] = sc.nextInt();
            }

            if (sum < a) {
                bos.write("-.-\n".getBytes());
                continue;
            }
            if (sum == a) {
                bos.write(":D\n".getBytes());
                continue;
            }

            sort(data, 0, n - 1);
            double max = data[0];
            double bot = 0;
            double top = max;
            double h = 0.0;
            while (bot <= top) {
                h = (bot + top) * 0.5;
                double cut = 0.0;
                for (int k = 0; k < n; k++) {
                    if (h >= data[k]) break;
                    cut += (double) data[k] - h;
                }
                if (Math.abs(cut - (double) a) < 0.0001) {//1e-4 = 0.0001
                    break;
                } else if (cut > a) {//UP
                    bot = h;
                } else {//Down
                    top = h;
                }
            }
            bos.write((df.format(h) + "\n").getBytes());
        }
        bos.flush();
    }


    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] >= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    static void sort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

}
