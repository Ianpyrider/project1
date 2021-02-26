package sol;

import src.INode;

public class Edge {
    Object val;
    INode pointsTo;

    public Edge(Object val) {
        this.val = val;
    }

    public void point(INode n) {
        pointsTo = n;
    }
}
