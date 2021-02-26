package sol;

import src.IAttributeDataset;
import src.Vegetable;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListObjsData implements IAttributeDataset<Vegetable> {
    ArrayList<Vegetable> data;
    LinkedList<String> attr;

    public ListObjsData(ArrayList<Vegetable> data) {
        this.data = data;
        this.attr = new LinkedList<>();
        attr.add("color");
        attr.add("lowCarb");
        attr.add("highFiber");
        attr.add("likeToEat");
    }

    @Override
    public ArrayList<Vegetable> getData() {
        return data;
    }

    @Override
    public LinkedList<String> getAttributes() {
        return attr;
    }

    @Override
    public boolean allSameValue(String ofAttribute) {
        for (int i=0;i<size();i++) {
            if (data.get(i).getValueOf(ofAttribute) != data.get(0).getValueOf(ofAttribute)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public LinkedList<IAttributeDataset<Vegetable>> partition(String onAttribute) {
        LinkedList<IAttributeDataset<Vegetable>> out = new LinkedList<IAttributeDataset<Vegetable>>();
        for (int i=0;i<size();i++) {
            if (out.isEmpty()) {
                ArrayList<Vegetable> addVegList = new ArrayList<Vegetable>();
                addVegList.add(data.get(0));
                ListObjsData addDataset = new ListObjsData(addVegList);
                out.addFirst(addDataset);
            } else {
                for (int j = 0; j < out.size(); j++) {
                    ArrayList<Vegetable> attrList = out.get(j).getData();
                    Vegetable veg = data.get(i);
                    if (attrList.get(0).getValueOf(onAttribute) == veg.getValueOf(onAttribute)) {
                        attrList.add(veg);
                        break;
                    } else {
                        if (j == out.size()-1) {
                            ArrayList<Vegetable> addVegList = new ArrayList<Vegetable>();
                            addVegList.add(veg);
                            out.addFirst(new ListObjsData(addVegList));
                            break;
                        }
                    }
                }
            }
        }
        return out;
    }

    @Override
    public Object getSharedValue(String ofAttribute) {
        return data.get(0).getValueOf(ofAttribute);
    }

    @Override
    public Object mostCommonValue(String ofAttribute) {
        ArrayList<Integer> freqs = new ArrayList<Integer>();
        ArrayList<Object> listofValues = new ArrayList<Object>();
        for (int i=0;i<size();i++) {
            Object attrVal = data.get(i).getValueOf(ofAttribute);
            if (!listofValues.contains(attrVal)) {
                listofValues.add(attrVal);
                freqs.add(0);
            } else {
                int j = 0;
                while (listofValues.get(j) != attrVal) {
                    j++;
                }
                freqs.set(j, freqs.get(j) + 1);
            }
        }
        int mostCommonIndex = 0;
        int mostCommonCount = 0;
        for (int i=0;i<freqs.size();i++) {
            if (freqs.get(i) > mostCommonCount) {
                mostCommonCount = freqs.get(i);
                mostCommonIndex = i;
            }
        }
        return listofValues.get(mostCommonIndex);
    }
}
