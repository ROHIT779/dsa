package cdll;

public class CDLLNode {
    private String data;
    private CDLLNode prev;
    private CDLLNode next;

    public CDLLNode(String data){
        this.data = data;
        this.prev = this;
        this.next = this;
    }

    public String getData(){
        return this.data;
    }

    public CDLLNode getNext(){
        return this.next;
    }

    public CDLLNode getPrev(){
        return this.prev;
    }

    public void setNext(CDLLNode next){
        this.next = next;
    }

    public void setPrev(CDLLNode prev){
        this.prev = prev;
    }
}
