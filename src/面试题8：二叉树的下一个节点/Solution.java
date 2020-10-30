import basicStructure.TreeNode;

public class Solution {
    public TreeNode getNext(TreeNode node) {
        if(node == null) {
            return null;
        }
        TreeNode next = null;
        //第一种情况：该节点的右子树不为空，则他的下一节点就在右子树的最左侧节点
        if(node.rTreeNode != null) {
            TreeNode rNode = node.rTreeNode;
            while(rNode != null) {
                rNode = rNode.lTreeNode;
            }
            next = rNode;
            return next;
        }else if (node.pTreeNode != null) {
            TreeNode currentNode = node;
            TreeNode parentNode = node.pTreeNode;
            //第二种情况：该节点是它父节点的左节点，则它的下一个节点就是父节点
            //第三种情况：该节点为它父节点的右节点，则向上遍历至某一结点为它父节点的左子节点，则这个父节点为所求节点的下一个节点
            while(parentNode != null && currentNode == parentNode.rTreeNode) {
                currentNode = parentNode;
                parentNode = currentNode.pTreeNode;
            }
            next = parentNode;
        }
        return next;
    }
}
