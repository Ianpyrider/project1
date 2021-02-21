package src;

public class Vegetable implements IAttributeDatum {
    public String color;
    public Boolean lowCarb;
    public Boolean highFiber;
    public Boolean likeToEat;

    //For known data, corresponds to a row in the data
    public Vegetable(String color, Boolean lowCarb, Boolean highFiber, Boolean likeToEat) {
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
}
