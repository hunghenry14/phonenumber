package interview.model.tst;

import interview.model.Validity;
import interview.model.sortedtree.SortedTree;

public class NodeData {
    private char digit;

    private SortedTree validities;

    public NodeData(char digit) {
        this.digit = digit;
    }

    public char getDigit() {
        return digit;
    }

    public void setKey(char key) {
        this.digit = key;
    }

    public Validity getValidity() {
        return this.validities.getInterval();
    }

    public void add(Validity validity) {
        if(validities == null) {
            validities = new SortedTree();
        }
        this.validities.insert(validity);
    }

}
