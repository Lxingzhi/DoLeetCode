package com.lys.simple_array

/**
 * Created:2019-08-12 10: 31
 * Email:liu.yanshan@aldelo.com
 * @author :liuyanshan
 * 描    述：如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */

fun main() {
    val nums = intArrayOf(1, 2, 3, 1)
    print(containsDuplicate(nums))
}


fun containsDuplicate(nums: IntArray): Boolean {
    //新数组然后判断是否包含。
    var newArray = intArrayOf()
    for (i in nums) {
        if (newArray.contains(i)) {
            return true
        }
        newArray = newArray.plus(i)
    }
    return false
}

/*
 * 方法二：排序 【通过】 链接：https://leetcode-cn.com/problems/two-sum/solution/cun-zai-zhong-fu-yuan-su-by-leetcode/

 * 直觉

 * 如果存在重复元素，排序后它们应该相邻。

 * 算法

 * 本方法使用排序算法。由于比较排序算法，如堆排序，可以在最坏情况下具有 O(n \log n)O(nlogn) 的时间复杂度。因此，排序经常是很好的预处理方法。排序之后，我们可以扫描已排序的数组,以查找是否有任何连续的重复元素。
 *
 * public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; ++i) {
        if (nums[i] == nums[i + 1]) return true;
    }
    return false;
 * }

*
* */