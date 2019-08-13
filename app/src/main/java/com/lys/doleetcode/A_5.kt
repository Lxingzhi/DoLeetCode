package com.lys.doleetcode

/**
 * Created:2019-08-12 15: 56
 * Email:liu.yanshan@aldelo.com
 * @author :liuyanshan
 * 描    述：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
fun main() {

    val nums = intArrayOf(1, 1, 2, 1, 2, 4)
    print(singleNumber(nums))

}

fun singleNumber(nums: IntArray): Int? {
    var numNew = nums.toList()
    for (i in nums) {
        val oldSize = numNew.size
        numNew = numNew.filter {
            it != i
        }

        val newSize = numNew.size
        if (oldSize - newSize == 1) {
            return i
        }
    }
    return null
}


/**
思路：此题可以使用循环遍历的方法，但是有个更好的方法就是用位运算，首先要讲一下什么是位运算，由于计算机里面整形数据（int）存储是用二进制的方法，我们可以直接操作这些二进制的数据已到达我们目的就是位运算。
与运算（&）：两个都为1结果才为1，否则为0；
或运算（|）：两个中的其中一个为1 就为1，两个都为0才为0
异或（^）：相同为数字不同就为1，相同就0；
此题我们可以采取异或运算的特性，如果两个数字相同那么他们的每一位一定相同，所以两个相同的数字进行异或运算就为0，而0与任何数进行异或运算都为该数字本身（数字0 的每一位都为0而另一个数字有些为0有些为1，这些为1的就不和0相同所以结果还是1，而其中的0和数字0中的对应位都为0所以还是0）。所以把所有数字进行异或运算a^b^f^b^a，异或运算具有交换律（可以自己证明一下）所有等价于(a^a)^(b^b)^f，-->0^0^f =f这样就找出只出现一次的数

作者：vailing
链接：https://leetcode-cn.com/problems/two-sum/solution/jie-ti-si-lu-by-vailing/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
int singleNumber(vector<int>& nums) {
int sum = 0;
for(int i = 0 ;i<nums.size();++i)
sum^=nums[i];
return sum;
}

 */