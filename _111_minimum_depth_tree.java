
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class _111_minimum_depth_tree{
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // First leaf node reached guarantees the minimum depth
                if (currentNode.isLeaf()) {
                    return depth;
                }

                for (int childIndex = 0; childIndex < currentNode.getChildCount(); childIndex++) {
                    queue.offer(currentNode.getChildAt(childIndex));
                }
            }

            depth++;
        }

        return depth;
    }
}