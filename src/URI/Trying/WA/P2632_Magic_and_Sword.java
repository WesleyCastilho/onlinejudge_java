package URI.Trying.WA;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: STRING
 * @Problem: 2632 - Magic and Sword
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2632
 * @Timelimit: 1 sec
 * @Status:
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note: https://yal.cc/rectangle-circle-intersection-test/
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

    static class Enemy {
        int x, y;
        int width, height;

        public Enemy(int width, int height, int x, int y) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

    }

    static boolean intersects(Spell circle, Enemy rect) {

        int width = rect.width;
        int height = rect.height;
        int xMin = (rect.x - width);
        int xMax = (rect.x + width);
        int yMin = (rect.y - height);
        int yMax = (rect.y + height);
        //a^2 + b^2 = ความยาวเส้นแทยงมุม
//        double leght = Math.pow(rect.height, 2) * Math.pow(rect.width, 2);
//        System.out.println("R xMin=" + xMin);
//        System.out.println("R xMax=" + xMax);
//        System.out.println("R yMin=" + yMin);
//        System.out.println("R yMax=" + yMax);
//        System.out.println("C X=" + circle.x);
//        System.out.println("C Y=" + circle.y);
//        System.out.println("C R=" + circle.radius);
        boolean c1 = circle.x >= xMin && circle.x <= xMax;
        boolean c2 = circle.y >= yMin && circle.y <= yMax;
        if (c1 && c2) {
            return true;
        }

        if (c1) {//อยู่ระหว่าง X
            System.out.println("XX");
        }

        if (c2) {//อยู่ระหว่าง Y
//            System.out.print("YY");
            if (circle.x < xMin) {
//                System.out.println("-1");
                if (circle.x + circle.radius >= xMin) {
                    return true;
                }
            } else if (circle.x > xMax) {
//                System.out.println("R xMax=" + xMax);
//                System.out.println("C R=" + circle.radius);
//                System.out.println("-2");
                if (circle.x - circle.radius <= xMax) {
                    return true;
                }
            }

        }

        return false;
    }


    static class Spell {
        int x, y;
        int radius;

        public Spell(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int i = 1;
        while (n-- > 0) {
            String[] in = br.readLine().split(" ");
            W = Integer.parseInt(in[0]);
            H = Integer.parseInt(in[1]);
            X0 = Integer.parseInt(in[2]);
            Y0 = Integer.parseInt(in[3]);

            in = br.readLine().split(" ");
            String element = in[0];
            int level = Integer.parseInt(in[1]);
            CX = Integer.parseInt(in[2]);
            CY = Integer.parseInt(in[3]);
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
            if (X0 == CX && Y0 == CY) {
                bw.append(elementDamange + "\n");
                continue;
            }
            Enemy enemy = new Enemy(W, H, X0, Y0);
            Spell spell = new Spell(CX, CY, elementRidius);
//            intersects
            bw.append(intersects(spell, enemy) ? elementDamange + "\n" : "0\n");
//            bw.append(enemy.explosion(spell) ? elementDamange + "\n" : "0\n");
        }
        bw.flush();
    }
}



