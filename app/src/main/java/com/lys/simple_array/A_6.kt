package com.lys.simple_array

import java.util.*

/**
 * Created:2019-08-13 10: 44
 * Email:liu.yanshan@aldelo.com
 * @author :liuyanshan
 * 描    述：给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:

 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
fun main() {
    val nums1 = intArrayOf(1, 2, 2, 1)
    val nums2 = intArrayOf(2, 2)
    print(intersect(nums1, nums2).toList())


}

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val map = hashMapOf<Int, Int>()
    //先遍历第一个数组，并初始化map
    for (i in 0 until nums1.size) {
        if (map.containsKey(nums1[i])) {
            map[nums1[i]] = map.getValue(nums1[i]) + 1
        } else {
            map[nums1[i]] = 1
        }
    }

    val list = LinkedList<Int>()
    //再遍历第二个数组，将于map中找到的key放入list中
    for (j in 0 until nums2.size) {
        val mapData = map[nums2[j]]
        if (mapData != null && map.containsKey(nums2[j]) && map[nums2[j]]!! > 0) {
            list.add(nums2[j])
            map[nums2[j]] = map.get(nums2[j])!! - 1
        }
    }

    return list.toIntArray()

}