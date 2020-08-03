package easy;

public class ReverseLinkedList {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {

        ListNode dummyHead = head;
        ListNode curr = dummyHead;
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

}
