package wimi.nacos.springboot.arithmetic;

import java.util.Arrays;

/**
 * @author Long
 * @date 10:29 2020-04-23 周四
 */
public class Number1TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 15, 11};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    private static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[j] + nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum");
    }
}
