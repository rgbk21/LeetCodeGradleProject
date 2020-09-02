package easy;

class MyLinkedList {

    //https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/

    Node head;
    Node tail;
    int len = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        if (index < 0 || index >= len) return -1;

        int count = 0;
        Node currNode = head.next;

        while (currNode != tail) {

            if (count == index) {
                return currNode.val;
            }

            currNode = currNode.next;
            count++;

        }

        return -1;

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {

        Node node = new Node(val);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;

        len++;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

        Node node = new Node(val);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;

        len++;

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if (index < 0 || index > len) return;

        int count = 0;

        Node currNode = head.next;
        Node node = new Node(val);

        if (index == 0) {
            addAtHead(val);
            return;
        }

        while (currNode != tail) {

            if (count == (index-1)) {
                node.next = currNode.next;
                currNode.next.prev = node;
                node.prev = currNode;
                currNode.next = node;
                len++;
                break;
            }

            currNode = currNode.next;
            count++;

        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        if (index < 0 || index >= len) return;

        int count = 0;

        Node currNode = head.next;

        while (currNode != tail) {

            if (count == index) {
                Node prevNode = currNode.prev;
                Node nextNode = currNode.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
            }

            count++;
            currNode = currNode.next;

        }


    }
}

class Node {
    int val;
    Node prev;
    Node next;

    Node() {

    }

    Node(int val) {
        this.val = val;
    }
}

class TestLinkedList{

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1,2);
        list.get(1);

    }


}

/*
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */




