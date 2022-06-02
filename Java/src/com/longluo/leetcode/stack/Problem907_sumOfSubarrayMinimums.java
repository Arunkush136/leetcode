package com.longluo.leetcode.stack;

/**
 * 907. 子数组的最小值之和
 * <p>
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * <p>
 * 示例 1：
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * <p>
 * 示例 2：
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 * <p>
 * 提示：
 * 1 <= arr.length <= 3 * 10^4
 * 1 <= arr[i] <= 3 * 10^4
 * <p>
 * https://leetcode.cn/problems/sum-of-subarray-minimums/
 */
public class Problem907_sumOfSubarrayMinimums {

    // BF time: O(n^3) space: O(1)
    // TLE
    public static int sumSubarrayMins_bf(int[] arr) {
        int MOD = 1_000_000_007;
        int len = arr.length;
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int min = arr[j];
                for (int k = j + 1; k <= i; k++) {
                    min = Math.min(min, arr[k]);
                }

                ans = (ans + min) % MOD;
            }
        }

        return ans;
    }

    // BF Opt time: O(n^2) space: O(1)
    // TLE
    public static int sumSubarrayMins_bf_opt(int[] arr) {
        int MOD = 1_000_000_007;
        int len = arr.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int min = arr[i];
            for (int j = i; j < len; j++) {
                min = Math.min(min, arr[j]);
                ans = (ans + min) % MOD;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("17 ?= " + sumSubarrayMins_bf(new int[]{3, 1, 2, 4}));
        System.out.println("17 ?= " + sumSubarrayMins_bf_opt(new int[]{3, 1, 2, 4}));
    }
}