/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helperSerialize(root, sb);
        return sb.toString();
    }
    private void helperSerialize(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        helperSerialize(node.left, sb);
        helperSerialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(values));
        return helperDeserialize(q);
    }
    private TreeNode helperDeserialize(Queue<String> q){
        String val = q.poll();
        if(val.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helperDeserialize(q);
        node.right = helperDeserialize(q);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));