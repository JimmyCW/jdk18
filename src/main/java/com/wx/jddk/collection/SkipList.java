package com.wx.jddk.collection;

import java.util.Random;

/**
 * @author weixing
 * @date 2019/3/14
 **/
public class SkipList<T extends Comparable<? super T>> {

    private SkipListNode<T> head, tail;
    private int nodes;
    private int listLevel;
    private Random random;
    private final static double PROBABILITY = 0.5;

    public SkipList() {
        random = new Random();
        clear();
    }

    public void clear() {
        head = new SkipListNode<>(SkipListNode.HEAD_KEY, null);
        tail = new SkipListNode<>(SkipListNode.TAIL_KEY, null);
        horizontalLink(head, tail);
        listLevel = 0;
        nodes = 0;
    }

    private void horizontalLink(SkipListNode<T> node1, SkipListNode<T> node2) {
        node1.right = node2;
        node2.left = node1;
    }

    private void vertiacallLink(SkipListNode<T> node1, SkipListNode<T> node2) {
        node1.down = node2;
        node2.up = node1;
    }

    private SkipListNode findNode(int key) {
        SkipListNode p = head;
        while (true) {
            while (p.right.getKey() != SkipListNode.TAIL_KEY
                    && p.right.getKey() <= key) {
                p = p.right;
            }
            if (p.down != null) {
                p = p.down;
            }
            {
                break;
            }
        }
        return p;
    }

    public SkipListNode search(int key) {
        SkipListNode p = findNode(key);
        return (key == p.getKey()) ? p : null;
    }

    public void put(int k, T v) {
        SkipListNode p = findNode(k);
        if (k == p.key) {
            p.setValue(v);
            return;
        }
        SkipListNode q = new SkipListNode(k, v);
        backLink(p, q);
        int currentLevel = 0;//0层
        while (random.nextDouble() < PROBABILITY) {
            if (currentLevel >= listLevel) {
                listLevel++;
                SkipListNode p1 = new SkipListNode(SkipListNode.HEAD_KEY, null);
                SkipListNode p2 = new SkipListNode(SkipListNode.TAIL_KEY, null);
                horizontalLink(p1, p2);
                vertiacallLink(p1, head);
                vertiacallLink(p2, tail);
                head = p1;
                tail = p2;
            }

            while (p.up != null) {
                p = p.up;
            }
            SkipListNode<T> e = new SkipListNode<T>(k, null);
            backLink(p, e);
            vertiacallLink(e, q);
            q = e;
            currentLevel++;
        }
        nodes++;
    }


    public boolean isEmpty() {
        return nodes == 0;
    }

    public int size() {
        return nodes;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "跳跃表为空";
        }
        StringBuilder builder = new StringBuilder();
        SkipListNode<T> p = head;
        while (p.down != null) {
            p = p.down;
        }
        while (p.left != null) {
            p = p.left;
        }
        if (p.right != null) {
            p = p.right;
        }
        while (p.right != null) {
            builder.append(p);
            builder.append("\n");
            p = p.right;
        }
        return builder.toString();
    }

    /**
     * node1 --> node2
     */
    private void backLink(SkipListNode node1, SkipListNode node2) {
        node2.left = node1;
        node2.right = node1.right;
        node1.right.left = node2;
        node1.right = node2;
    }

    static class SkipListNode<T> {
        private int key;
        private T value;
        public SkipListNode<T> up, down, left, right;
        private static final int HEAD_KEY = Integer.MIN_VALUE;
        private static final int TAIL_KEY = Integer.MAX_VALUE;

        public SkipListNode(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof SkipListNode)) {
                return false;
            }
            SkipListNode ent;
            try {
                ent = (SkipListNode<T>) obj;
            } catch (Exception e) {
                return false;
            }
            return (ent.getKey() == key) && (ent.getValue() == value);
        }

        @Override
        public String toString() {
            return "SkipListNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


    public static void main(String[] args) {
        SkipList<String> skipList = new SkipList();
        System.out.println(skipList);
        skipList.put(2, "he");
        skipList.put(1, "asda");
        skipList.put(3, "qqw");
        skipList.put(4, "qw");
        skipList.put(8, "qwafsa");
        skipList.put(6, "qws");
        skipList.put(7, "qaw");
        skipList.put(5, "qgw");

        System.out.println(skipList);
    }

}
