package com.dennis.Questions.BinaryToDecimal;

public class LinkedList {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        if (temp == null) {
            System.out.println("empty");
        } else {
            while (temp != null) {
                System.out.print(temp.value);
                temp = temp.next;
                if (temp != null) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    public int binaryToDecimal() {

        int num = 0;

        Node current = head;

        int size = 0;

        while (current != null) {
            current = current.next;
            size++;
        }

        current = head;
        int counter = size;

        for (int i = size; size >= 0; i--) {
            if(current != null) {
                num += Math.pow(2, size - 1) * current.value;
                current = current.next;
            }
            size--;
        }

        return num;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(0);
        linkedList.append(1);
        linkedList.append(1);

        System.out.println(linkedList.binaryToDecimal());
    }

}



