package URI2.Trying.NOSTATUS;


/**
 * Created by teerapat on 1/10/2018.
 */

import java.io.*;

public class P2626_JB6_Team {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        loop: while ((in = br.readLine()) != null) {
            String[] st = in.split(" ");
            String Dodo = st[0];
            String Leo = st[1];
            String Pepper = st[2];
            int c1 = getWeapon(Dodo);
            int c2 = getWeapon(Leo);
            int c3 = getWeapon(Pepper);

            if (c1 == c2 && c2 == c3) {
                bw.append("Putz vei, o Leo ta demorando muito pra jogar...\n");
            }
            else {
                if (c1 == 1) {
                    if (c2 == 2 && c3 == 2) {
                        bw.append("Os atributos dos monstros vao ser inteligencia, sabedoria...\n");
                        continue loop;
                    }
                } else if (c1 == 2) {
                    if (c2 == 3 && c3 == 3) {
                        bw.append("Os atributos dos monstros vao ser inteligencia, sabedoria...\n");
                        continue loop;
                    }
                } else if (c1 == 3) {
                    if (c2 == 1 && c3 == 1) {
                        bw.append("Os atributos dos monstros vao ser inteligencia, sabedoria...\n");
                        continue loop;
                    }
                }

                if (c2 == 1) {
                    if (c1 == 2 && c3 == 2) {
                        bw.append("Iron Maiden’s gonna get you, no matter how far!\n");
                        continue loop;
                    }
                } else if (c2 == 2) {
                    if (c1 == 3 && c3 == 3) {
                        bw.append("Iron Maiden’s gonna get you, no matter how far!\n");
                        continue loop;
                    }
                } else if (c2 == 3) {
                    if (c1 == 1 && c3 == 1) {
                        bw.append("Iron Maiden’s gonna get you, no matter how far!\n");
                        continue loop;
                    }
                }

                if (c3 == 1) {
                    if (c1 == 2 && c2 == 2) {
                        bw.append("Urano perdeu algo muito precioso...\n");
                        continue loop;
                    }
                } else if (c3 == 2) {
                    if (c1 == 3 && c2 == 3) {
                        bw.append("Urano perdeu algo muito precioso...\n");
                        continue loop;
                    }
                } else if (c3 == 3) {
                    if (c1 == 1 && c2 == 1) {
                        bw.append("Urano perdeu algo muito precioso...\n");
                        continue loop;
                    }
                }
                bw.append("Putz vei, o Leo ta demorando muito pra jogar...\n");
            }

        }
        bw.flush();
    }

    static int getWeapon(String weapon) {
        if (weapon.equals("papel")) {//กระดาษ
            return 1;
        } else if (weapon.equals("pedra")) {//หิน
            return 2;
        }
        //กรรไกร
        return 3;
    }

}
