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
    public void f(TreeNode root,List<Integer> ans){
        if(root == null){
            return;
        }

        ans.add(root.val);
        f(root.left,ans);
        f(root.right,ans);

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //f(root,ans);

        if (root == null) {
            return ans;
        }

        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        s.push(root);

        while(!s.isEmpty()){

            node = s.pop();
            ans.add(node.val);

            if(node.right != null){
                s.add(node.right);
            }

            if(node.left != null){
                s.add(node.left);
            }
        }

        return ans;
    }
}