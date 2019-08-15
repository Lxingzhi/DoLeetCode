package com.lys.simple_array


/**
 * Created:2019-08-08 17: 09
 * Email:liu.yanshan@aldelo.com
 * @author :liuyanshan
 * 描    述：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/23/
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val k = 3
    rotate(nums, k)
}

fun rotate(nums: IntArray, k: Int): Unit {
    var moveK = k % nums.size
    var count = 0
    var start = 0
    //这个比较叼 https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
    /**
     * 如果我们直接把每一个数字放到它最后的位置，但这样的后果是遗失原来的元素。因此，我们需要把被替换的数字保存在变量 temptemp 里面。然后，我们将被替换数字（temptemp）放到它正确的位置，并继续这个过程 nn 次， nn 是数组的长度。这是因为我们需要将数组里所有的元素都移动。但是，这种方法可能会有个问题，如果 n\%k==0n%k==0，其中 k=k\%nk=k%n （因为如果 kk 大于 nn ，移动 kk 次实际上相当于移动 k\%nk%n 次）。这种情况下，我们会发现在没有遍历所有数字的情况下回到出发数字。此时，我们应该从下一个数字开始再重复相同的过程。
     * 现在，我们看看上面方法的证明。假设，数组里我们有 nn 个元素并且 kk 是要求移动的次数。更进一步，假设 n\%k=0n%k=0 。第一轮中，所有移动数字的下标 ii 满足 i\%k==0i%k==0 。这是因为我们每跳 kk 步，我们只会到达相距为 kk 个位置下标的数。每一轮，我们都会移动 \frac{n}{k}
     * k
     * n
     * 个元素。下一轮中，我们会移动满足 i\%k==1i%k==1 的位置的数。这样的轮次会一直持续到我们再次遇到 i\%k==0i%k==0 的地方为止，此时 i=ki=k 。此时在正确位置上的数字共有 k \times \frac{n}{k}=nk×
     * k
     * n
     *  =n 个。因此所有数字都在正确位置上。
     */
    while (count < nums.size) {
        var current = start
        var prev = nums[start]
        do {
            val next = (current + moveK) % nums.size
            val temp = nums[next]
            nums[next] = prev
            prev = temp
            current = next
            count++
        } while (start != current)
        start++
    }
    print(nums.toList())

/*
    val length = nums.size
    if (length <= 1) {
        return
    }
    //实际移动多少，取余数。
    val moveK = k % length
    if (moveK == 0) {
        //不需要移动
        print(nums.toList())
    } else {

        //编译器执行下面代码是对的
        */
/* val newNums = IntArray(length)
         for (i in 0 until length) {
             val newPosition = k + i
             newNums[Math.abs(if (newPosition >= length) newPosition - length else newPosition)] = nums[i]
         }
         print(newNums.toList())*//*

        // 假设移动的位数是newk,那么无论是向右还是向左移动newk+n*length个位置之后,移动到还是原来的位置
        var temp = nums[0]
        for (i in 0 until k) {
            temp = nums[length - 1]
            for (j in length - 2 downTo 0) {
                // 让后一个元素等于前面的元素,相当于后面的元素是被前面的元素覆盖了
                nums[j + 1] = nums[j]
            }
            // 第一个元素在每一个循环结束之后就要把之前的临时变量填充后进去
            // 因为临时变量保存的是每一次的最后一个位置的元素
            nums[0] = temp
        }
    }
    print(nums.toList())
*/


//    1234567 1开始移动三位，然后然后依次移动三。


}