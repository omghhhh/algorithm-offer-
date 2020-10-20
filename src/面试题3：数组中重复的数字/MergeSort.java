import edu.princeton.cs.algs4.In;

import java.util.Scanner;

/**
 * 归并排序，此算法实现了自顶向下的归并排序，即先将数组拆分至最小数组，然后再把小数组排序后归并（化整为零）
 */

public class MergeSort {
    private static Comparable[] aux;  //归并所需的辅助数组

    //比较两个数的大小
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //在单行中打印数组
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }

    //将字符串转换为字符数组
    public static String[] stoSa(String string) {
        String[] stringArray = string.split(",");
        return stringArray;
    }

    //合并子数组
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for(int k = 0; k <= hi; k++) {
            aux[k] = a[k];
        }
        for(int k = lo; k <= hi; k++) {
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
    //对数组进行排序
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }
    public static void sort(Comparable[] a, int lo, int hi) {
        //将数组a[lo,...,hi]排序
        if(hi <= lo) return;
        int mid = (lo + hi)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入需要排序的数字，以“，”隔开：");
        String s = in.nextLine();
        String[] a = stoSa(s);
        sort(a);
        show(a);
    }

}
