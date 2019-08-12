/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
fun main() {
    val nums = intArrayOf(7, 1, 3, 2, 6, 2, 1, 5, 1, 2)

    val max = maxProfit(nums)
    println(max)
}

fun maxProfit(prices: IntArray): Int {
    var max = 0

    //until prices.size - 1 是因为下面要对比i+1 的值少循环一次
    for (i in 0 until prices.size - 1) {
        //依次比较 将正的值相加即为最大值
        if (prices[i] < prices[i + 1]) {
            max += prices[i + 1] - prices[i]
        }
    }
    return max
}