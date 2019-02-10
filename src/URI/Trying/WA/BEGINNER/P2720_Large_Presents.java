package URI.Trying.WA.BEGINNER;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: BEGINNER
 * @Problem: 2720 - Large Presents
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2720
 * @Timelimit: 1 sec
 * @Status: WA 5%
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */


import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class P2720_Large_Presents {

    static int n, k, id, heigth, width, length;

    static class Gift {
        int id;
        int size;

        public Gift(int id, int size) {
            this.id = id;
            this.size = size;
        }

    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        OutputStreamWriter ow = new OutputStreamWriter(System.out, "ISO-8859-1");
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            Gift[] gift = new Gift[n];
            createLoop:
            for (int i = 0; i < n; i++) {
                id = sc.nextInt();
                heigth = sc.nextInt();
                width = sc.nextInt();
                length = sc.nextInt();
                int size = heigth + width * length;
                gift[i] = new Gift(id, size);
            }


            sort(gift, 0, n - 1);
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = gift[i].id;
            }
            Arrays.sort(arr);

            boolean printed = false;
            for (int i = 0; i < k; i++) {
                if (!printed) {
                    printed = true;
                } else {
                    ow.append(" ");
                }
                ow.append(arr[i] + "");
            }
            ow.append("\n");
        }
        ow.flush();
    }

    private static void sort(Gift[] gift, int start, int end) {
        quickSort(gift, start, end);
    }

    private static int partition(Gift[] gift, int start, int end) {
        Gift pivot = gift[end];
        for (int i = start; i < end; i++) {
            if (gift[i].size > pivot.size) {
                Gift temp = gift[start];
                gift[start] = gift[i];
                gift[i] = temp;
                start++;
            }
        }
        Gift temp = gift[start];
        gift[start] = pivot;
        gift[end] = temp;
        return start;
    }


    private static void quickSort(Gift[] gift, int low, int high) {
        if (low < high) {
            int pi = partition(gift, low, high);
            quickSort(gift, low, pi - 1);
            quickSort(gift, pi + 1, high);
        }
    }


}
