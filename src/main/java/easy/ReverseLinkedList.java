package easy;

public class ReverseLinkedList {

    //https://leetcode.com/problems/reverse-linked-list/

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        ListNode resultHead = null;

        while (curr != null) {

            ListNode temp = curr.next;
            if (temp == null) {
                resultHead = curr;
            }
            curr.next = prev;
            prev = curr;
            curr = temp;

        }

        return resultHead;

    }

    //Does this make sense to you now?
    public ListNode reverseList_2(ListNode head){

        //1->2->3->4->5
        //1<-2<-3<-4<-5

        ListNode curr = head;
        ListNode prev = null;
        ListNode temp;
        ListNode newHead = null;

        while (curr != null) {

            temp = curr.next;
            curr.next = prev;

            if (temp == null) newHead = curr;

            prev = curr;
            curr = temp;

        }

        return newHead;

    }

}
