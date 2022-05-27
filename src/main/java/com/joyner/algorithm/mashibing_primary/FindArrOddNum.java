package com.joyner.algorithm.mashibing_primary;

/**
 * <pre>
 * 一个数组有一个数出现奇数次，其他的数都是偶数次，怎么找出来
 * 思路：把所有数都进行异或，最后的结果就是结果。
 * 备注：两个相同的异或为0，这是本质。
 * </pre>
 *
 * @author 陆清云 luqy
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class FindArrOddNum {

    public int findOddNum(int[] arr) {
        int r = arr[0];
        for (int i = 1; i < arr.length; i++) {
            r ^= arr[i];
        }
        return r;
    }

    /**
     * 一个数组有2个数出现奇数次，其他的数都是偶数次，怎么找出来(假定是a和b)<br>
     *     方法：对所有数进行异或操作，得到的结果是a^b，记为eor. 其他的都为零了。
     *     1.首先a != b，所有其异或的结果一定不是0
     *     2.将eor最右侧的1保留，其他的都变为零，记录结果为：x，这个1是异或来的，也就是要么a在这一位是是0，b是1，或者a是1，b是0，
     *     当然还有一种情况就是其他数在这一位也是0或者1.
     *     3.遍历数组，把x & arr[i] != 0 的都进行获取，得到的比如是a或者b，这里假设得到a
     *     4.得到a之后，b = eor ^ a = a^b^a
     *
     *
     * 备注：0异或上N一定等于N
     *
     * @param arr
     * @return
     */
    public void findTwoOddNum(int[] arr) {
        int eor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            eor ^= arr[i];
        }

        int ans = 0;
        int x = eor & ((~eor) + 1);
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & x) != 0) {
                ans ^= arr[i];
            }
        }

        System.out.println("a=" + ans + ",b=" + (ans ^ eor));
    }


    /**
     * 提前一个整数最右侧的1，其他为都为零，例如：
     * 110100--> 000100
     * @return
     */
    public int mostRightOneBit(int a) {
        if (a == 0) {
            return a;
        }
        int i = 1;
        int times = 0;
        while (times < 32) {
            if ((i & a) != 0) {
                break;
            }
            i <<= 1;
            times++;
        }
        return i;

    }

    public int mostRightOneBitv2(int a) {
        int ans = a & ((~a) + 1);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4321, 3,3,4,4, 8,8,8,8};
        FindArrOddNum findArrOddNum = new FindArrOddNum();
        int oddNum = findArrOddNum.findOddNum(arr);
        System.out.println(oddNum);

        int i = findArrOddNum.mostRightOneBitv2(Integer.MAX_VALUE);
        System.out.println(i);

        int[] arr2 = {234,908, 2,2,4,4,4,4,9,9};
        findArrOddNum.findTwoOddNum(arr2);
    }
}
