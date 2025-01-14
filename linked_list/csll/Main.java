package csll;

import csll.CircularSinglyLinkedList;

public class Main {

    public static void main(String[] args){
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.addNodeAtTheEnd("4");
        csll.addNodeInBeginning("1");
        System.out.println(csll.traverse());
        csll.addNodeInMiddle("2", 1);
        System.out.println(csll.traverse());
        csll.addNodeInMiddle("3", 2);
        System.out.println(csll.traverse());
        csll.removeNodeFromBeginning();
        System.out.println(csll.traverse());
        csll.removeNodeFromEnd();
        System.out.println(csll.traverse());
        csll.removeNodeFromMiddle(2);
        System.out.println(csll.traverse());
        csll.removeNodeFromMiddle(1);
        System.out.println(csll.traverse());
    }
}
