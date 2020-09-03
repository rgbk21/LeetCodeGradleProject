package easy;

public class RemoveLinkedListElement {

    //https://leetcode.com/problems/remove-linked-list-elements/

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

    public static ListNode removeElements2(ListNode head, int val){

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            if (curr.val == val && prev != null) {
                prev.next = curr.next;
                curr = curr.next;
            } else if (curr.val == val && prev == null) {
                head = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }

        }

        return head;



    }

}

