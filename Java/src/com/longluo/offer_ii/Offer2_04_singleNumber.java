package com.longluo.offer_ii;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 004. 只出现一次的数字
 * <p>
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,100]
 * 输出：100
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 注意：本题与主站 137 题相同：https://leetcode-cn.com/problems/single-number-ii/
 * <p>
 * https://leetcode-cn.com/problems/WGki4K/
 */
public class Offer2_04_singleNumber {

    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length < 4) {
            return nums[0];
        }

        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if (freq.get(nums[i]) == 3) {
                freq.remove(nums[i]);
            }
        }

        return freq.entrySet().iterator().next().getKey();
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println("100 ?= " + singleNumber(new int[]{0, 1, 0, 1, 0, 1, 100}));
    }
}
