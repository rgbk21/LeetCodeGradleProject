package medium;

import easy.ListNode;

public class OddEvenLinkedList {

    public static void main(String[] args) {


    }

    // https://leetcode.com/problems/odd-even-linked-list/

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) return head;

        ListNode oddCurr = head;
        ListNode evenCurr = head.next;
        ListNode oddHead = head;
        ListNode evenHead = head.next;

        int idx = 3;
        ListNode curr = head.next.next;
        ListNode temp;

        //1,2,3,4,5
        //1,3,2,4,5
        while (curr != null) {

            if (idx % 2 == 1) {
                oddCurr.next = curr;
                temp = curr.next;
                oddCurr = curr;
                oddCurr.next = evenHead;
                curr = temp;
                evenCurr.next = temp;
                idx++;
            } else {
                evenCurr.next = curr;
                temp = curr.next;
                evenCurr = curr;
                curr = temp;
                idx++;
            }
        }

        return oddHead;
    }



}
