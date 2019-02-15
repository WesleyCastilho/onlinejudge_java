package URI.Trying.NOSTATUS.DATA_STRUCTURES_AND_LIBRARIES;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Scanner;

public class P2916_The_Note {

    static int n, k;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        OutputStream out = new BufferedOutputStream(System.out);
        while (sc.hasNext()) {
            n = sc.nextInt();
            k = sc.nextInt();
            long[] number = new long[n];
            for (int i = 0; i < n; i++)
                number[i] = sc.nextLong();

            sort(number, 0, n - 1);
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += number[i];
            }
            out.write((sum + "\n").getBytes());
        }
        out.flush();
    }

    static void sort(long[] number, int start, int end) {
        quickSort(number, start, end);
    }


    private static int partition(long[] arr, int low, int high) {
        long pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {
                i++;

                long temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        long temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }


    private static void quickSort(long[] conn, int low, int high) {
        if (low < high) {
            int pi = partition(conn, low, high);
            quickSort(conn, low, pi - 1);
            quickSort(conn, pi + 1, high);
        }
    }

}
