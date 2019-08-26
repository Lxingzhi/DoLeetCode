package com.lys.simple_array

/**
 * Created:2019-08-26 14: 59
 * Email:njzy_lys@163.com
 * @author :liuyanshan
 * 描    述：
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */

fun main() {

    val nums = intArrayOf(1, 0, 1, 1, 3)
    print(plusOne(nums).toList())
}

fun plusOne(digits: IntArray): IntArray {
    var digitsPlusOne = digits
    digitsPlusOne[digitsPlusOne.size - 1] = digitsPlusOne.last() + 1
    val lastData = digitsPlusOne.last()

    if (lastData % 10 == 0) {
        digitsPlusOne[digitsPlusOne.size - 1] = 0
        //倒地一个已经做处理了
        for (i in 2..digitsPlusOne.size) {
            //先加一下然后做判断
            digitsPlusOne[digitsPlusOne.size - i] = digitsPlusOne[digitsPlusOne.size - i] + 1

            if (digitsPlusOne[digitsPlusOne.size - i] % 10 != 0) {
                //不需要进位直接跳出 不需要继续循环
                break
            } else {
                if (i == digitsPlusOne.size) {
                    //如果首位大于9， 将数组扩大一位，首位变为1
                    digitsPlusOne = IntArray(digitsPlusOne.size + 1)
                    digitsPlusOne[0] = 1
                } else {
                    //够10 进位
                    digitsPlusOne[digitsPlusOne.size - i] = 0
                }
            }
        }
        return digitsPlusOne
    } else {
        return digitsPlusOne

    }

}