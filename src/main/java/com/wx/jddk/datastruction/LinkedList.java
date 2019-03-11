package com.wx.jddk.datastruction;

/**
 * @author weixing
 * @date 2019/3/6
 **/
public class LinkedList<E> {

    private int size;

    private Node<E> first;

    private Node<E> last;

    public LinkedList() {
    }

    public void put(Node<E> node) {
        if(first == null) {
            first = node;
            first.next = last;
        } else {
            Node<E> temp = first;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
            node.next = last;
        }
    }

    public void remove(Node<E> node) {
        Node<E> temp = first;
        do {
            if(temp.item.equals(node.item)) {
                if(temp.equals(first)) {
                    first = first.next;
                    first.prev = null;
                } else {
                    temp.next.prev = temp.prev;
                    temp.prev.next = temp.next;
                    break;
                }
            } else {
                temp = temp.next;
            }
        } while(temp.next != null);
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.put(new Node<>(1));
        linkedList.put(new Node<>(2));
        linkedList.put(new Node<>(3));
        linkedList.put(new Node<>(4));
        linkedList.put(new Node<>(5));
        linkedList.remove(new Node<>(3));
    }
}
