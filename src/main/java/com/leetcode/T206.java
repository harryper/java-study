package com.leetcode;

/**
 * 反转单项链表
 * @author harryper
 * @date 2021/5/17
 */
public class T206 {

    public static ListNode reverse(ListNode head) {
        // 新链表的前一个节点
        ListNode prev = null;
        // 当前节点
        ListNode cur = head;
        while (cur != null) {
            // 需要记住断开后的下一个节点
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.getNode(6);
        System.out.print("原链表是：");
        ListNode.print(node);

        System.out.println();

        ListNode result = reverse(node);
        System.out.print("新链表是：");
        ListNode.print(result);

    }
}


