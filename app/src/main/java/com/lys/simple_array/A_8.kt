package com.lys.simple_array

/**
 * Created:2019-10-12 09: 47
 * Email:njzy_lys@163.com
 * @author :liuyanshan
 * 描    述：
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */


fun main() {
    val nums = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(nums)
    print(nums.toList())
}


/**
 * 思路就是 用一个标志位 记录 把所以非0的 移动到前面
 * 后面循环用0 补足数组。
 */
fun moveZeroes(nums: IntArray) {
    var j = 0
    for (num in nums) {
        if (num != 0) {
            nums[j] = num
            j++
        }
    }
    for (j in j until nums.size) {
        nums[j] = 0
    }

}

