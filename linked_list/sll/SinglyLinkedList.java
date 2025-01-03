package sll;

import java.util.ArrayList;
import java.util.List;

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

    public void removeNode(){
        if(head != null) {
            SinglyLinkedListNode previousNode = head;
            SinglyLinkedListNode nextNode = head.getNextNode();
            if(nextNode == null){
                head = null;
            }else{
                while(nextNode.getNextNode() != null){
                    previousNode = previousNode.getNextNode();
                    nextNode = nextNode.getNextNode();
                }
                previousNode.setNextNode(null);
            }
        }
    }

    public void addNodeInBeginning(String data){
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if(head == null){
            head = newNode;
        }else{
            newNode.setNextNode(head);
            head = newNode;
        }
    }

    public void removeNodeFromBeginning(){
        if(head != null){
            head = head.getNextNode();
        }
    }

    public void addNodeInMiddle(String data, int position){
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if(head != null){
            int currentPosition = 1;
            SinglyLinkedListNode currentNode = head;
            while((currentNode.getNextNode() != null) && ((currentPosition +1) < position)){
                currentNode = currentNode.getNextNode();
                currentPosition++;
            }
            if((currentPosition+1) == position){
                SinglyLinkedListNode tempNode = currentNode.getNextNode();
                currentNode.setNextNode(newNode);
                newNode.setNextNode(tempNode);
            }
        }else{
            if(position == 1){
                head = newNode;
            }
        }
    }

    public void removeNodeFromMiddle(int position){
        if(head != null){
            int currentPosition = 1;
            SinglyLinkedListNode currentNode = head;
            while(((currentNode.getNextNode() != null)) && ((currentPosition+1) < position)){
                currentNode = currentNode.getNextNode();
            }
            if((currentPosition+1) == position){
                if(currentNode.getNextNode() != null){
                    SinglyLinkedListNode newNextNode = currentNode.getNextNode().getNextNode();
                    currentNode.setNextNode(newNextNode);
                }
            }
        }
    }

    public int searchData(String data){
        if(head != null){
            int position = 1;
            SinglyLinkedListNode currentNode = head;
            while((currentNode.getNextNode() != null)){
                if(currentNode.getData().equals(data)){
                    return position;
                }else{
                    currentNode = currentNode.getNextNode();
                    position++;
                }
            }
            if(currentNode.getNextNode() == null){
                if(currentNode.getData().equals(data)){
                    return position;
                }else{
                    return 0;
                }
            }
        }
        return 0; // data not found
    }

    public String mergeData(){
        String result = "";
        if(head != null){
            SinglyLinkedListNode currentNode = head;
            while(currentNode != null){
                result += currentNode.getData();
                currentNode = currentNode.getNextNode();
            }
        }
        return result;
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
