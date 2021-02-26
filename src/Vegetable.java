package src;

public class Vegetable implements IAttributeDatum {
    public String color;
    public boolean lowCarb;
    public boolean highFiber;
    public boolean likeToEat;
    public String name;

    //For known data, corresponds to a row in the data
    public Vegetable(String name, String color, boolean lowCarb, boolean highFiber, boolean likeToEat) {
        this.name = name;
        this.color = color;
        this.lowCarb = lowCarb;
        this.highFiber = highFiber;
        this.likeToEat = likeToEat;
    }

    @Override
    public Object getValueOf(String attributeName) {
        if (attributeName.equals("color")) {
            return color;
        }
        if (attributeName.equals("lowCarb")) {
            return lowCarb;
        }
        if (attributeName.equals("highFiber")) {
            return highFiber;
        }
        if (attributeName.equals("likeToEat")) {
            return likeToEat;
        }
        else {
            throw new RuntimeException("Invalid attribute");
        }
    }

    public String getName() {
        return name;
    }
}
