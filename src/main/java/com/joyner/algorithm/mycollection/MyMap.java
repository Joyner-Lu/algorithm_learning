package com.joyner.algorithm.mycollection;

import com.joyner.algorithm.mashibing_primary.RandomGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;

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
public class MyMap<K,V> implements Map<K,V> {


    private int size = 0;
    private Object[] entries = new Object[10000];


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        throw new RuntimeException("未实现");
    }

    @Override
    public boolean containsValue(Object value) {
        throw new RuntimeException("未实现");
    }

    @Override
    public V get(Object key) {
        int index = getIndex(key);
        Object entry = entries[index];
        if (entry == null) {
            return null;
        }
        if (entry instanceof MyEntry) {
            MyEntry<K, V> myEntry = (MyEntry)entry;
            if (!myEntry.getK().equals(key)) {
                return null;
            }
            return myEntry.getV();
        } else {
            //处理链表
            LinkedList<MyEntry<K, V>> linkedList = (LinkedList) entry;
            Object[] objects = linkedList.toArray();
            for (int i = 0; i < objects.length; i++) {
                MyEntry<K, V> myEntry = (MyEntry<K, V>)objects[i];
                if (myEntry.getK().equals(key)) {
                    return myEntry.getV();
                }
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if(size == entries.length) {
            throw new RuntimeException("容量已满");
        }
        size++;
        int index = getIndex(key);
        Object entry = entries[index];
        if (entry == null) {
            //直接设值
            entries[index] = new MyEntry<>(key, value);
            return value;
        }

        //非覆盖，使用链表
        if (entry instanceof MyEntry) {
            MyEntry<K, V> myEntry = (MyEntry)entry;

            K k = myEntry.getK();
            if (key.equals(k)) {
                //覆盖
                myEntry.setV(value);
                return value;
            }

            //非覆盖，则使用链表替代
            LinkedList linkedList = new LinkedList();
            linkedList.add(entry);
            linkedList.add(new MyEntry<>(key, value));
            entries[index] = linkedList;
            return value;
        } else if (entry instanceof LinkedList) {
            LinkedList linkedList = (LinkedList)entry;
            linkedList.add(new MyEntry<>(key, value));
            return value;
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = getIndex(key);
        Object entry = entries[index];
        if (entry == null) {
            return null;
        }

        if (entry instanceof MyEntry) {
            MyEntry<K, V> myEntry = (MyEntry)entry;
            if (!myEntry.getK().equals(key)) {
                return null;
            }
            //置空
            entries[index] = null;

            return myEntry.getV();
        } else {
            //处理链表
            LinkedList<MyEntry<K, V>> linkedList = (LinkedList) entry;
            Object[] objects = linkedList.toArray();
            for (int i = 0; i < objects.length; i++) {
                MyEntry<K, V> myEntry = (MyEntry<K, V>)objects[i];
                if (myEntry.getK().equals(key)) {
                    //删除
                    linkedList.remove(myEntry);
                    return myEntry.getV();
                }
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        this.size = 0;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    /**
     * 散列函数
     *
     * @param k
     * @return
     */
    public int myHashFunc(Object k) {
        String s = k.toString();
        char[] chars = s.toCharArray();
        int seed = 0;
        for (int i = 0; i < chars.length; i++) {
            seed += chars[i];
        }

        seed = seed << 5;
        seed = seed + 1024;

        return seed;
    }

    /**
     * 获取数组索引
     *
     * @param k
     * @return
     */
    public int getIndex(Object k) {
        return myHashFunc(k) % entries.length;
    }

    public static void main(String[] args) {

        //dizsjbiknqvgicehxzsr
        //kuylhrqkppqvsgbfbnfl


        MyMap<String, String> my = new MyMap<String, String>();
        System.out.println(my.getIndex("dizsjbiknqvgicehxzsr"));
        System.out.println(my.getIndex("kuylhrqkppqvsgbfbnfl"));

        HashMap<String, String> map = new HashMap<String, String>();
        int times = 10000;
        for (int i = 0; i < times; i++) {
            String kv = RandomGenerator.generateRandomStr(20);
            Random random = new Random();
            int i1 = random.nextInt();
            if (i1 < 30) {
                //插入
                my.put(kv, kv);
                map.put(kv,kv);
            } else if (i1 >= 30 && i1 < 70) {
                Object o = my.get(kv);
                Object o1 = map.get(kv);
                if ((o == null && o1 != null) || (o1 == null && o != null)) {
                    throw new RuntimeException("funck you!");
                } else if (o != null && !o.equals(o1)) {
                    throw new RuntimeException("funck you!");
                }

            } else {
                my.remove(kv);
                map.remove(kv);
            }
        }

    }


}

@Data
@AllArgsConstructor
class MyEntry<K,V> {

    K k;
    V v;
}


