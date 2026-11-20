import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _207_cousrse_Shedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Calculate indegree
        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Add courses with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int completed = 0;

        // BFS - Kahn's Algorithm
        while (!queue.isEmpty()) {

            int node = queue.poll();
            completed++;

            for (int neighbor : graph.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check if all courses are completed
        return completed == numCourses;
    }
}