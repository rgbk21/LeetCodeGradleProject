package easy;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != currB) {

            currA = currA == null ? headA : currA.next;
            currB = currB == null ? headB : currB.next;


        }

        return currA;

    }

}
