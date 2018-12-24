package STRUCTURE_AND_ALGORITHM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author Teerapat Phokhonwong
 * @DATE: 12/12/2018
 * @Note:
 */
public class CustomLinkedList {


    static class SingleWayLinkedList<Object> {

        private class Node<Object> {
            Object data;
            Node next;

            public Node(Object data) {
                this.data = data;
            }

        }

        private Node firstNode;
        private Node lastNode;

        public SingleWayLinkedList() {
        }

        void add(Object data) {
            Node node = new Node(data);
            if (firstNode == null) {
                firstNode = node;
                lastNode = node;
            } else if (isLessThan(firstNode.data, node.data)) {
                node.next = firstNode;
                firstNode = node;
            } else if (isGreaterThan(node.data, lastNode.data)) {
                lastNode.next = node;
                lastNode = node;
            } else {
                Node cur = firstNode;
                Node prev = null;
                while (cur != null) {
                    if (isLessThan(cur.data, node.data)) break;
                    prev = cur;
                    cur = cur.next;
                }
                prev.next = node;
            }
        }

        void remove(Object data) {

            if (firstNode.data == data) {
                firstNode = firstNode.next;
            }

            Node cur = firstNode;
            Node prev = null;
            while (cur != null) {
                if (cur.equals(data)) {
                    prev = cur;
                    break;
                }
                cur = cur.next;
            }
            if (cur == lastNode) {
                lastNode = prev;
                lastNode.next = null;
            } else {
                prev.next = cur.next;
            }
        }

        private boolean isLessThan(java.lang.Object data1, java.lang.Object data2) {
            return ((Integer) data1).compareTo((Integer) data2) <= 0;
        }

        private boolean isGreaterThan(java.lang.Object data1, java.lang.Object data2) {
            return ((Integer) data1).compareTo((Integer) data2) >= 0;
        }

    }

    static class TwoWayLinkedList<Object> {

        private class NodeTwoWay {
            Object data;
            NodeTwoWay prev;
            NodeTwoWay next;

            public NodeTwoWay(Object data) {
                this.data = data;
            }
        }

        private NodeTwoWay firstNode;
        private NodeTwoWay lastNode;

        public TwoWayLinkedList() {
        }

        public void add(Object data) {
            NodeTwoWay newNode = new NodeTwoWay(data);
            if (firstNode == null) {
                firstNode = newNode;
                lastNode = newNode;
            } else if (isLessThan(firstNode.data, newNode.data)) {
                firstNode.prev = newNode;
                newNode.next = firstNode;
                firstNode = newNode;
            } else if (isGreaterThan(lastNode.data, newNode.data)) {
                lastNode.next = newNode;
                newNode.prev = lastNode;
                lastNode = newNode;
            } else {
                NodeTwoWay cur = firstNode;
                while (cur != null && isLessThan(cur.data, newNode.data)) {
                    cur = cur.next;
                    break;
                }
                newNode.next = cur.next;
                cur.next = newNode;
                newNode.prev = cur;
            }
        }


        public void remove(Object node) {
            if (firstNode.data.equals(((NodeTwoWay) node).data)) {
                firstNode = firstNode.next;
                firstNode.prev = null;
            } else if (lastNode.data.equals(((NodeTwoWay) node).data)) {
                lastNode = lastNode.prev;
                lastNode.next = null;
            } else {
                NodeTwoWay cur = firstNode;
                while (cur != null) {
                    if (cur.data.equals(((NodeTwoWay) node).data)) {
                        NodeTwoWay prev = cur.prev;
                        NodeTwoWay next = cur.next;
                        prev.next = next;
                        next.prev = prev;
                    }
                }
            }
        }

        public void removeAll() {
            firstNode = null;
            lastNode = null;
        }


        private boolean isLessThan(java.lang.Object data1, java.lang.Object data2) {
            return ((Integer) data1).compareTo((Integer) data2) <= 0;
        }

        private boolean isGreaterThan(java.lang.Object data1, java.lang.Object data2) {
            return ((Integer) data1).compareTo((Integer) data2) >= 0;
        }

    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        SingleWayLinkedList<String> singleWayLinkedList = new SingleWayLinkedList<String>();
        TwoWayLinkedList<String> twoWayLinkedList = new TwoWayLinkedList<String>();


    }


}
