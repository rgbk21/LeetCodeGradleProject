package easy;

public class PalindromeLinkedList {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {

        if (head == null) return true;

        ListNode mid = findMiddlePointOf(head);

        ListNode newHead = reverseLinkedListStartingFrom(mid.next);

        boolean listsEqual = areListsEqual(head, newHead);

        return listsEqual;

    }

    private boolean areListsEqual(ListNode left, ListNode right){

        ListNode curr1 = left;
        ListNode curr2 = right;

        while (curr2 != null) {
            if (curr1.val != curr2.val) {
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return true;

    }

    private ListNode findMiddlePointOf(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        //TODO:
        // This is important. See here: https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1216/
        // You incorrectly had just the first (fast != null) condition which was giving the incorrect answer
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    private ListNode reverseLinkedListStartingFrom(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
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
