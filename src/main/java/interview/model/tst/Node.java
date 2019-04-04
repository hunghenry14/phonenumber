package interview.model.tst;

public class Node {
    private NodeData data;
   
    private boolean isEnd;
    private Node middle;
    private Node left;
    private Node right;
    
    public Node(NodeData data) {
        this.data = data;
    }
    
    public NodeData getData() {
        return data;
    }

    public void setData(NodeData data) {
        this.data = data;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }
    public Node getMiddle() {
        return middle;
    }
    public void setMiddle(Node middle) {
        this.middle = middle;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
}
