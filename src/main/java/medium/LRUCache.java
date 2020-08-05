package medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Node> map;
    int cap;
    Node head;
    Node tail;

    class Node {

        int key;
        int value;
        Node prev;
        Node next;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    public LRUCache(int capacity) {

        cap = capacity;
        map = new HashMap<>();

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {

        Node node = map.get(key);
        if (node != null) {
            removeNodeFromCurrPositionInQAssocWith(key);
            updateTheHeadOfTheQToNode(node);
            return node.value;
        }

        return -1;

    }

    public void put(int key, int value) {

        Node node = map.get(key);

        if (node != null) {
            removeNodeFromCurrPositionInQAssocWith(key);
            Node newNode = new Node(key, value);
            updateTheHeadOfTheQToNode(newNode);
            map.put(key, newNode);
        } else {
            if (map.size() < cap) {
                Node newNode = new Node(key, value);
                updateTheHeadOfTheQToNode(newNode);
                map.put(key, newNode);
            } else {
                Node newNode = new Node(key, value);
                removeTheNodeAtTheTailFromTheCache();
                updateTheHeadOfTheQToNode(newNode);
                map.put(key, newNode);
            }
        }

    }

    private void removeNodeFromCurrPositionInQAssocWith(int key) {

        Node oldNode = map.get(key);

        //Remove the node from its prev position in the queue
        Node prevNode = oldNode.prev;
        Node nextNode = oldNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        oldNode = null;
    }

    private void updateTheHeadOfTheQToNode(Node node) {

        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;

    }

    private void removeTheNodeAtTheTailFromTheCache(){

        Node tailNode = tail.prev;

        removeNodeFromCurrPositionInQAssocWith(tailNode.key);

        //Delete from map
        map.remove(tailNode.key);
    }
}

