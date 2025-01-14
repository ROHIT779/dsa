package csll;

public class CSLLNode {
    private String data;
    private CSLLNode nextNode;

    public CSLLNode(String data){
        this.data = data;
        this.nextNode = this;
    }

    public String getData(){
        return this.data;
    }

    public CSLLNode getNextNode(){
        return this.nextNode;
    }

    public void setNextNode(CSLLNode node){
        this.nextNode = node;
    }
}
