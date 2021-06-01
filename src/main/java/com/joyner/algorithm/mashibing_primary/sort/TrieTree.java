package com.joyner.algorithm.mashibing_primary.sort;

import com.joyner.algorithm.mashibing_primary.RandomBox;
import com.joyner.algorithm.mashibing_primary.RandomGenerator;
import org.apache.commons.lang3.StringUtils;

/**
 * <pre>
 * 前缀树，也叫字典树(限制只是小写字母)
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class TrieTree {

    class Node {
        public int pass = 0;
        public int end = 0;
        public Node[] next = new Node[26];
    }

    public Node root;

    public TrieTree() {
        root = new Node();
    }

    public void insert(String word) {
        if (StringUtils.isEmpty(word)) {
            return;
        }
        Node tempNode = root;
        //根节点必然要加
        root.pass++;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int idx = c - 'a';
            if (tempNode.next[idx] == null) {
                tempNode.next[idx] = new Node();
            }
            //指向下一个节点
            tempNode = tempNode.next[idx];
            tempNode.pass++;
        }
        tempNode.end++;
    }

    /**
     * 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
     *
     * @param word
     */
    public void delete(String word) {
        if (search(word) == 0) {
            return;
        }
        Node tempNode = root;
        root.pass--;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int idx = c - 'a';
            Node n = tempNode.next[idx];
            n.pass--;
            if (n.pass == 0) {
                //下一个节点经过的字符数为零，则可以清除了。
                tempNode.next[idx] = null;
                return;
            }
            //改变指向
            tempNode = n;
        }
        tempNode.end--;

    }


    /**
     * word这个单词之前加入过几次
     *
     * @param word
     * @return
     */
    public int search(String word) {
        if (StringUtils.isEmpty(word)) {
            return 0;
        }
        Node tempNode = root;

        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int idx = c - 'a';
            if (tempNode.next[idx] == null) {
                return 0;
            }
            //指向下一个节点
            tempNode = tempNode.next[idx];
        }
        return tempNode.end;
    }

    /**
     * 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
     *
     * @param pre
     * @return
     */
    public int prefixNumber(String pre) {
        if (StringUtils.isEmpty(pre)) {
            return 0;
        }
        Node tempNode = root;
        char[] chars = pre.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int idx = c - 'a';
            if (tempNode.next[idx] == null) {
                return 0;
            }
            //指向下一个节点
            tempNode = tempNode.next[idx];
        }
        return tempNode.pass;
    }

    public static void main(String[] args) {
        int testTimes = 100000;
        int maxArrLen = 200;
        int maxStrLen = 100;
        TrieTree trieTree = new TrieTree();

        TrieTreeForTest trieTreeForTest = new TrieTreeForTest();
        for (int i = 0; i < testTimes; i++) {
            String[] strings = RandomGenerator.generateRandomStrArr(maxArrLen, maxStrLen);
            for (int j = 0; j < strings.length; j++) {
                double random = Math.random();
                if (random < 0.25) {
                    //25% 插入
                    trieTree.insert(strings[j]);
                    trieTreeForTest.insert(strings[j]);
                } else if (random < 0.75) {
                    int search = trieTree.search(strings[j]);
                    int search1 = trieTreeForTest.search(strings[j]);
                    if (search1 >= 1) {
                        System.out.println("==============111");
                    }
                    if (search != search1) {
                        throw new RuntimeException("fuck");
                    }
                } else {
                    int search = trieTree.prefixNumber(strings[j]);
                    int search1 = trieTreeForTest.prefixNumber(strings[j]);
                    if (search != search1) {
                        throw new RuntimeException("fuck");
                    }
                }
            }
        }


    }

    private static void test01() {
        TrieTree trieTree = new TrieTree();
     /*   String a = "abc";
        String b = "ad";
        trieTree.insert(a);
        trieTree.insert(b);
        trieTree.delete(a);
        System.out.println(trieTree.search(a));
        System.out.println(trieTree.search(b));*/

        TrieTreeForTest trieTreeForTest = new TrieTreeForTest();
        RandomBox randomBox = new RandomBox(1, 100);
        int testTimes = 1000;
        for (int i = 0; i < testTimes; i++) {
            int randomLen = randomBox.random();
            String randomStr = RandomGenerator.generateRandomStr(randomLen);
            trieTree.insert(randomStr);
            trieTreeForTest.insert(randomStr);

            if (i % 5 == 0) {
                if (trieTree.search(randomStr) != trieTreeForTest.search(randomStr)) {
                    System.out.println(randomStr);
                    throw new RuntimeException("fuck");
                }
                randomStr = RandomGenerator.generateRandomStr(randomLen);
                if (trieTree.search(randomStr) != trieTreeForTest.search(randomStr)) {
                    System.out.println(randomStr);
                    throw new RuntimeException("fuck");
                }
            }

            if (i % 3 == 0) {
                trieTree.delete(randomStr);
                trieTreeForTest.delete(randomStr);
            }


            if (i % 5 == 0) {
                if (trieTree.search(randomStr) != trieTreeForTest.search(randomStr)) {
                    System.out.println(randomStr);
                    throw new RuntimeException("fuck");
                }
                randomStr = RandomGenerator.generateRandomStr(randomLen);
                if (trieTree.prefixNumber(randomStr) != trieTreeForTest.prefixNumber(randomStr)) {
                    System.out.println(randomStr);
                    throw new RuntimeException("fuck");
                }

            }
        }
    }
}
