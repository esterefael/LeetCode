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
    public int goodNodes(TreeNode root, int max) {
        int res = 0;
        if(root != null) {
            if(root.val >= max){
                max = root.val;
                res++;
            }
            res += goodNodes(root.left, max) + goodNodes(root.right, max);
        }
        return res;
    } 
    public int goodNodes(TreeNode root){
        return goodNodes(root, -10000);
    }
}