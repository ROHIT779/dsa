package sll;

public class SinglyLinkedList {
    private SinglyLinkedListNode head;

    public SinglyLinkedList(){

    }

    public int getSize(){
        if(head == null){
            return 0;
        }else{
            SinglyLinkedListNode currentNode = head;
            int size = 0;
            while(currentNode != null){
                size++;
                currentNode = currentNode.getNextNode();
            }
            return size;
        }
    }
    public void addNode(String data){
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        int size = getSize();
        if(size == 0){
            head = newNode;
        }else if(size > 0){
            SinglyLinkedListNode currentNode = head;
            while(currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }

    public String traverse(){
        String output = "";
        SinglyLinkedListNode currentNode = head;
        while(currentNode != null){
            output += currentNode.getData();
            if(currentNode.getNextNode() != null){
                output += "->";
            }
            currentNode = currentNode.getNextNode();
        }
        return output;
    }
}
