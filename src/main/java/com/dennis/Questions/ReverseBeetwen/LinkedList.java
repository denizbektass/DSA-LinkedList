package com.dennis.Questions.ReverseBeetwen;
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

    public void reverseBetween(int m, int n) {
        if (m == n) {
            return; // Eğer m ve n aynıysa ters çevirmeye gerek yok
        }

        // Adım 1: Başlangıç indeksinin hemen öncesindeki düğüme ulaş
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        for (int i = 0; i < m; i++) {
            prev = prev.next;
        }
        // Adım 2: m ve n arasındaki segmenti ters çevir
        Node current = prev.next;
        Node next = null;
        Node tail = current;
        for (int i = 0; i < n - m + 1; i++) {
            next = current.next;
            current.next = prev.next;
            prev.next = current;
            current = next;
        }

        // Adım 3: Ters çevrilen segmenti tekrar listeye bağla
        tail.next = current;

        // Eğer m 0 ise, listenin başını yeniden ayarla
        if (m == 0) {
            head = prev.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        System.out.println("Orijinal Liste:");
        list.printAll();

        list.reverseBetween(1, 3);

        System.out.println("\n1 ve 3 arasını ters çevirdikten sonra:");
        list.printAll();
    }

}
