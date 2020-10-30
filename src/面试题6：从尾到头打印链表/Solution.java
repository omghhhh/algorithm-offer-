import basicStructure.ListNode;

import java.util.Stack;

/**
 * 栈：先进后出的特点
 */
public class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack<>();
        //把单链表各个节点的大小依次压入栈中
        while(head != null) {
            s.push(head.val);
            head = head.next;
        }
        //初始化数组存放结果
        int[] res = new int[s.size()];
        int i = 0;
        while(!s.isEmpty()) {
            res[i++] = s.pop();
        }
        return res;
    }
}
