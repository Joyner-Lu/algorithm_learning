package com.joyner.algorithm.mashibing_primary.tree;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

import java.util.Stack;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class TraversingTree {

    /**
     * 前序遍历。
     *
     * 1.准备一个栈，先放入根节点。
     * 2.如果栈为非空<br>
     *     2.1. 弹出节点并打印
     *     2.2. 如果有右孩子，先入栈右孩子，如果有左孩子入栈左孩子。
     * 3.重复2的过程
     *
     * @param root
     */
    public void preTraversing(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode popNode = stack.pop();
            System.out.println(popNode.val + " ");
            if (popNode.right != null) {
                stack.push(popNode.right);
            }

            if (popNode.left != null) {
                stack.push(popNode.left);
            }
        }
    }

    /**
     * 中序遍历
     * 1.准备一个栈
     * 2.cur初始指向root,如果cur非空，那么加入栈中，并且让其跟踪root.left.直到左边的都压栈完毕。
     * 3.如果为空，说明左边已经走完了，那么弹出打印，并赋值给cur。  并让cur跟到右边。
     * 4.跟踪到右边之后，又是重复的2的过程（注意：这个时候不需要在设置初始值）。
     *
     * 备注：以左树的视角看待整棵树。
     *
     * @param root
     */
    public void inTraversing(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                //跟踪左孩子
                cur = cur.left;
            } else {
                //左孩子已经是空了，那么就弹出打印父节点
                cur = stack.pop();
                System.out.println(cur.val + " ");
                //父节点已经弹出并打印，那么这个时候，去跟踪右孩子
                cur = cur.right;
            }
        }


    }

    /**
     * 后序遍历
     * 1.按前序进行遍历，不过，我先压入左，在压入右。 这样出来的顺序是。 头，右， 左。
     * 2.把1的结果反过来正好就是后续遍历
     */
    public void postTraversalV1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack();
        Stack<TreeNode> help = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode popNode = stack.pop();
            //System.out.println(popNode.val + " ");
            help.add(popNode);
            if (popNode.left != null) {
                stack.push(popNode.left);
            }
            if (popNode.right != null) {
                stack.push(popNode.right);
            }


        }

        while (!help.isEmpty()) {
            TreeNode pop = help.pop();
            System.out.print(pop.val + " ");
        }
    }


    /**
     * 后序遍历(只用一个栈来实现)
     * 1.准备一个栈，head抓住root。
     * 2.栈不为空，peak元素，给到cur<br>
     *     2.1 如果cur的左孩子不为空，且cur的左孩子不等于head,右孩子不等于head。表明cur的左右孩子都处理过，将左孩子入栈
     *     2.2 没有命中2.1，继续判断，如果cur有右孩子，且右孩子不等于head.说明右孩子没有处理过。将右孩子入栈。
     *     2.3 如果2.1和2.2都没有命中。说明左右孩子都处理过了。该处理自己了。出栈，并且，让head跟踪弹出的元素。
     *
     *     备注：head跟踪上一次弹出的元素。
     */
    public void postTraversalV2(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode head = root;
        TreeNode curr = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (curr.left != null && !curr.left.equals(head) && !head.equals(curr.right)) {
                //左右孩子都没有处理过，先处理左孩子
                stack.push(curr.left);
            } else if (curr.right != null && !curr.right.equals(head)) {
                //左孩子已经处理，右孩子没有处理过
                stack.push(curr.right);
            } else {
                //左右孩子都已经处理了，出栈打印，进入下一轮处理，继续去栈里面peak
                curr = stack.pop();
                System.out.print(curr.val + " ");
                head = curr;
            }


        }

        System.out.println("");




    }





    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(2);
        root.right = new TreeNode(2);

       /* root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(10);*/

        root.right.left = new TreeNode(3);

        TraversingTree traversingTree = new TraversingTree();
        traversingTree.postTraversalV2(root);
        traversingTree.postTraversalV1(root);


    }

}
