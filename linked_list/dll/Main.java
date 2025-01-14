package dll;

import sll.SinglyLinkedList;

public class Main {

    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addNodeInBeginning("1");
        dll.addNodeAtEnd("4");
        System.out.println(dll.forwardTraversal());
        System.out.println(dll.backwardTraversal());
        dll.addNodeInMiddle("3", 1);
        dll.addNodeInMiddle("2", 1);
        System.out.println(dll.forwardTraversal());
        System.out.println(dll.backwardTraversal());
        dll.removeNodeFromEnd();
        System.out.println(dll.forwardTraversal());
        System.out.println(dll.backwardTraversal());
        dll.removeNodeFromBeginning();
        System.out.println(dll.forwardTraversal());
        System.out.println(dll.backwardTraversal());
        dll.removeNodeFromMiddle(2);
        System.out.println(dll.forwardTraversal());
        System.out.println(dll.backwardTraversal());
    }
}
