package com.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author harryper
 * @date 2021/5/13
 */
public class Tree {
    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        inorder(treeNode.left, list);
        list.add(treeNode.val);
        inorder(treeNode.right, list);
    }


}
