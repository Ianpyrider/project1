package src;

import java.util.LinkedList;

public class Dataset<T extends IAttributeDatum> implements IAttributeDataset<T> {
    public String[] attributes;
    public T[] rows;

    @Override
    public LinkedList<String> getAttributes() {
        return null;
    }

    @Override
    public boolean allSameValue(String ofAttribute) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public LinkedList<IAttributeDataset<T>> partition(String onAttribute) {
        return null;
    }


    @Override
    public Object getSharedValue(String ofAttribute) {
        return null;
    }

    @Override
    public Object mostCommonValue(String ofAttribute) {
        return null;
    }
}
