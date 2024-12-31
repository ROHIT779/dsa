package sll;

public class SinglyLinkedListNode {
    private String data;
    private SinglyLinkedListNode nextNode;

    public SinglyLinkedListNode(String data){
        this.data = data;
        this.nextNode = null;
    }

    public String getData(){
        return this.data;
    }

    public SinglyLinkedListNode getNextNode(){
        return this.nextNode;
    }

    public void setNextNode(SinglyLinkedListNode node){
        this.nextNode = node;
    }
}
