package com.joyner.algorithm.mashibing_primary.sort;

import com.joyner.algorithm.mashibing_primary.RandomBox;
import com.joyner.algorithm.mashibing_primary.RandomGenerator;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

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
public class TrieTreeV2 {

    class Node {
        public int pass = 0;
        public int end = 0;
        public char c;
        public Map<Integer, Node> nexts = new HashMap<>();
    }

    public Node root;

    public TrieTreeV2() {
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
            int cVal = chars[i];
            Node newNode = tempNode.nexts.get(cVal);
            if (newNode == null) {
                newNode = new Node();
                newNode.c = chars[i];
                tempNode.nexts.put(cVal, newNode);
            }
            //指向下一个节点
            tempNode = newNode;
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
            int cVal = chars[i];
            Node n = tempNode.nexts.get(cVal);
            n.pass--;
            if (n.pass == 0) {
                //下一个节点经过的字符数为零，则可以清除了。
                tempNode.nexts.remove(cVal);
                return;
            }
            //改变指向
            tempNode = n;
        }
        tempNode.end--;

    }

    public void printTrieTree() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int nodeCount = 1;//总节点数时1
        int nextNodeCount = 0;
        int count = 0;
        boolean isFirst = true;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.print("[char:" + poll.c + ", pass:" + poll.pass + " , end: " + poll.end + "]    ");
            count++;

            nextNodeCount += poll.nexts.size();
            if (count == nodeCount) {
                //打印下一行
                System.out.println();
                System.out.println();
                nodeCount = nextNodeCount;
                nextNodeCount = 0;
                count = 0;
            }

            Map<Integer, Node> nexts = poll.nexts;
            Collection<Node> values = nexts.values();
            Iterator<Node> iterator = values.iterator();
            while (iterator.hasNext()) {
                Node next = iterator.next();
                queue.offer(next);
            }
        }


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
            int cVal = chars[i];
            Node node = tempNode.nexts.get(cVal);
            if (node == null) {
                return 0;
            }
            //指向下一个节点
            tempNode = node;
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
            int cVal = chars[i];
            Node node = tempNode.nexts.get(cVal);
            if (node == null) {
                return 0;
            }
            //指向下一个节点
            tempNode = node;
        }
        return tempNode.pass;
    }

    public static void main(String[] args) {
        TrieTreeV2 trieTree = new TrieTreeV2();
        trieTree.insert("ab");
        trieTree.insert("ab");
        trieTree.insert("st");
        trieTree.insert("stabc");
        trieTree.insert("stabcd");
        trieTree.printTrieTree();

        System.out.println(trieTree.search("ab"));
        trieTree.delete("ab");
        System.out.println(trieTree.search("ab"));
        System.out.println(trieTree.prefixNumber("sta"));

        if (1 == 1) {
            return;
        }



        int testTimes = 100000;
        int maxArrLen = 200;
        int maxStrLen = 100;

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
                        //System.out.println("==============111");
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
        TrieTreeV2 trieTree = new TrieTreeV2();
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
