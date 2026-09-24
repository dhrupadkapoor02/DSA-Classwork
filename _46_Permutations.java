import java.util.*;

public class _46_Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), result);

        return result;
    }

    private static void backtrack(
            int[] nums,
            List<Integer> current,
            List<List<Integer>> result) {

        // A complete permutation is formed
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every number
        for (int num : nums) {

            // Don't use an element twice
            if (current.contains(num)) {
                continue;
            }

            // Choose
            current.add(num);

            // Explore
            backtrack(nums, current, result);

            // Undo choice
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(permute(nums));
    }
}