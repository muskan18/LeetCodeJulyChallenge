/*
Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure
as a full binary tree, but some nodes are null.
The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also
counted into the length calculation.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
     if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int max = 1, leftmost = 1, rightmost = 1;
        root.val = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    leftmost = cur.val;
                }
                if (i == size - 1) {
                    rightmost = cur.val;
                }
                if (cur.left != null) {
                    cur.left.val = cur.val * 2;
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = cur.val * 2 + 1;
                    queue.offer(cur.right);
                }
            }
            max = Math.max(max, rightmost - leftmost + 1);

        }
        return max;
        
        
    }
}
