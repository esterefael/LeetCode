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
    int val;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        this.val = val;
        if(depth == 1)
            return new TreeNode(val, root, null);
        return addOneRow(root, depth);
            
    }
    public TreeNode addOneRow(TreeNode root, int depth) {
        if(root == null)
            return null;
        if(depth == 2){
            TreeNode left = new TreeNode(val, root.left, null);
            TreeNode right = new TreeNode(val, null, root.right);
            root.left = left;
            root.right = right;
        }else{
            addOneRow(root.left, val, depth - 1);            
            addOneRow(root.right, val, depth - 1);           
        }
        return root;
    }
}