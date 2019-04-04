package interview.model.sortedtree;

import interview.model.Validity;

public class Node {
    private Node left;

    private Node right;

    private Validity data;

    public Node(Validity data) {
        this.data = data;
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

    public Validity getData() {
        return data;
    }

    public void setData(Validity data) {
        this.data = data;
    }

}
