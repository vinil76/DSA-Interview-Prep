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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean zig = true;

        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> level = new ArrayList<>(Collections.nCopies(sz, 0));
            
            for(int i = 0;i<sz;i++){
                TreeNode node = q.poll();
                
                int index = zig ? i : sz - i - 1;
                level.set(index, node.val);

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }

            zig = !zig;
            ans.add(level);
        }

        return ans;   
    }
}