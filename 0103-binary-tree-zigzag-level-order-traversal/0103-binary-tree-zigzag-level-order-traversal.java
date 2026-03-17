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
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean lor = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> lvl = new LinkedList<>();
            for(int i = 0;i < size;i++){
                TreeNode node = queue.poll();
                if(lor) lvl.add(node.val);
                else lvl.addFirst(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);

            }
            res.add(lvl);
            lor = !lor;
        }
        return res;
    }
}