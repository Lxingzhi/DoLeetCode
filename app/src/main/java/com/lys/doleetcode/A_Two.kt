/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
fun main() {
    val nums = intArrayOf(1, 1, 1, 2, 3, 4, 4, 4, 4, 4)
    // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
    val len = removeDuplicates(nums)

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
    for (i in 0 until len) {
        print(nums[i])
    }
}
