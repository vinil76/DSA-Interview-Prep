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
    int height(TreeNode* root){
        if(root == NULL)return 0;

        int left  = height(root->left);
        int right = height(root->right);

        return 1 + max(left,right);
    }
    vector<int> rightSideView(TreeNode* root) {
        vector<int>ans(height(root),-1);
        if(root == NULL)return ans;

        map<int,int>m;
        queue<pair<TreeNode*,int>>q;

        q.push({root,0});

        while(!q.empty()){
            auto front = q.front();
            q.pop();

            TreeNode* node = front.first;
            int level = front.second;


            // if(node->right)q.push({node->right,level + 1});
            // if(node->left)q.push({node->left,level + 1});
            if(node->left)q.push({node->left,level + 1});
            if(node->right)q.push({node->right,level + 1});

           
            //if(m.find(level) == m.end())m[level] = node->val;
            ans[level] = node->val;
        }

        // for(auto val:m){
        //     ans.push_back(val.second);
        // }

        return ans;
        
    }
};