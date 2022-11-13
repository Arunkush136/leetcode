package com.longluo.contest.weekly_contest_319;

/**
 * https://leetcode.cn/contest/weekly-contest-319
 */

/**
 * https://leetcode.cn/problems/number-of-subarrays-with-lcm-equal-to-k/
 */
public class Problem2 {

    public static int subarrayLCM(int[] nums, int k) {
        int len = nums.length;

        int ans = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == k) {
                ans++;
            }

            int lcm = nums[i];
            for (int j = i + 1; j < len; j++) {
                lcm = lcm * nums[j] / gcd(lcm, nums[j]);

                if (lcm == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int subarrayLCM_opt(int[] nums, int k) {
        int ret = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                ret++;
            }

            int lcm = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                lcm = lcm * nums[j] / gcd(lcm, nums[j]);

                if (lcm == k) {
                    ret++;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + subarrayLCM(new int[]{2, 1, 1, 5}, 5));
        System.out.println("4 ?= " + subarrayLCM(new int[]{3, 6, 2, 7, 1}, 6));
        System.out.println("0 ?= " + subarrayLCM(new int[]{3}, 2));

        System.out.println("0 ?= " + subarrayLCM_opt(new int[]{3}, 2));
    }
}
