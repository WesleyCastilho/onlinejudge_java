package th.in.devboom.uri.trying;

/**
 * Created by Teerapat-BSD on 1/10/2018.
 * https://www.urionlinejudge.com.br/judge/en/problems/view/2671
 * binary tree
 */
import java.io.*;

public class P2671_Decoding_the_Text {

    static Node headerNode;

    class Node {
        char value;
        Node leftNode, rightNode;

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }

    void insert(){

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while (!(in = br.readLine()).equals("0")) {
            int wordSize = Integer.parseInt(in);
            in = br.readLine();
            buildBinaryTree(in, wordSize);
            bw.append(decodeByBFS() +"\n");
        }
        bw.flush();
    }

    static void buildBinaryTree(String word, int size) {

    }

    static String decodeByBFS() {
        String result = "";

        return result;
    }
}
