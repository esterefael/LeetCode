/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // public TreeNode commonAncestor = null;
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     findLowestCommonAncestor(root, p, q);
    //     return commonAncestor;
    // }
    // public boolean findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if(root == null) return false;
    //     boolean flag = root == p || root == q;
    //     boolean left = findLowestCommonAncestor(root.left, p, q);
    //     boolean right = findLowestCommonAncestor(root.right, p, q);
    //     if(left && right || left && flag || right && flag) commonAncestor = root;
    //     return left || right || flag;
    // }
     public TreeNode ancestor=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLowestCommonAncestor(root,p,q);
        return ancestor;
    }
    public boolean findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return false;
        Boolean flag=root==p || root==q;
        Boolean l=findLowestCommonAncestor(root.left,p,q);
        Boolean r=findLowestCommonAncestor(root.right,p,q);
        if(l && r || l && flag || r && flag)
        {
            ancestor=root;
        }
        return l|| r ||flag;

    }

}
