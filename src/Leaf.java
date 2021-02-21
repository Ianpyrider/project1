package src;

public class Leaf implements INode {
    public Object answer;
    public Boolean value;

    @Override
    public Object lookupDecision(IAttributeDatum attrVals) {
        return null;
    }

    @Override
    public void printNode(String leadspace) {

    }
}
