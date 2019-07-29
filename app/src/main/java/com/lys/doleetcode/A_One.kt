/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
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


/**l
 * 数组完成排序后，我们可以放置两个指针 i 和 j，其中 i 是慢指针，而 j 是快指针。只要
 * nums[i]=nums[j]，我们就增加 j 以跳过重复项
 * 当我们遇到 nums[j]≠nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]）的值复
 * 制到 nums[i+1]。然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
 * @param nums
 * @return
 */

fun removeDuplicates(nums: IntArray?): Int {
    if (nums == null || nums.isEmpty()) {
        return 0
    }
    var i = 0
    for (j in 1 until nums.size) {
        if (nums[i] != nums[j]) {
            i++
            nums[i] = nums[j]
        }

    }
    return i + 1
}