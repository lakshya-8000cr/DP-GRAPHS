/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 */

// @lc code=start
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
        List<List<Integer>> ls = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            
            List<Integer> l = new ArrayList<>();
  
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();

                if(curr==null)return ls;

                if(level % 2 != 0){
                    l.add(curr.val);
                }
                else if(level % 2 == 0){
                    l.add(0,curr.val);
                }

                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
            }

            level++;
            ls.add(l);

        }

        return ls;
    }
}
// @lc code=end

