import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static String replaceBlank(String s) {
        return Pattern.compile(" ").matcher(s).replaceAll("%20");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String s  = in.nextLine();
    }
}
