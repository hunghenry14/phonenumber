package interview.service.impl;

import interview.io.Input;
import interview.io.Output;
import interview.model.tst.TernarySearchTree;
import interview.service.IFindAcutualActivationDateService;

public class FindActualActivationDateService implements IFindAcutualActivationDateService {

    public void find(Input in, Output out) {
        try {
            TernarySearchTree tree = new TernarySearchTree();
            while (in.hasNext()) {
                tree.insertOrUpdate(in.readNext());
            }
            tree.write(out);
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}
