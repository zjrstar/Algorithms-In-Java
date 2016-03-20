package com.linear.algorithms;

/**
 * Created by Jerry on 3/19/16.
 */

class ListNode<E> {
    E value;
    ListNode<E> prev;
    ListNode<E> next;

    public ListNode(E value) {
        this.value = value;
    }

    public ListNode(E value, ListNode<E> next) {
        this.value = value;
        this.next = next;
    }

    public ListNode(E value, ListNode<E> prev, ListNode<E> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }

    public void setPrev(ListNode<E> prev) {
        this.prev = prev;
    }
}


public class ListReversal {

    static ListNode singleReverse(ListNode node) {
        if (node == null) {
            return node;
        }

        ListNode current, p;
        current = node;
        //当前的元素还有后继
        while (current.next != null) {
            //p指向当前元素的后继元素
            p = current.next;
            //当前的元素指向后继元素的指向
            current.next = p.next;
            //后继元素指向链表头,使连表头成为第二个元素
            p.next = node;
            //链表头成为最开始的后继元素,current自然成为了第二个元素
            node = p;
        }
        return node;
    }

    static ListNode doubleReverse(ListNode node) {
        if (node == null) {
            return node;
        }

        ListNode current = node;
        ListNode p;

        while(null != current)
        {

            p = current.next;
            //当前节点的next指向prev
            current.next = current.prev;
            //当前节点的前继指向原来的下一个元素
            current.prev = p;
            if(null == p)
            {
                node = current;
            }
            //当前节点向下移动一个
            current = p;
        }
        return node;
    }

    static void print(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode p = node;
        while ( p != null) {
            System.out.print(p.value + " >>> ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        final ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        System.out.println("Single List Reverse");
        print(node);
        print(singleReverse(node));

        System.out.println("Double List Reverse");
        final ListNode n1 = new ListNode(1, null, null);
        final ListNode n2 = new ListNode(2, n1, null);
        final ListNode n3 = new ListNode(3, n2, null);
        final ListNode n4 = new ListNode(4, n3, null);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setPrev(n3);

        print(n1);
        print(doubleReverse(n1));

    }
}
