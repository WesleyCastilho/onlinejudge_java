package URI.Trying.NOSTATUS.DATA_STRUCTURES_AND_LIBRARIES;


/**
 * @author Teerapat Phokhonwong
 * @Onlinejudge: URI Online Judge
 * @Problem: 2671 - Decoding the Text
 * @Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2671
 * @Timelimit: 1 sec
 * @Status:
 * @Submission:
 * @Runtime:
 * @Solution: binary tree
 * @Note:
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
