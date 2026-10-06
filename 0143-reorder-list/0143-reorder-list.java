class Solution {
    public void reorderList(ListNode head) {

        // find center
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // slice List (haed / sec)
        ListNode sec = slow.next;
        slow.next = null;

        // reverse sec list
        ListNode prev = null;
        ListNode current = sec;  
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // add haed/second list
        ListNode first = head;
        ListNode second = prev;
        while (second != null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }

    }
}