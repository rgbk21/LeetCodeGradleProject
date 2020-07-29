package medium;

import easy.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {

    }

    //(2 -> 4 -> 3) + (5 -> 6 -> 4)
    //Bad Code......
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode result_curr = result;

        ListNode l1_head = l1;
        ListNode l2_head = l2;

        ListNode l1_curr = l1_head;
        ListNode l2_curr = l2_head;

        int carry = 0;

        while (l1_curr != null && l2_curr != null) {

            result_curr.next = new ListNode();
            result_curr.next.val = l1_curr.val + l2_curr.val + carry;

            if (result_curr.val >= 10) {
                result_curr.val = result_curr.val % 10;
                carry = 1;
            }

            result_curr = result_curr.next;
            l1_curr = l1_curr.next;
            l2_curr = l2_curr.next;

        }

        if (l1_curr == null && l2_curr != null) {
            while (l2_curr != null){
                result_curr.next = new ListNode();
                result_curr.next.val = l2_curr.val + carry;

                if (result_curr.val >= 10) {
                    result_curr.val = result_curr.val % 10;
                    carry = 1;
                }

                l2_curr = l2_curr.next;
            }
        } else if (l2_curr == null && l1_curr != null) {
            while (l1_curr != null){
                result_curr.next = new ListNode();
                result_curr.next.val = l1_curr.val + carry;

                if (result_curr.val >= 10) {
                    result_curr.val = result_curr.val % 10;
                    carry = 1;
                }

                l1_curr = l1_curr.next;
            }
        } else {
            result_curr.val += carry;
        }

        return result.next;

    }

    //Correct Solution
    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2){

        ListNode result = new ListNode();
        ListNode curr = result;

        ListNode l1_curr = l1;
        ListNode l2_curr = l2;

        int carry = 0;
        int sum = 0;

        while (l1_curr != null || l2_curr != null) {

            int x = l1_curr == null ? 0 : l1_curr.val;
            int y = l2_curr == null ? 0 : l2_curr.val;

            sum = x + y + carry;

            curr.next = new ListNode();

            if (sum >= 10) {
                curr.next.val = sum % 10;
                carry = 1;
            } else {
                curr.next.val = sum;
                carry = 0;
            }

            l1_curr = l1_curr == null ? null : l1_curr.next;
            l2_curr = l2_curr == null ? null : l2_curr.next;

            curr = curr.next;
        }

        if (carry == 1) {
            curr.next = new ListNode();
            curr.next.val = 1;
        }

        return result.next;

    }

}
