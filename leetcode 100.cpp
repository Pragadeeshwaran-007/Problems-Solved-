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
    bool isSameTree(TreeNode* p, TreeNode* q) {
        vector<int> arr1 ;
        vector<int> arr2 ;
        helper(arr1,p);
        helper(arr2,q);
        return arr1 == arr2;
    }
    void helper(vector<int>& res , TreeNode* root){
        if(root == nullptr) {
            res.push_back(-19980);
            return;
        }
        res.push_back(root->val);
        helper(res , root->left);
        helper(res , root->right);
    }
};