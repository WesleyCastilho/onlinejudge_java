/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1610 : Dudu Service Maker
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1610
 * @Level: 2
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution:
 * @Note:
 */
package URI.Trying.WA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P1610_Dudu_Service_Maker {

    static private class Component {
        int id;
        boolean visited;
        boolean moved;
        LinkedList<Component> link;

        public Component(int id) {
            this.id = id;
            link = new LinkedList<>();
        }

        void addLink(Component component) {
            link.add(component);
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);
        int n, m;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] st = br.readLine().split(" ");
            n = Integer.parseInt(st[0]);
            m = Integer.parseInt(st[1]);


            HashMap<Integer, Component> component = new HashMap<>();
            int a, b;
            while (m-- > 0) {
                st = br.readLine().split(" ");
                a = Integer.parseInt(st[0]);
                b = Integer.parseInt(st[1]);
                Component componentSource = component.get(a);
                Component componentDestination = component.get(b);
                if (componentSource == null) {
                    componentSource = new Component(a);
                }

                if (componentDestination == null) {
                    componentDestination = new Component(b);
                }
                componentSource.addLink(componentDestination);
                component.put(a, componentSource);
            }


            boolean looping = false;
            LinkedList<Component> Q = new LinkedList<>();
            loop:
            for (Map.Entry<Integer, Component> entry : component.entrySet()) {
                if (!entry.getValue().visited) {
                    entry.getValue().visited = true;
                    entry.getValue().moved = true;
                    Q.add(entry.getValue());

                    while (!Q.isEmpty()) {
                        Component cur = Q.pollFirst();
//                        System.out.print(cur.id + " ");
                        cur.moved = true;
                        for (Component children : cur.link) {
                            if (children.moved) {
                                looping = true;
                                break loop;
                            }
                            if (!children.visited) {
                                children.visited = true;
                                Q.add(children);
                            }
                        }
                    }
                }
            }

            bw.append((looping ? "SIM" : "NAO") + "\n");

        }
        bw.flush();
    }

}
