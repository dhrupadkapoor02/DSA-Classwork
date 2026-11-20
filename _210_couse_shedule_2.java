import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _210_couse_shedule_2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Step 1: Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Calculate indegree
        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {

            int course = p[0];
            int prereq = p[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Step 3: Add courses with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 4: Store course ordering
        int[] result = new int[numCourses];
        int index = 0;

        // Step 5: BFS
        while (!queue.isEmpty()) {

            int node = queue.poll();

            result[index++] = node;

            for (int neighbor : graph.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 6: Check for cycle
        if (index == numCourses) {
            return result;
        }

        return new int[0];
    }

}
