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
    val nums = intArrayOf(9)
    print(plusOne(nums).toList())
}

fun plusOne(digits: IntArray): IntArray {
    if (digits.isEmpty()) {
        return digits
    }
    var digitsPlusOne = digits
    digitsPlusOne[digitsPlusOne.size - 1] = digitsPlusOne.last() + 1
    val lastData = digitsPlusOne.last()

    if (lastData % 10 == 0) {
        digitsPlusOne[digitsPlusOne.size - 1] = 0
        if (digitsPlusOne.size == 1) {
            //如果首位大于9， 将数组扩大一位，首位变为1
            digitsPlusOne = IntArray(digitsPlusOne.size + 1)
            digitsPlusOne[0] = 1
        } else {
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
        }

        return digitsPlusOne
    } else {
        return digitsPlusOne

    }

}

/**
 * 根据题意加一，没错就是加一这很重要，因为它是只加一的所以有可能的情况就只有两种：
除 99 之外的数字加一；
数字 99。
加一得十进一位个位数为 00 加法运算如不出现进位就运算结束了且进位只会是一。
所以只需要判断有没有进位并模拟出它的进位方式，如十位数加 11 个位数置为 00，如此循环直到判断没有再进位就退出循环返回结果。
然后还有一些特殊情况就是当出现 9999、999999 之类的数字时，循环到最后也需要进位，出现这种情况时需要手动将它进一位。

 */
fun plusOne2(digits: IntArray): IntArray {
    var digits = digits
    for (i in digits.indices.reversed()) {
        digits[i]++
        digits[i] = digits[i] % 10
        if (digits[i] != 0) return digits
    }
    digits = IntArray(digits.size + 1)
    digits[0] = 1
    return digits
}