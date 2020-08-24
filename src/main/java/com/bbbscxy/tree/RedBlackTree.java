package com.bbbscxy.tree;

/**
 * @作者 Administrator
 * @时间 2020-08-04 11:42
 * @版本 1.0
 * @说明
 */
public class RedBlackTree {

    private TreeNode root;
    private static final boolean BLACK = false;
    private static final boolean RED = true;

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        boolean color;
        public TreeNode(int val, TreeNode left, TreeNode right, boolean color) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    public TreeNode put(int val){
        root = put(root, val);
        return root;
    }

    private TreeNode put(TreeNode node, int val) {
        if(node == null){
            return new TreeNode(val, null, null, RED);
        }

        if(val > node.val){
            node.right = put(node.right, val);
        }else if(val < node.val){
            node.left = put(node.left, val);
        }else {
            node.val = val;
        }

        if(isRed(node.right) && !isRed(node.left)){
            node = rolateLeft(node);
        }

        if(isRed(node.left) && null != node.left && isRed(node.left.left)){
            node = rolateRight(node);
        }

        if(isRed(node.left) && isRed(node.right)){
            node = changeColor(node);
        }

        return node;
    }

    private TreeNode changeColor(TreeNode node) {
        node.left.color = BLACK;
        node.right.color = BLACK;
        node.color = RED;
        return node;
    }

    private TreeNode rolateRight(TreeNode node) {
        TreeNode x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private TreeNode rolateLeft(TreeNode node) {
        TreeNode x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private boolean isRed(TreeNode right) {
        if(null != right){
            return right.color == RED;
        }else{
            return BLACK;
        }
    }

    private void traverse() {
        traverse(root);
    }

    private void traverse(TreeNode root) {

    }

    public static void main(String[] args) {

    }
}
