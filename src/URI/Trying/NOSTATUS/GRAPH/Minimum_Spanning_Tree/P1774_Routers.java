package URI.Trying.NOSTATUS.GRAPH.Minimum_Spanning_Tree;

/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI ONLINE JUDGE
 * @Categories: GRAPH
 * @Problem: 1774 - Routers
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/1774
 * @Level: 2
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: MST
 * @Note:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P1774_Routers {

    static int R, C;
    static Component[] components;

    static private class Component {
        int data;
        char color;
        LinkedList<Connection> link;

        public Component(int data, char color) {
            this.data = data;
            this.color = color;
            this.link = new LinkedList<>();
        }

        void addLink(Component b, int cost) {
            Connection connection = new Connection(b, cost);
            link.add(connection);
        }


    }

    static private class Connection {
        Component component;
        int cost;

        public Connection(Component b, int cost) {
            this.component = b;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        R = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);
        components = new Component[R + 1];
        for (int i = 0; i <= R; i++) {
            components[i] = new Component(i, 'W');
        }
        for (int i = 0; i < C; i++) {
            st = br.readLine().split(" ");
            int s = Integer.parseInt(st[0]);
            int d = Integer.parseInt(st[1]);
            int cost = Integer.parseInt(st[2]);
            components[s].addLink(components[d], cost);
        }



    }




}