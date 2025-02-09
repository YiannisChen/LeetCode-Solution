/*
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 

Follow-up: Can you solve the problem in O(1) extra memory space?
 */


class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
   public ListNode reverseKGroup(ListNode head, int k) {
       ListNode dummy = new ListNode(0, head);
       ListNode prev = dummy;
       ListNode curr = head;
       ListNode next = null;

       //calculate the length of the linked list
       int length = 0;
       while (curr != null) {
           length++;
           curr = curr.next;
       }

       // Reverse the nodes in groups of k
       curr = head;
       while (length >= k) {
           next = curr;
           // Reverse k nodes
           for (int i = 1; i < k; i++) {
               next = next.next;
           }

           ListNode groupEnd = next.next;
           ListNode groupStart = curr;
           next.next = null;

           // Reverse the group
           prev.next = reverseList(curr);

           // Connect the reversed group with the rest of the list
           groupStart.next = groupEnd;
           prev = groupStart;
           curr = groupEnd;

           // Decrease the length by k after processing one group
           length -= k;
       }

       return dummy.next;
   }

   // Helper method to reverse a portion of the list
   private ListNode reverseList(ListNode head) {
       ListNode prev = null;
       ListNode curr = head;
       ListNode next = null;

       while (curr != null) {
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }

       return prev;
   }
}
