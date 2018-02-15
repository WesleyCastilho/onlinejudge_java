package th.in.devboom.uri.WA;


/**
 * Created by Teerapat-BSD on 2/7/2018.
 * https://www.urionlinejudge.com.br/judge/en/problems/view/2632
 * WA 10%
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class P2632_Magic_and_Sword {

    static final int[] FIRE_RADIUS = new int[]{20, 30, 50};
    static final int[] WATER_RADIUS = new int[]{10, 25, 40};
    static final int[] EARTH_RADIUS = new int[]{25, 55, 70};
    static final int[] AIR_RADIUS = new int[]{18, 38, 60};
    static int FIRE_DAMAGE = 200;
    static int WATER_DAMAGE = 300;
    static int EARTH_DAMAGE = 400;
    static int AIR_DAMAGE = 100;
    static int W, H, X0, Y0;
    static int CX, CY;

    static class Point {
        int X, Y;

        public Point(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }

        int getX() {
            return this.X;
        }

        int getY() {
            return this.Y;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point p = (Point) obj;
                return (getX() == p.getX()) && (getY() == p.getY());
            }
            return super.equals(obj);
        }

    }

    static double distance(Point p1, Point p2) {
        double px = p2.getX() - p1.getX();
        double py = p2.getY() - p1.getY();
        return Math.sqrt(px * px + py * py);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] in = br.readLine().split(" ");
            W = Integer.parseInt(in[0]);
            H = Integer.parseInt(in[1]);
            X0 = Integer.parseInt(in[2]);
            Y0 = Integer.parseInt(in[3]);

            in = br.readLine().split(" ");
            String element = in[0];
            int level = Integer.parseInt(in[1]);
            int elementDamange = 0;
            int elementRidius = 0;
            if (element.equals("fire")) {
                elementDamange = FIRE_DAMAGE;
                elementRidius = FIRE_RADIUS[level - 1];
            } else if (element.equals("water")) {
                elementDamange = WATER_DAMAGE;
                elementRidius = WATER_RADIUS[level - 1];
            } else if (element.equals("earth")) {
                elementDamange = EARTH_DAMAGE;
                elementRidius = EARTH_RADIUS[level - 1];
            } else if (element.equals("air")) {
                elementDamange = AIR_DAMAGE;
                elementRidius = AIR_RADIUS[level - 1];
            }

            CX = Integer.parseInt(in[2]);
            CY = Integer.parseInt(in[3]);
            boolean canDo = false;
            Point p1 = new Point(X0, Y0);
            Point p2 = new Point(CX, CY);

            int d = (int) distance(p1, p2) - elementRidius;
            if (d <= 0) {
                canDo = true;
            } else {
                int DX = d - W;
                int DY = d - H;
                if (DX <= 0 && DY <= 0) {
                    canDo = true;
                }
            }
            bw.append(canDo ? elementDamange + "\n" : "0\n");
        }
        bw.flush();
    }

}
