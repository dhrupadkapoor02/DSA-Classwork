import java.util.HashMap;

import org.w3c.dom.Node;

public class _133_clone_graph {
    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        // If already cloned, return its clone
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Create a new node
        Node clone = new Node(node.val);

        // Store original -> cloned node
        map.put(node, clone);

        // Clone all neighbours
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
