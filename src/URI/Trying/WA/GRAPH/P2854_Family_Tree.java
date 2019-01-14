package URI.Trying.WA.GRAPH;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 2688 - Choosing a Place
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2688
 * @Timelimit: 1 sec
 * @Status: WA 20 %
 * @Memory:
 * @Submission:
 * @Runtime:
 * @Solution: find set of family
 * @Note: marido = สามี
 * pai = พ่อ
 * irmao = พี่ชาย
 * mae = แม่
 * tio = ลุง
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P2854_Family_Tree {

    static int m, n;
    static int[] p;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        m = Integer.parseInt(st[0]);
        n = Integer.parseInt(st[1]);
        HashMap<String, Integer> Human = new HashMap();
        p = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            p[i] = i;
        }
        int humanId = 1;
        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            String a = st[0];
            String relation = st[1];
            String b = st[2];
            Integer humanA_id = Human.get(a);
            Integer humanB_id = Human.get(b);
            if (humanA_id == null) {
                humanA_id = humanId;
                Human.put(a, humanA_id);
                humanId++;
            }

            if (humanB_id == null) {
                humanB_id = humanId;
                Human.put(b, humanB_id);
                humanId++;
            }

            switch (relation) {
                case "marido"://A สามี B
                    p[humanB_id] = findFamily(humanA_id);//A -> B
                    break;
                case "pai"://A พ่อ B
                    p[humanB_id] = findFamily(humanA_id);//A -> B
                    break;
                case "irmao"://A พี่ชาย B
                    p[humanB_id] = findFamily(humanA_id);// A -> B
                    break;
                case "mae"://A แม่ B
                    p[humanB_id] = findFamily(humanA_id);//A -> B
                    break;
                case "filho"://A ลูกชาย B
                    p[humanA_id] = findFamily(humanB_id);//B -> A
                    break;
                case "tio"://A ลุง B
                    p[humanB_id] = findFamily(humanA_id);//B -> A
                    break;
                default://อื่นๆ
                    p[humanA_id] = findFamily(humanB_id);//B -> A
                    break;
            }
        }

//        for (int i = 1; i <= m; i++) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        for (int i = 1; i <= m; i++) {
//            System.out.print(p[i] + " ");
//        }
//        System.out.println();

        int totalFamily = 0;
        for (int i = 1; i <= m; i++) {
            if (p[i] == i) totalFamily++;
        }
        System.out.println(totalFamily);
    }


    static int findFamily(int pId) {
        if (p[pId] == pId) return pId;
        return findFamily(p[pId]);
    }


}
