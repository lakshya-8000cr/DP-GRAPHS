/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)return-1; 
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> ls = new LinkedList<>();
        
        while(!q.isEmpty()){
              TreeNode curr = q.poll();

              int v = curr.val;
              ls.add(v);
              if(curr.left!=null){
                q.add(curr.left);
              }
              if(curr.right!=null){
                q.add(curr.right);
              }
        }

        Collections.sort(ls);
        return ls.get(k-1);
    }
}
// @lc code=end

