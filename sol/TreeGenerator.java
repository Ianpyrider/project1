package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;
import src.IGenerator;
import src.INode;

import java.util.LinkedList;

/*
 * Class for creating and interacting with a decision tree given a dataset.
 *
 * T is the type of object that we are trying to classify.
 * (like src.Vegetable)
 */
public class TreeGenerator<T extends IAttributeDatum> implements IGenerator {

    IAttributeDataset<T> initTrainingData;

    /**
     * Constructor for this class.
     *
     * @param initTrainingData - IAttributeDataset of the data table
     */
    public TreeGenerator(IAttributeDataset<T> initTrainingData) {
        // TODO: Implement.
        this.initTrainingData = initTrainingData;
    }

    @Override
    public INode buildClassifier(String targetAttr) {
        // TODO: Implement.
        LinkedList<String> attr = initTrainingData.getAttributes();
        LinkedList<String> out = new LinkedList<>();
        for (int i=0;i<attr.size();i++) {
            if (attr.get(i) != targetAttr) {
                out.add(attr.get(i));
            }
        }

        return builder(initTrainingData, out, null, targetAttr);
        /*if (initTrainingData.size() == 0) {
            return null;
        } else if (initTrainingData.allSameValue(targetAttr)) {
            //initTrainingData.getData().get(0).getValueOf(targetAttr);
            return null;
        } else {
            Node n = new Node("", "color");

            LinkedList<IAttributeDataset<T>> partitionedData =
                    initTrainingData.partition("color");

            for (int i=0;i<partitionedData.size();i++) {
                Edge e = new Edge(partitionedData.get(i).getData().get(0).getValueOf("color"));
                e.point(buildClassifier(targetAttr));
                n.addEdge(e);
            }



        }*/
    }

                /*for (int i=0;i<initTrainingData.getAttributes().size();i++) {
                LinkedList<IAttributeDataset<T>> partitionedData =
                        initTrainingData.partition("color");
                Node n = new Node("color");
                //initTrainingData.getAttributes().get(i) instead of color
                for (int j=0;j<partitionedData.size();j++) {
                    n.addEdge(new Edge(partitionedData.get(j).getData().get(0).getValueOf("color")));
                }
            }*/

    public INode builder(IAttributeDataset<T> subset, LinkedList<String> attrList, Object mostCommon, String targetAttr) {
        if (subset.size() == 0) {
            //return most common value from previous subset
            return new Leaf(mostCommon);
        } else if (subset.allSameValue(targetAttr) | attrList.size() == 0) {
            return new Leaf(subset.mostCommonValue(targetAttr));
        } else {
            String a = attrList.get(0);
            //attrList.remove(0);

            LinkedList<String> attrCopy = new LinkedList<String>();
            for (int i=0;i<attrList.size();i++) {
                attrCopy.addLast(attrList.get(i));
            }
            attrCopy.remove(0);

            Node n = new Node(a);

            LinkedList<IAttributeDataset<T>> partitionedData =
                    subset.partition(a);

            for (int i=0;i<partitionedData.size();i++) {
                Edge e = new Edge(partitionedData.get(i).getData().get(0).getValueOf(a));
                e.point(builder(partitionedData.get(i), attrCopy,
                        partitionedData.get(i).mostCommonValue(targetAttr), targetAttr));
                n.addEdge(e);
            }
            return n;
        }
    }

    @Override
    public Object lookupRecommendation(IAttributeDatum forVals) {
        // TODO: Implement.
        return null;
    }

    @Override
    public void printTree() {
        // TODO: Implement.
    }
}