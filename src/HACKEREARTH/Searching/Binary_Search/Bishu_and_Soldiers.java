package HACKEREARTH.Searching.Binary_Search;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Bishu_and_Soldiers {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) num[i] = sc.nextInt();
        Arrays.sort(num);

        int Q = sc.nextInt();
        while (Q-- > 0) {
            int x = sc.nextInt();
            int answer = 0;
            int mid = 0;
            if (x > num[n - 1]) {
                mid = n - 1;
                for (int k = 0; k < n; k++) {
                    answer += num[k];
                }
            } else if (x < num[0]) {
                answer = 0;
            } else {
                int i = 0, j = n - 1;
                int oldMid = 0;
                while (i < j) {
                    mid = (int) Math.ceil((i + j) / 2.0);
                    if (oldMid == mid) break;
                    if (num[mid] == x) break;
                    if (num[mid] > x) {
                        j = mid;
                    } else if (num[mid] < x) {
                        i = mid;
                    }
                    oldMid = mid;
                }
                for (int k = mid; k >= 0; k--) {
                    answer += num[k];
                }
            }
            bw.append(num[mid] + " " + answer + "\n");
        }
        bw.flush();
    }
}
