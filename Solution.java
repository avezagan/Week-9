import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * Solution class to find the length of the longest consecutive elements sequence.
 */
public class Solution {
    /**
     * This method returns the length of the longest consecutive elements sequence.
     *
     * @param nums an array of integers
     * @return length of the longest consecutive elements sequence
     */
    public int longestConsecutive(int[] nums) {
        // Check if the array is null or empty
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Use a HashSet to store the unique elements
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        // Iterate through the set to find the longest sequence
        for (int num : set) {
            // Check if the current number is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Increment the sequence length if the next number in the sequence exists
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        // Read input size
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Read input elements
        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        // Get and print the result
        int result = solution.longestConsecutive(nums);
        System.out.println("Longest consecutive sequence length: " + result);
    }
}
