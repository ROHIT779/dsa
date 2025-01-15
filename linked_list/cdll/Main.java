package cdll;

public class Main {

    public static void main(String[] args){
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();
        cdll.addNodeInBeginning("1");
        System.out.println(cdll.forwardTraversal());
        System.out.println(cdll.backwardTraversal());
        cdll.addNodeInEnd("4");
        System.out.println(cdll.forwardTraversal());
        System.out.println(cdll.backwardTraversal());
        cdll.addNodeInMiddle("3", 1);
        System.out.println(cdll.forwardTraversal());
        System.out.println(cdll.backwardTraversal());
        cdll.addNodeInMiddle("2", 1);
        System.out.println(cdll.forwardTraversal());
        System.out.println(cdll.backwardTraversal());
        cdll.removeNodeFromEnd();
        System.out.println(cdll.forwardTraversal());
        System.out.println(cdll.backwardTraversal());
        cdll.removeNodeFromBeginning();
        System.out.println(cdll.forwardTraversal());
        System.out.println(cdll.backwardTraversal());
        cdll.removeNodeFromMiddle(2);
        System.out.println(cdll.forwardTraversal());
        System.out.println(cdll.backwardTraversal());
        cdll.addNodeInBeginning("1");
        cdll.addNodeInEnd("3");
        System.out.println(cdll.forwardTraversal());
        System.out.println(cdll.backwardTraversal());
        cdll.removeNodeFromMiddle(2);
        System.out.println(cdll.forwardTraversal());
        System.out.println(cdll.backwardTraversal());
    }
}
