package easy;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = 0;

        if (head == null) {
            return head;
        }

        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int removeFromIdx = length - n;
        int idx = 0;
        curr = head;
        ListNode prev = null;

        while (idx <= removeFromIdx) {

            if (idx == removeFromIdx - 1) {
                prev = curr;
            }

            if (idx == removeFromIdx && prev == null) {
                head = curr.next;
            } else if (idx == removeFromIdx && prev != null) {
                prev.next = curr.next;
            }

            curr = curr.next;
            idx++;
        }

        return head;

    }

}
