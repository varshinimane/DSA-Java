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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;

        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        map.put(root, null);
        List<TreeNode> list = new ArrayList<>(); //stores last levels of the tree

        while(!q.isEmpty()){
            int size = q.size();
            list.clear();

            for(int i = 0;i < size;i++){
                TreeNode node = q.poll();
                list.add(node);

                if(node.left != null){
                    map.put(node.left, node);
                    q.offer(node.left);
                }
                if(node.right != null){
                    map.put(node.right, node);
                    q.offer(node.right);
                }
            }
        }
        Set<TreeNode> deep = new HashSet<>(list);

        while(deep.size() > 1){
            Set<TreeNode> next = new HashSet<>();
            for(TreeNode node : deep){
                next.add(map.get(node));
            }
            deep = next;
        }
        return deep.iterator().next();
    }
}