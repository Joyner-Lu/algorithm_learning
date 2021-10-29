package com.joyner.algorithm.mashibing_primary.tree;

/**
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开。此时折痕是凹下去的，即折痕突起的方向指向纸条的背面。 如果从纸条的下边向上方连续对折2次，压出折痕后展开，此时有三条折痕，从上到下依次是下折痕、下折痕和上折痕。
 * 给定一个输入参数N，代表纸条都从下边向上方连续对折N次。 请从上到下打印所有折痕的方向。
 * @author test
 * 例如:N=1时，打印: down N=2时，打印: down down up
 *
 * 备注：对折之后其实是一棵树。 这个树的特点是，跟节点是凹折痕，左孩子是凹折痕，右孩子是凸折痕。
 * 每个子树都是的左孩子都是凹折痕，右孩子是凸折痕。
 *
 * 所以我们只要对这棵树进行中序遍历即可。
 */
public  class PaperFolding {

    /**
     *
     *
     *
     * @param n 对折的次数
     */
    public void print(int n) {

        printHelp(1, n, true);
        System.out.println();

    }

    /**
     *
     * @param level 当前的层级
     * @param n 对照的次数
     * @param isConcave true代表是凹折痕
     */
    private void printHelp(int level, int n, boolean isConcave) {
        if(level > n) {
            return;
        }
        //先去处理左孩子
        printHelp(level + 1, n, true);
        System.out.print(isConcave ? "凹" : "凸");
        printHelp(level + 1, n, false);
    }

    public static void main(String[] args) {
        PaperFolding paperFolding = new PaperFolding();
        paperFolding.print(3);
    }

}