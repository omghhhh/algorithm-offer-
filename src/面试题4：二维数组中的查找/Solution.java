import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static boolean findNumberIn2Darray(int[][] array, int n) {
        boolean found = false;
        int row = 0, column = array[0].length - 1;
        while(row < array.length && column >= 0) {
            if(array[row][column] == n) {
                found = true;
                break;
            }else if(array[row][column] > n) {
                column--;
            }else
                row++;
        }
        return found;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入二维数组的行数：");
        int row = in.nextInt();
        System.out.println("输入二维数组的列数：");
        int column = in.nextInt();
        int[][] array;
        array = new int[row][column];
        for (int i = 0; i < row; i++) {
            System.out.println("请输入二维数组第" + (i+1) + "行元素：");
            for (int j = 0; j < column; j++) {
                array[i][j] = in.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(array));
        /*int[][] array = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };*/
        System.out.println("请输入待查询的数字：");
        int n = in.nextInt();
        if(findNumberIn2Darray(array, n)) {
            System.out.println("二维数组中存在该数字");
        }else{
            System.out.println("二维数组中不存在该数字");
        }
        System.out.println(Arrays.deepToString(array));
    }
}
