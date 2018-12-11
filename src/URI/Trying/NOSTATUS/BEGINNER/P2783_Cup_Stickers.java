package URI.Trying.NOSTATUS.BEGINNER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P2783_Cup_Stickers {

    static int n, c, m;
    static boolean card[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        c = Integer.parseInt(st[1]);
        m = Integer.parseInt(st[2]);
        st = br.readLine().split(" ");
        card = new boolean[n + 1];
        int answer = n - c;
        for (int i = 0; i < c; i++) {
            int x = Integer.parseInt(st[i]);
            card[x] = true;
        }
        st = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st[i]);
            if (x >0 && x <= n && !card[x]) {
                answer--;
                card[x] = true;
            }
        }
        System.out.println(answer);
    }
}
