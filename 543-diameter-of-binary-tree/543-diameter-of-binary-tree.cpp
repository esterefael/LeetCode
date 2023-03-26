/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int diameterOfBinaryTree(TreeNode* root) {
        int max = 0;
        diameterOfBinaryTree(root, max);
        return max;
    }    
    int diameterOfBinaryTree(TreeNode* root, int& max) {
        if(root == nullptr)
            return -1;
        int leftHeight = diameterOfBinaryTree(root->left, max) + 1;
        int rightHeight = diameterOfBinaryTree(root->right, max) + 1;
        max = std::max(max, leftHeight + rightHeight);
        return std::max(leftHeight, rightHeight);
    }
};