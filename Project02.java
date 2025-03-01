package gr.aueb.cf.chTest;

public class Project02 {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum contiguous subarray sum : "+maxSubArray(arr)); // 6
    }

    // Runtime Complexity : O(n)
    // Space Complexity   : O(1)
    public static int maxSubArray(int[] nums) {
        int currentMax = 0;
        int globalMax = 0;

        if(nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        } else {
            currentMax = nums[0];
            globalMax = nums[0];
            for(int i = 1; i < nums.length; i++) {
                currentMax = Math.max(currentMax + nums[i], nums[i]);
                globalMax = Math.max(globalMax, currentMax);
            }
        }
        return globalMax;
    }
}
