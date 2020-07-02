package easy;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode list1_1 = new ListNode();
        ListNode list1_2 = new ListNode();
        ListNode list1_4 = new ListNode();

        list1_1.val = 1;
        list1_1.next = list1_2;
        list1_2.val = 2;
        list1_2.next = list1_4;
        list1_4.val = 4;

        ListNode list2_1 = new ListNode();
        ListNode list2_3 = new ListNode();
        ListNode list2_4 = new ListNode();

        list2_1.val = 1;
        list2_1.next = list2_3;
        list2_3.val = 3;
        list2_3.next = list2_4;
        list2_4.val = 4;

        mergeTwoLists(list1_1, list2_1);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode mergeListHead = new ListNode();
        ListNode currMergeListNode = new ListNode();

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                if (mergeListHead.next == null) {
                    mergeListHead.next = l1;
                    currMergeListNode = mergeListHead;
                    currMergeListNode = currMergeListNode.next;
                    l1 = l1.next;
                    continue;
                }
                currMergeListNode.next = l1;
                currMergeListNode = currMergeListNode.next;
                l1 = l1.next;
            } else {
                if (mergeListHead.next == null) {
                    mergeListHead.next = l2;
                    currMergeListNode = mergeListHead;
                    currMergeListNode = currMergeListNode.next;
                    l2 = l2.next;
                    continue;
                }
                currMergeListNode.next = l2;
                currMergeListNode = currMergeListNode.next;
                l2 = l2.next;
            }
        }

        if (l1 != null ){
            while (l1 != null){
                if (mergeListHead.next == null) {
                    mergeListHead.next = l1;
                    currMergeListNode = mergeListHead;
                    currMergeListNode = currMergeListNode.next;
                    l1 = l1.next;
                    continue;
                }
                currMergeListNode.next = l1;
                currMergeListNode = currMergeListNode.next;
                l1 = l1.next;
            }
        }

        if (l2 != null ){
            while (l2 != null){
                if (mergeListHead.next == null) {
                    mergeListHead.next = l2;
                    currMergeListNode = mergeListHead;
                    currMergeListNode = currMergeListNode.next;
                    l2 = l2.next;
                    continue;
                }
                currMergeListNode.next = l2;
                currMergeListNode = currMergeListNode.next;
                l2 = l2.next;
            }
        }

        return mergeListHead.next;

    }


}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
