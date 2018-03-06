package URI.Trying.TLE;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class P2720_Large_Presents_V1 {

    static int n, k, i, h, w, l, m;
    static Set<Gift> memory = new HashSet<>();

    private static Gift[] gifts;

    private static class Gift {
        int id;
        int size;

        public Gift(int id, int height, int width, int length) {
            this.id = id;
            this.size = ((height * 2) + (width * 2)) + length;
        }

    }

    private static void receive(Gift gift) {
        if (memory.contains(gift)) return;
        for (int z = 0; z < k; z++) {
            if (gifts[z] == null) {
                gifts[z] = gift;
                break;
            } else if (gifts[z].size < gift.size) {
                Gift last = gifts[z];
                gifts[z] = gift;
                for (int x = z + 1; x < k; x++) {
                    Gift tmp = gifts[x];
                    gifts[x] = last;
                    last = tmp;
                }
                if (z + 1 < k) {
                    memory.add(last);
                }
            } else if (gifts[z].size == gift.size && gifts[z].id > gift.id) {
                Gift last = gifts[z];
                gifts[z] = gift;
                for (int x = z + 1; x < k; x++) {
                    Gift tmp = gifts[x];
                    gifts[x] = last;
                    last = tmp;
                }
                if (z + 1 < k) {
                    memory.add(last);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        String[] st;
        while (t-- > 0) {
            st = br.readLine().split(" ");
            n = Integer.parseInt(st[0]);
            k = Integer.parseInt(st[1]);
            gifts = new Gift[k];
            for (m = 0; m < n; m++) {
                st = br.readLine().split(" ");
                i = Integer.parseInt(st[0]);
                h = Integer.parseInt(st[1]);
                w = Integer.parseInt(st[2]);
                l = Integer.parseInt(st[3]);
                receive(new Gift(i, h, w, l));
            }
            boolean printed = false;
            for (m = 0; m < k; m++) {
                if (!printed) {
                    printed = true;
                } else {
                    bw.append(" ");
                }
                bw.append(gifts[m].id + "");
            }

            bw.append("\n");
            memory.clear();
        }
        bw.flush();
    }

}