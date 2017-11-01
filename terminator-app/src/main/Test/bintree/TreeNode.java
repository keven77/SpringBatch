package bintree;


/**
 * @version V1.0
 * @Author pengbo
 * @Title: 二叉树相关基础
 * @date 10:20 2017/11/1
 */

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    /**
     * 最大深度
     *
     * @param node
     * @return
     */
    int maxDeath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDeath(node.left);
        int right = maxDeath(node.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 最小深度
     *
     * @param node
     * @return
     */
    int minDeath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return this.getMin(node);
    }

    int getMin(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }

    /**
     * 节点总数
     *
     * @param node
     * @return
     */
    int numOfNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = numOfNode(node.left);
        int right = numOfNode(node.right);
        return left + right + 1;
    }

    /**
     * 叶子结点总数
     *
     * @param node
     * @return
     */
    int numOfNoChildNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = numOfNoChildNode(node.left);
        int right = numOfNoChildNode(node.right);
        if (node.left == null && node.right == null) {
            return left + right + 1;
        }
        return 0;
    }

    /**
     * 第k层节点数
     *
     * @param node
     * @param k
     * @return
     */
    int numofLevelNode(TreeNode node, int k) {
        if (node == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int left = numofLevelNode(node.left, k - 1);
        int right = numofLevelNode(node.right, k - 1);
        return left + right;
    }
}

