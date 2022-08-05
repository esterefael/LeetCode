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
    public int countNodes(TreeNode root) {
        
       if(root == null)
            return 0;
        int height = findHeight(root,true);
        double sumWithoutLastLevel = (1<<height + 1)-1;
        return (int)(sumWithoutLastLevel + sumLastLevel(root, height));
    }
    public double sumLastLevel(TreeNode root, int height) {
        
        if(root == null)
            return 0;
        int midLeftHeight = findHeight(root.left, true);
        int midRightHeight = findHeight(root.right, false);        
        if(midLeftHeight != midRightHeight)
            return 1<<height;
        else
            if(midLeftHeight == height)
                return (1<<height) + sumLastLevel(root.right, height - 1);
            else
                return sumLastLevel(root.left, height - 1);            
    }
    public int findHeight(TreeNode root, boolean isRight){
        
        int height = -1;
        while(root != null){
            height++;
            root = isRight ? root.right : root.left;
        } 
        return height;
    }
}