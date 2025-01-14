package csll;

public class CircularSinglyLinkedList {
    CSLLNode head;

    public void addNodeInBeginning(String data){
        CSLLNode newNode = new CSLLNode(data);
        if(head != null){
            newNode.setNextNode(head);
            CSLLNode currentNode = head;
            while(currentNode.getNextNode() != head){
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
            head = newNode;
        }else{
            head = newNode;
        }
    }

    public void addNodeAtTheEnd(String data){
        CSLLNode newNode = new CSLLNode(data);
        if(head != null){
            CSLLNode currentNode = head;
            while(currentNode.getNextNode() != head){
                currentNode = currentNode.getNextNode();
            }
            newNode.setNextNode(head);
            currentNode.setNextNode(newNode);
        }else{
            head = newNode;
        }
    }

    public void addNodeInMiddle(String data, int position){
        CSLLNode newNode = new CSLLNode(data);
        if(head != null){
            int currentPosition = 1;
            CSLLNode currentNode = head;
            while(currentPosition < position && currentNode.getNextNode() != head){
                currentNode = currentNode.getNextNode();
                currentPosition++;
            }
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
        }else{
            head = newNode;
        }
    }

    public void removeNodeFromBeginning(){
        if(head != null){
            if(head.getNextNode() != head){
                CSLLNode previousHead = head;
                head = head.getNextNode();
                CSLLNode currentNode = head;
                while(currentNode.getNextNode() != previousHead){
                    currentNode = currentNode.getNextNode();
                }
                currentNode.setNextNode(head);
            }else{
                head = null;
            }
        }
    }

    public void removeNodeFromEnd(){
        if(head != null){
            if(head.getNextNode() != head){
                CSLLNode currentNode = head;
                while(currentNode.getNextNode().getNextNode() != head){
                    currentNode = currentNode.getNextNode();
                }
                currentNode.getNextNode().setNextNode(null);
                currentNode.setNextNode(head);
            }else{
                head = null;
            }
        }
    }

    public void removeNodeFromMiddle(int position){
        if(head != null){
            if(head.getNextNode() != head){
                int currentPosition = 1;
                CSLLNode currentNode = head;
                while(currentPosition < (position-1) && currentNode.getNextNode() != head){
                    currentNode = currentNode.getNextNode();
                    currentPosition++;
                }
                currentNode.setNextNode(currentNode.getNextNode().getNextNode());
            }else{
                head = null;
            }
        }
    }

    public String traverse(){
        String output = "";
        if(head != null){
            if(head.getNextNode() != head){
                CSLLNode currentNode = head;
                while(currentNode.getNextNode() != head){
                    output += currentNode.getData();
                    output += "->";
                    currentNode = currentNode.getNextNode();
                }
                output += currentNode.getData();
            }else{
                output += head.getData();
            }
        }
        return output;
    }
}
