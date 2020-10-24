import java.util.Arrays;
import java.util.Scanner;

public class FindDuplicatedNumber {
    /**
     * 题目一：找到数组中重复的数字
     * 当循环到某一位置时，如果下标大小与当前下标处的元素大小不相等时，将元素放到下标为元素大小的位置上
     * 继续while循环，直到当前位置下标与元素大小相同时再跳出while循环后继续for循环
     * 时间复杂度O(n),空间复杂度O(1)
     * 时间复杂度分析：因为虽然有两重循环，但每个数字最多进行两次交换就能找到其位置，所以时间复杂度为主要在for循环的执行次数上
     * @param numbers
     * @return
     */
    public static int findDuplicatedNumber1(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            while(numbers[i] != i) {
                if(numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return -1;
    }

    /**
     * 题目二：不修改数组找出重复的数字
     * 可以通过建立辅助数组后，将原数组每个元素放在辅助数字中下标与元素大小一样的位置，来找到重复的数字，但这会额外占用空间
     * 改进：分析该数组特性，数组大小为n+1,元素大小范围为1-n,则在某一范围内元素的个数很重要，如找到1-4的范围，遍历数组后
     *      发现1-4的数字出现了超过4次，则此范围内一定存在重复的数字。可运用二分法来确定范围
     * @param numbers
     * @return
     */
    public static int findDuplicatedNumber2(int[] numbers) {
        int start = 1, end = numbers.length - 1;
        while(start <= end) {
            int mid = (end - start)/2 + start;  //易出错点
            int count = countRange(numbers, start, mid);
            if(end == start) {
                if(count > 1)
                    return start;
                else
                    break;
            }
            if(count > (mid - start + 1))
                end = mid;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static int countRange(int[] numbers, int start, int end) {
        int count = 0;
        for (int number : numbers) {
            if(number >= start && number <= end) {
                count++;
            }
        }
        return count;
    }

    private static void swap(int[] numbers, int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数组大小：");
        while(in.hasNext()) {
            int m = in.nextInt();
            int[] numbers = new int[m];
            System.out.println("请输入数组：");
            for (int i = 0; i < m; i++) {
                numbers[i] = in.nextInt();
            }
            System.out.println("数组为：" + Arrays.toString(numbers));
            /*题目一
            int duplicatedNumber1 = findDuplicatedNumber1(numbers);
            System.out.println("题目一中重复的数字为：" + duplicatedNumber);*/
            //题目二
            int duplicatedNumber2 = findDuplicatedNumber2(numbers);
            System.out.println("题目二中重复的数字为：" + duplicatedNumber2);
        }
    }
}
