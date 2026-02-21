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
class Solution {//TC=o(n) SC=o(h)
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,new ArrayList<>());
        return result;
    }
    private void dfs(TreeNode node,int sum,List<Integer> path){
        if(node==null)return;
        path.add(node.val);
        sum-=node.val;
        if(node.left==null && node.right==null && sum==0)result.add(new ArrayList<>(path));//COPY
        dfs(node.left,sum,path);
        dfs(node.right,sum,path);
        path.remove(path.size()-1);//BACKTRACK
    }
}