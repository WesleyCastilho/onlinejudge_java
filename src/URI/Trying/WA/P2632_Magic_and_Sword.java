package URI.Trying.WA;


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

    static class Enemy {
        int x, y;
        int width, height;

        public Enemy(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        boolean explosion(Spell spell) {
            int right = this.x + width;
            int bot = this.y + height;
            int spellXL = (spell.x - spell.radius);
            int spellXR = (spell.x + spell.radius);
            int spellYT = (spell.y - spell.radius);
            int spellYB = (spell.y + spell.radius);
            System.out.println("X=" + x);
            System.out.println("Y=" + y);
            System.out.println("right=" + right);
            System.out.println("bot=" + bot);
            System.out.println("spellXL=" + spellXL);
            System.out.println("spellXR=" + spellXR);
            System.out.println("spellYT=" + spellYT);
            System.out.println("spellYB=" + spellYB);
//            if (right > spellXL && right <= spellXR &&)
            if (spellXL >= this.x && spellXR <= right && spellYT >= this.y && spellYB <= bot) {
                return true;
            }


            return false;
        }


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

            Enemy enemy = new Enemy(X0, Y0, W, H);
            Spell spell = new Spell(CX, CY, elementRidius);
            bw.append(enemy.explosion(spell) ? elementDamange + "\n" : "0\n");
        }
        bw.flush();
    }
}



