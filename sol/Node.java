package sol;

import src.IAttributeDatum;
import src.INode;

import java.util.ArrayList;

public class Node implements INode {
    public String a;
    public ArrayList<Edge> children = new ArrayList<Edge>();

    public Node(String a) {
        this.a = a;
    }

    public void addEdge(Edge e) {
        children.add(e);
    }

    public boolean hasChildren() {
        return (children.size() == 0);
    }

    @Override
    public Object lookupDecision(IAttributeDatum attrVals) {
        return null;
    }

    @Override
    public void printNode(String leadspace) {

    }
}
