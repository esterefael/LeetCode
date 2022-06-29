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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)return false;
        if(root.val == subRoot.val)
            if(isSubtree1(root,subRoot))return true;        
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean isSubtree1(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)return true;
        if(root == null || subRoot == null)return false;
        return(root.val == subRoot.val)&&            
            isSubtree1(root.left, subRoot.left) &&
            isSubtree1(root.right, subRoot.right);
    }
}
