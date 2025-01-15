package cdll;

public class CircularDoublyLinkedList {
    private CDLLNode head;
    private CDLLNode tail;

    public void addNodeInBeginning(String data){
        CDLLNode newNode = new CDLLNode(data);
        if(head != null){
            newNode.setNext(head);
            newNode.setPrev(tail);
            head.setPrev(newNode);
            tail.setNext(newNode);
            head = newNode;
        }else{
            head = newNode;
            tail = newNode;
        }
    }

    public void addNodeInEnd(String data){
        CDLLNode newNode = new CDLLNode(data);
        if(tail != null){
            newNode.setPrev(tail);
            newNode.setNext(head);
            tail.setNext(newNode);
            head.setPrev(newNode);
            tail = newNode;
        }else{
            head = newNode;
            tail = newNode;
        }
    }

    public void addNodeInMiddle(String data, int position){
        CDLLNode newNode = new CDLLNode(data);
        if(head != null){
            int currentPosition = 1;
            CDLLNode currentNode = head;
            while(currentPosition < position && currentNode.getNext() != head){
                currentNode = currentNode.getNext();
                currentPosition++;
            }
            newNode.setPrev(currentNode);
            newNode.setNext(currentNode.getNext());
            if(currentNode.getNext() == head){
                tail = newNode;
            }
            currentNode.getNext().setPrev(newNode);
            currentNode.setNext(newNode);
        }else{
            head = newNode;
            tail = newNode;
        }
    }

    public void removeNodeFromBeginning(){
        if(head != null){
            if(head.getNext() != head){
                head = head.getNext();
                tail.setNext(head);
                head.setPrev(tail);
            }else{
                head = null;
                tail = null;
            }
        }
    }

    public void removeNodeFromEnd(){
        if(tail != null){
            if(tail.getNext() != tail){
                tail = tail.getPrev();
                head.setPrev(tail);
                tail.setNext(head);
            }else{
                head = null;
                tail = null;
            }
        }
    }

    public void removeNodeFromMiddle(int position){
        if(head != null){
            if(head.getNext() != head){
                int currentPosition = 1;
                CDLLNode currentNode = head;
                while(currentPosition < position && currentNode.getNext() != head){
                    currentNode = currentNode.getNext();
                    currentPosition++;
                }
                currentNode.getPrev().setNext(currentNode.getNext());
                currentNode.getNext().setPrev(currentNode.getPrev());
                if(tail == currentNode){
                    tail = currentNode.getPrev();
                }
            }else{
                head = null;
                tail = null;
            }
        }
    }

    public String forwardTraversal(){
        String output = "";
        if(head != null){
            CDLLNode currentNode = head;
            while(currentNode.getNext() != head){
                output += currentNode.getData();
                output += "<->";
                currentNode = currentNode.getNext();
            }
            output += currentNode.getData();
        }
        return output;
    }

    public String backwardTraversal(){
        String output = "";
        if(tail != null){
            CDLLNode currentNode = tail;
            while(currentNode.getPrev() != tail){
                output += currentNode.getData();
                output += "<->";
                currentNode = currentNode.getPrev();
            }
            output += currentNode.getData();
        }
        return output;
    }
}
