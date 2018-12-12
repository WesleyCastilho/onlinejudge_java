package MYFUNCTION;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author Teerapat Phokhonwong
 * @DATE: 12/12/2018
 * @Note:
 */
public class CustomLinkedList {

    class Node {
        String data;
    }

    static class SingleWayLinkedList {
        Node nextNode;

        public SingleWayLinkedList() {
        }

        public SingleWayLinkedList(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }

    static class TwoWayLinkedList {
        Node nextNode;
        Node prevNode;

        public TwoWayLinkedList() {
        }

        public TwoWayLinkedList(Node nextNode, Node prevNode) {
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        SingleWayLinkedList singleWayLinkedList = new SingleWayLinkedList();
        TwoWayLinkedList twoWayLinkedList = new TwoWayLinkedList();

    }


}
