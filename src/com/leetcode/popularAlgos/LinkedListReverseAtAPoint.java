package com.leetcode.popularAlgos;

public class LinkedListReverseAtAPoint {

    public static ListNode changeHead(ListNode head, int N){
        int len = findLen(head);
        if(len < 2 ) return head;
        N = N+1;
        if(len < N){
            N = N % len;
        }
        int count = 1;
        ListNode temp = head;
        while(count < N){
            temp = temp.next;
            count++;
        }
        ListNode newHead = temp;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        head = newHead.next;
        newHead.next = null;
        return head;
    }

    private static int findLen(ListNode head){
        int len =0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }

    public static ListNode createListNode(int[] nums){
        int i =1;
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;
        while(i < nums.length){
            temp.next = new ListNode(nums[i++]);
            temp = temp.next;
        }
        return head;
    }

    public static void printValues(ListNode head) {
        while(head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = createListNode(new int[]{1,2,3,4,5,6});
        printValues(head);
        ListNode newHead = LinkedListReverseAtAPoint.changeHead(head, 4);
        printValues(newHead);
    }

}
