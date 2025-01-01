package sll;

public class Main {

    public static void main(String[] args){
        SinglyLinkedList sll = new SinglyLinkedList();
        System.out.println(sll.getSize());
        sll.addNode("1");
        System.out.println(sll.traverse());
        sll.addNode("5");
        System.out.println(sll.traverse());
        sll.addNode("2");
        sll.addNode("4");
        System.out.println(sll.traverse());
        sll.removeNode();
        System.out.println(sll.traverse());
        sll.removeNode();
        sll.removeNode();
        System.out.println(sll.traverse());
        sll.removeNode();
        System.out.println(sll.traverse());
        sll.removeNode();
        System.out.println(sll.traverse());
    }
}
