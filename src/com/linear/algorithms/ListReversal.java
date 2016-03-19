package com.linear.algorithms;

/**
 * Created by Jerry on 3/19/16.
 */

class ListNode {
   int value;
   ListNode next;

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

public class ListReverser {

    static ListNode reverse(ListNode node) {
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

    static void print(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode p;
        p = node;
        while ( p != null) {
            System.out.print(p.value + " >>> ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        final ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        print(node);
        print(reverse(node));
    }
}
