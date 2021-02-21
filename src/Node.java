package src;

public class Node implements INode {
    public Object answer;
    public String query;
    public Node[] branches;

    @Override
    public Object lookupDecision(IAttributeDatum attrVals) {
        return null;
    }

    @Override
    public void printNode(String leadspace) {

    }
}
