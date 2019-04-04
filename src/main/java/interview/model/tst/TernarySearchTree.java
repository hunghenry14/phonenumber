package interview.model.tst;

import interview.io.Output;
import interview.model.PhoneData;
import interview.model.Validity;

public class TernarySearchTree {
    private Node root = null;

    public void insertOrUpdate(String phoneNumber, Validity validity) {
        root = insertOrUpdate(root, phoneNumber.toCharArray(), validity, 0);
    }

    public void insertOrUpdate(PhoneData data) {
        insertOrUpdate(data.getPhoneNumber(), data.getValidity());
    }

    public Node insertOrUpdate(Node node, char[] phoneNumber, Validity validity, int index) {
        char key = phoneNumber[index];
        if (node == null) {
            node = new Node(new NodeData(key));
        }

        if (key < node.getData().getDigit()) {
            node.setLeft(insertOrUpdate(node.getLeft(), phoneNumber, validity, index));
        } else if (key > node.getData().getDigit()) {
            node.setRight(insertOrUpdate(node.getRight(), phoneNumber, validity, index));
        } else {
            if (index + 1 < phoneNumber.length) {
                node.setMiddle(insertOrUpdate(node.getMiddle(), phoneNumber, validity, index + 1));
            } else {
                node.getData().add(validity);
                node.setEnd(true);
            }
        }
        return node;
    }

    private void printTree(Node node, StringBuilder builder, Output out) {
        if(node == null) {
            return;
        }
        printTree(node.getLeft(), new StringBuilder(builder.toString()), out);

        StringBuilder rightBuilder = new StringBuilder(builder.toString());
        builder.append(node.getData().getDigit());
        if (node.isEnd()) {
            out.write(new PhoneData(builder.toString(), node.getData().getValidity()));
        }

        printTree(node.getMiddle(), builder, out);

        printTree(node.getRight(), rightBuilder, out);
    }

    public void write(Output out) {
        printTree(root, new StringBuilder(), out);
    }
}
