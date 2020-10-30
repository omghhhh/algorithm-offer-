import basicStructure.TreeNode;

public class Solution {
    /**
     * 验证题目给出的两个参数数组是否能够进行重建二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    /**
     * 二叉树每一个节点的子节点又是一个二叉树，所以可以进行递归的构建，重点是要找到每一个二叉树的顶点
     * @param preorder
     * @param s1
     * @param e1
     * @param inorder
     * @param s2
     * @param e2
     * @return
     */
    private TreeNode buildTree(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if(s1 > e1 || s2 > e2) {
            return null;
        }
        int index = findIndex(inorder, s2, e2, preorder[s1]);
        TreeNode tree = new TreeNode(preorder[s1]);
        tree.lTreeNode = buildTree(preorder, s1+1, index-s2+s1, inorder, s2, index-1);
        tree.rTreeNode = buildTree(preorder, index-s2+s1+1, e1, inorder, index+1, e2);
        return tree;
    }

    /**
     * 二叉树前序与中序遍历的关系，在中序中找到与前序的第一个值相等的值，这个值左边就是此节点的左子树，右边就是此节点的右子树
     * @param order
     * @param s
     * @param e
     * @param val
     * @return
     */
    private int findIndex(int[] order, int s, int e, int val) {
        for(int i = s; i <= e; i++) {
            if(order[i] == val)
                return i;
        }
        return -1;
    }
}
