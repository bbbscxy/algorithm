package com.bbbscxy.tree;

/**
 * @作者 Administrator
 * @时间 2020-08-03 18:02
 * @版本 1.0
 * @说明
 */
public class BinaryTree {

    private TreeNode root;

    private class TreeNode{
        int val;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val, TreeNode parent, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode put(int val){
        if(null == root){
            root = new TreeNode(val, null, null, null);
            return root;
        }
        return put(root, val);
    }

    private TreeNode put(TreeNode node, int val) {
        if(null == node){
            return new TreeNode(val, null,null, null);
        }

        if(val > node.val){
            TreeNode temp = put(node.right, val);
            node.right = temp;
            temp.parent = node;
        }else if(val < node.val){
            TreeNode temp = put(node.left, val);
            node.left = temp;
            temp.parent = node;
        }else{
            node.val = val;
        }
        return node;
    }

    private TreeNode get(int val) {
        return get(root, val);
    }

    private TreeNode get(TreeNode node, int val) {
        if(null == node){
            return null;
        }

        if(val > node.val){
            return get(node.right, val);
        }else if(val < node.val){
            return get(node.left, val);
        }else{
            return node;
        }
    }

    private TreeNode delete(int val){
        TreeNode node = get(val);
        return delete(node);
    }

    private TreeNode delete(TreeNode node) {
        if(null == node){
            return null;
        }

        TreeNode parent = node.parent;
        if(node.left == null && node.right == null){
            if(parent.left == node){
                parent.left = null;
            }else{
                parent.right = null;
            }
            node.parent = null;
        }else if(node.left != null && node.right == null){
            if(parent.left == node){
                parent.left = node.left;
            }else{
                parent.right = node.left;
            }
            node.parent = null;
            node.left = null;
        }else{
            TreeNode left = node.right.left;
            while (left != null){
                left = left.left;
            }
            if(null == left){
                if(node.left != null){
                    node.right.left = node.left;
                    node.left.parent = node.right.left;
                }
                node.parent.right = node.right;
            }else{
                node.val = left.val;
                left.parent.left = null;
            }
        }

        return node;
    }

    private void preIterator(){
        preIterator(root);
    }

    private void middleIterator(){
        middleIterator(root);
    }

    private void nextIterator(){
        nextIterator(root);
    }

    private void preIterator(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        preIterator(node.left);
        preIterator(node.right);
    }

    private void middleIterator(TreeNode node){
        if(node == null){
            return;
        }
        middleIterator(node.left);
        System.out.println(node.val);
        middleIterator(node.right);
    }

    private void nextIterator(TreeNode node){
        if(node == null){
            return;
        }
        nextIterator(node.left);
        nextIterator(node.right);
        System.out.println(node.val);
    }

    public int treeDepth(){
        return treeDepth(root);
    }

    private int treeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return left > right ? left+1 : right+1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.put(30);
        tree.put(8);
        tree.put(15);
        tree.put(36);
        tree.put(100);
        tree.put(32);
//        tree.delete(36);
        tree.middleIterator();
    }
}
