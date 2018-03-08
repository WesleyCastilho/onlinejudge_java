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

import java.io.*;
import java.util.*;

public class P2720_Large_Presents {

    static int n, k, i, h, w, l, m;
    static HashMap<Integer, Integer> giftList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        String[] st;
        while (t-- > 0) {
            st = br.readLine().split(" ");
            n = Integer.parseInt(st[0]);
            k = Integer.parseInt(st[1]);
            giftList = new HashMap<>();
            for (m = 0; m < n; m++) {
                st = br.readLine().split(" ");
                i = Integer.parseInt(st[0]);
                h = Integer.parseInt(st[1]);
                w = Integer.parseInt(st[2]);
                l = Integer.parseInt(st[3]);
                int size = h + w * l;
                giftList.put(size, i);
            }

            boolean printed = false;
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : entriesSortedByValues(giftList)) {
                if (!printed) {
                    printed = true;
                } else {
                    bw.append(" ");
                }
                Integer id = entry.getValue();
                bw.append(id + "");
                count++;
                if (count == k) {
                    break;
                }

            }

            bw.append("\n");
        }
        bw.flush();
    }

    static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(
                new Comparator<Map.Entry<K, V>>() {
                    @Override
                    public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        if (e1.getKey().equals(e2.getKey())) {
                            return res; // Code will now handle equality properly
                        } else {
                            return res != 0 ? res : 1; // While still adding all entries
                        }
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

}
