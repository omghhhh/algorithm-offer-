import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

public class QuickSort {
    public static void sort(Comparable[] a) {
        //将输入的数组顺序打乱，消除对输入的依赖，希望能够预测该算法的性能
        StdRandom.shuffle(a);
        System.out.println("打乱后的随机数组为：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return;
        //j是找到将数组切分开的元素
        int j = partition(a, lo, hi);
        //递归的排序切分元素左边及右边的子数组
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    /**
     * 切分函数，找到切分元素的下标
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        //两个指针，一个在头，一个在尾，向中间移动
        int i = lo, j = hi+1;
        Comparable v = a[lo];
        while(true) {
            while(MergeSort.less(a[++i],v))
                if(i == hi) break;
            while(MergeSort.less(v,a[--j]))
                if(j == lo) break;
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    /**
     * 交换数组a中下标为i和下标为j处的元素
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入待排序的数组，以逗号隔开：");
        String s = in.nextLine();
        String[] a = s.split(",");
        sort(a);
        System.out.println("排序后的数组为：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }
}
