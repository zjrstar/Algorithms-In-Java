package com.linear.algorithms;

/**
 * Created by Jerry on 3/19/16.
 */
class SingleListNode {
   int value;
   SingleListNode next;

    public SingleListNode(int value, SingleListNode next) {
        this.value = value;
        this.next = next;
    }
}

class DoubleListNode {
    int value;
    DoubleListNode prev;
    DoubleListNode next;

    public DoubleListNode(int value) {
        this.value = value;
    }

    public void setPrev(DoubleListNode prev) {
        this.prev = prev;
    }

    public void setNext(DoubleListNode next) {
        this.next = next;
    }

    public DoubleListNode getPrev() {
        return prev;
    }

    public DoubleListNode getNext() {
        return next;
    }
}


public class ListReversal {

    static SingleListNode singleReverse(SingleListNode node) {
        if (node == null) {
            return node;
        }

        SingleListNode current, p;
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

    static DoubleListNode doubleReverse(DoubleListNode node) {
        if (node == null) {
            return node;
        }

        DoubleListNode current = node;
        DoubleListNode p;

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

    static void print(SingleListNode node) {
        if (node == null) {
            return;
        }
        SingleListNode p = node;
        while ( p != null) {
            System.out.print(p.value + " >>> ");
            p = p.next;
        }
        System.out.println();
    }

    static void print(DoubleListNode node) {
        if (node == null) {
            return;
        }
        DoubleListNode p = node;
        while ( p != null) {
            System.out.print(p.value + " >>> ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        final SingleListNode node = new SingleListNode(1, new SingleListNode(2, new SingleListNode(3, new SingleListNode(4, null))));
        print(node);
        print(singleReverse(node));

        final DoubleListNode n1 = new DoubleListNode(1);
        final DoubleListNode n2 = new DoubleListNode(2);
        final DoubleListNode n3 = new DoubleListNode(3);
        final DoubleListNode n4 = new DoubleListNode(4);

        n1.setNext(n2);

        n2.setPrev(n1);
        n2.setNext(n3);

        n3.setPrev(n2);
        n3.setNext(n4);

        n4.setPrev(n3);

        print(n1);
        print(doubleReverse(n1));

    }
}
