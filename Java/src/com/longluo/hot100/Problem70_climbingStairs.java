package com.longluo.hot100;

/**
 * 70. Climbing Stairs
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * <p>
 * Constraints:
 * 1 <= n <= 45
 * <p>
 * https://leetcode.com/problems/climbing-stairs/
 */
public class Problem70_climbingStairs {

    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int[] num = new int[n];
        num[0] = 1;
        num[1] = 2;
        for (int i = 2; i < n; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }

        return num[n - 1];
    }

    public static int climbStairs_fastest(int n) {
        double ans = (Math.pow((1 + Math.sqrt(5)) / 2, n + 1) - Math.pow((1 - Math.sqrt(5)) / 2, n + 1)) / Math.sqrt(5);
        return (int) ans;
    }

    public static void main(String[] args) {

    }
}