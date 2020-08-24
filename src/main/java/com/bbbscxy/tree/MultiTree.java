package com.bbbscxy.tree;

/**
 * @作者 Administrator
 * @时间 2020-08-05 18:16
 * @版本 1.0
 * @说明
 */
public class MultiTree {

    static class TreeNode {
        int val;
        TreeNode[] children;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static void traverse(TreeNode root) {
        if(null == root || null == root.children){
            return;
        }
        for (TreeNode child : root.children){
            System.out.println(child.val);
            traverse(child);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.children = new TreeNode[]{node2, node3, node4};
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node2.children = new TreeNode[]{node5, node6, node7};
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        node3.children = new TreeNode[]{node8, node9, node10};
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        node4.children = new TreeNode[]{node11, node12, node13};

        traverse(node1);
    }
}
