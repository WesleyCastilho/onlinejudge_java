package URI.Trying.TLE;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Categories: BEGINNER
 * @Problem: 2720 - Large Presents
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2720
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: Sorted List
 * @Note:
 */

import URI.Trying.NOSTATUS.STRING.P1519_Abbreviations;

import java.io.*;
import java.net.URL;
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
        URL path = P2720_Large_Presents.class.getResource("input/P2720_input.txt");
        File f = new File(path.getFile());
//        BufferedReader br = new BufferedReader(new FileReader(f));
        Scanner sc = new Scanner(f);

//        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
//        String[] st;
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            Gift[] giftArr = new Gift[n];
            int e = 0;
            boolean isfull = false;
            int max = 0, min = 0;
            createLoop:
            for (int i = 0; i < n; i++) {
                id = sc.nextInt();
                heigth = sc.nextInt();
                width = sc.nextInt();
                length = sc.nextInt();
                int size = heigth + width * length;

                if (e == 0) {
                    giftArr[0] = new Gift(id, size);
                    min = size;
                    max = size;
                    if (!isfull) {
                        if (++e == k) {
                            isfull = true;
                        }
                    }
                    continue createLoop;
                }

                if (isfull && size < min) {
                    continue createLoop;
                }

                if (size == max && id < giftArr[0].id) {
                    for (int k = e - 1; k >= 0; k--) {
                        giftArr[k + 1] = giftArr[k];
                    }
                    giftArr[0] = new Gift(id, size);
                    continue createLoop;
                } else if (size > max) {
                    for (int k = e - 1; k >= 0; k--) {
                        giftArr[k + 1] = giftArr[k];
                    }
                    giftArr[0] = new Gift(id, size);
                    max = size;
                    continue createLoop;
                }

                int j = 0;
                for (; j < e; j++) {
                    if (giftArr[j].size == size && giftArr[j].id > id) {
                        for (int k = j; k < e; k++) {
                            giftArr[k + 1] = giftArr[k];
                        }
                        giftArr[j] = new Gift(id, size);

                        if (!isfull) {
                            if (++e == k) {
                                isfull = true;
                            }
                        }
                        continue createLoop;
                    } else if (giftArr[j].size < size) {
                        for (int k = j; k < e; k++) {
                            giftArr[k + 1] = giftArr[k];
                        }
                        giftArr[j] = new Gift(id, size);
                        if (!isfull) {
                            if (++e == k) {
                                isfull = true;
                            }
                        }
                        continue createLoop;
                    }
                }
                giftArr[e] = new Gift(id, size);
                min = size;
                if (!isfull) {
                    if (++e == k) {
                        isfull = true;
                    }
                }
            }


            boolean printed = false;
            for (int i = 0; i < k; i++) {
                if (!printed) {
                    printed = true;
                } else {
                    bw.append(" ");
                }
                bw.append(giftArr[i].id + "");
            }
            bw.append("\n");
            bw.flush();
        }

    }


}
