package HACKEREARTH.Searching.Binary_Search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Bishu_and_Soldiers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split(" ");
        int[] num = new int[n];
        for (int i = 0; i < n; i++) num[i] = Integer.parseInt(st[i]);
        int Q = Integer.parseInt(br.readLine());
        while (--Q > 0) {
            int x = Integer.parseInt(br.readLine());
            int answer = 0;
            if (x > num[n - 1]) {
                for (int k = 0; k < n; k++) {
                    answer += num[k];
                }
            } else if (x < num[0]) {
                answer = 0;
            } else {

                //binary search
                int i = 0, j = n;
                int mid = (int) Math.ceil(j / 2);

                while (i < j) {
                    if (num[mid] == x) break;
                    if (num[mid] < x) {
                        i = mid;
                    } else {
                        j = mid;
                    }
                }

                for (int k = 0; k < mid; k++) {
                    answer += num[k];
                }
            }

            bw.append(answer + "\n");
        }
        bw.flush();
    }
}
