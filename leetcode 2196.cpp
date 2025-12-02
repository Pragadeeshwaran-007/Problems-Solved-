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
    TreeNode* createBinaryTree(vector<vector<int>>& descriptions) {
        unordered_map<int, pair<TreeNode*, bool>> nodes;
        
        for (const auto& n : descriptions){
            TreeNode *parent, *child;
            if (nodes.find(n[0]) == nodes.end()){
                parent = new TreeNode(n[0]);
                nodes[n[0]] = {parent, false};
            }
            else{
                parent = nodes[n[0]].first;
            }
            
            if (nodes.find(n[1]) == nodes.end()){
                child = new TreeNode(n[1]);
                nodes[n[1]] = {child, true};
            }
            else{
                child = nodes[n[1]].first;
                nodes[n[1]].second = true;
            }

            if (n[2]) parent->left = child;
            else parent->right = child;
        }

        for (const auto& p : nodes){
            if (p.second.second == false){
                return p.second.first;
            }
        }
        return nullptr;
    }
};