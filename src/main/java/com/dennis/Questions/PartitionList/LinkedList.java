package com.dennis.Questions.PartitionList;
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
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
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

    public void partitionList(int x) {
        if (head == null) {
            return;
        }

        // İki ayrı dummy node oluşturuyoruz
        Node lessHead = new Node(0);
        Node greaterHead = new Node(0);

        // Bu dummy node'ları takip edecek pointerlar
        Node less = lessHead;
        Node greater = greaterHead;

        // Orijinal linked list'te dolaşmak için bir pointer
        Node current = head;

        // Tüm linked list'i dolaşıyoruz
        while (current != null) {
            if (current.value < x) {
                // x'ten küçük olan değerler less zincirine eklenir
                less.next = current;
                less = less.next;
            } else {
                // x'ten büyük veya eşit olan değerler greater zincirine eklenir
                greater.next = current;
                greater = greater.next;
            }
            current = current.next;
        }

        // Greater zincirinin sonunu belirliyoruz
        greater.next = null;

        // İki zinciri birleştiriyoruz
        less.next = greaterHead.next;

        // Head'i güncelliyoruz
        head = lessHead.next;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(3);
        linkedList.append(8);
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(2);
        linkedList.append(1);

        System.out.println("Before partition:");
        linkedList.printAll();

        linkedList.partitionList(5);

        System.out.println("After partition:");
        linkedList.printAll();
    }

}


