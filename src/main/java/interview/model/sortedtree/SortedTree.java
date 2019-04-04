package interview.model.sortedtree;

import interview.model.Validity;

public class SortedTree {
    private Node root = null;

    private Validity interval;

    public void insert(Validity validity) {
        root = insertInternal(root, validity);
    }

    private Node insertInternal(Node node, Validity validity) {
        if (node == null) {
            node = new Node(validity);
        }
        if (node.getData().getActivationDate().isAfter(validity.getActivationDate())) {
            node.setLeft(insertInternal(node.getLeft(), validity));
        } else if (node.getData().getActivationDate().isBefore(validity.getActivationDate())) {
            node.setRight(insertInternal(node.getRight(), validity));
        }

        return node;
    }

    public Validity getInterval() {
        interval = null;
        computeInterval(root);
        return interval;
    }

    private void computeInterval(Node node) {
        if (node == null) {
            return;
        }
        computeInterval(node.getLeft());
        if (interval == null) {
            interval = node.getData();
        } else if (interval.getDeactivationDate() != null
                && node.getData().getActivationDate().isAfter(interval.getDeactivationDate())) {
            interval = node.getData();
        } else {
            interval = new Validity(interval.getActivationDate(), node.getData().getDeactivationDate());
        }
        computeInterval(node.getRight());
    }
}
