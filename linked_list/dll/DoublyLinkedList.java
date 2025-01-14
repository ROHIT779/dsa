package dll;

public class DoublyLinkedList {
    private DLLNode head;
    private DLLNode tail;

    public void addNodeInBeginning(String data){
        DLLNode newNode = new DLLNode(data);
        if(head != null){
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }else{
            head = newNode;
            tail = newNode;
        }
    }

    public void addNodeAtEnd(String data){
        DLLNode newNode = new DLLNode(data);
        if(tail != null){
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }else{
            head = newNode;
            tail = newNode;
        }
    }

    //edge cases need to be handled
    public void addNodeInMiddle(String data, int position){
        DLLNode newNode = new DLLNode(data);
        if(head != null){
            int currentPosition = 1;
            DLLNode currentNode = head;
            while(currentPosition < position && currentNode.getNext() != null){
                currentPosition++;
                currentNode = currentNode.getNext();
            }
            newNode.setPrev(currentNode);
            newNode.setNext(currentNode.getNext());
            currentNode.getNext().setPrev(newNode);
            currentNode.setNext(newNode);
        }else{
            head = newNode;
            tail = newNode;
        }
    }

    public void removeNodeFromBeginning(){
        if(head != null){
            head = head.getNext();
            head.setPrev(null);
        }
    }

    public void removeNodeFromEnd(){
        if(tail != null){
            tail = tail.getPrev();
            tail.setNext(null);
        }
    }

    public void removeNodeFromMiddle(int position){
        if(head != null){
            int currentPosition = 1;
            DLLNode currentNode = head;
            while(currentPosition <= position && currentNode.getNext() != null){
                currentPosition++;
                currentNode = currentNode.getNext();
            }
            if(currentNode.getPrev() != null){
                currentNode.getPrev().setNext(currentNode.getNext());
            }else{
                head = null;
                tail = null;
            }
            if(currentNode.getNext() != null){
                currentNode.getNext().setPrev(currentNode.getPrev());
            }else{
                tail = currentNode.getPrev();
            }
        }
    }

    public String forwardTraversal(){
        String output = "";
        if(head != null){
            DLLNode currentNode = head;
            while(currentNode != null){
                output += currentNode.getData();
                if(currentNode.getNext() != null){
                    output += "<->";
                }
                currentNode = currentNode.getNext();
            }
        }
        return output;
    }

    public String backwardTraversal(){
        String output = "";
        if(tail != null){
            DLLNode currentNode = tail;
            while(currentNode != null){
                output += currentNode.getData();
                if(currentNode.getPrev() != null){
                    output += "<->";
                }
                currentNode = currentNode.getPrev();
            }
        }
        return output;
    }
}
