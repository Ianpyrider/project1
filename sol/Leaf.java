package sol;

import src.IAttributeDatum;
import src.INode;

public class Leaf implements INode {
    Object val;
    public Leaf (Object val) {
        this.val = val;
    }

    @Override
    public Object lookupDecision(IAttributeDatum attrVals) {
        return val;
    }

    @Override
    public void printNode(String leadspace) {

    }
}
