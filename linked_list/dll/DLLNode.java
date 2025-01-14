package dll;

public class DLLNode {
    private String data;
    private DLLNode prev;
    private DLLNode next;

    public DLLNode(String data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public String getData(){
        return this.data;
    }

    public DLLNode getNext(){
        return this.next;
    }

    public DLLNode getPrev(){
        return this.prev;
    }

    public void setNext(DLLNode next){
        this.next = next;
    }

    public void setPrev(DLLNode prev){
        this.prev = prev;
    }

}
