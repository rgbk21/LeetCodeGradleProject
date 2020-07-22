package easy;

public class RemoveLinkedListElement {

    public static void main(String[] args) {


    }

    public static ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = head;
        ListNode currNode = head;
        ListNode prevNode = null;

        while (currNode != null){

            if (prevNode == null){
                if (currNode.val == val){
                    dummyHead = dummyHead.next;
                    currNode = currNode.next;
                } else {
                    prevNode = currNode;
                    currNode = currNode.next;
                }
            } else{
                if (currNode.val == val) {
                    prevNode.next = currNode.next;
                    currNode = currNode.next;
                } else {
                    prevNode = currNode;
                    currNode = currNode.next;
                }
            }
        }

        return dummyHead;
    }

}

