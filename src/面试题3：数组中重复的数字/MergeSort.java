/**
 * 归并排序，快速排序，堆排序
 */

public class MergeSort {
//    归并排序
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        Comparable[] aus = new Integer[hi+1];
        for(int k = 0; k <= hi; k++) {
            aus[k] = a[k];
        }
        for(int k = lo; k <= hi; k++) {
            if(i > mid) a[k] = aus[j++];
            else if(j > hi) a[k] = aus[i++];
            else if(less(aus[j], aus[i])) a[k] = aus[j++];
            else a[k] = aus[i++];
        }
    }
}
