package easy;

public class DeleteNodeInALinkedList {

    public static void main(String[] args) {



    }

    //Trial 1:
    public void deleteNode(ListNode node) {

        ListNode dummyHead = node;
        ListNode currNode = node;
        ListNode prevNode = null;

        while (currNode != null) {

            if (prevNode == null) {
                currNode.val = currNode.next.val;
                prevNode = currNode;
                currNode = currNode.next;
            } else {
                if (currNode.next != null) {
                    currNode.val = currNode.next.val;
                    prevNode = currNode;
                    currNode = currNode.next;
                } else {
                    prevNode.next = null;
                    currNode = currNode.next;
                }
            }
        }
    }

    //Trial 2:
    public void deleteNode_2(ListNode node) {

        ListNode dummyHead = node;
        ListNode curr = dummyHead;
        ListNode prevNode = null;

        while (curr != null) {
            if (curr.next != null) {
                curr.val = curr.next.val;
                prevNode = curr;
                curr = curr.next;
            } else {
                prevNode.next = null;
                curr = curr.next;
            }
        }
    }

    //Trial 3: Correct solution
    public void deleteNode_3(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }

}
