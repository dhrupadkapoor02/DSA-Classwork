import java.util.*;

public class _77_Combinations {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(1, n, k, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int start,
            int n,
            int k,
            List<Integer> current,
            List<List<Integer>> result) {

        // We have selected k numbers
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every number from start to n
        for (int i = start; i <= n; i++) {

            // Choose
            current.add(i);

            // Move to i + 1 because
            // the same number cannot be used again
            backtrack(i + 1, n, k, current, result);

            // Undo choice
            current.remove(current.size() - 1);
        }
    }
}