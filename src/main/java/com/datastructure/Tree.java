package com.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author harryper
 * @date 2021/4/22
 */
public class Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        List<Integer> result = preOrder(root);
        result.forEach(System.out::println);
    }

    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while(root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return result;
    }
}

class TreeNode {
    /**
     * 节点值
     */
    int val;
    /**
     * 左节点
     */
    TreeNode left;
    /**
     * 右节点
     */
    TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}

