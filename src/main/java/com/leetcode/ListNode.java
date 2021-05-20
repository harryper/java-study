package com.leetcode;

/**
 * @author harryper
 * @date 2021/5/17
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 生成一个包含 count 个节点的链表
     * @param count
     * @return
     */
    public static ListNode getNode(int count) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        for (int i = 0; i < count; i++) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = cur.next;
        }
        cur.next = null;
        return pre.next;
    }

    /**
     * 打印节点
     * @param root
     */
    public static void print(ListNode root) {
        ListNode cur = root;
        while (cur != null) {
            if (cur.next == null) {
                System.out.print(cur.val);
            } else {
                System.out.print(cur.val + ",");
            }
            cur = cur.next;
        }
    }
}
