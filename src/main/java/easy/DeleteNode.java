package easy;

public class DeleteNode {

    public static void main(String[] args) {



    }

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

}
