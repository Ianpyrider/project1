package sol;

import src.Vegetable;

import java.util.ArrayList;

import static tester.Printer.print;

public class TestSuite {
    public static void test() {
        Vegetable carrot = new Vegetable("carrot", "Orange", true, true, false);
        Vegetable yam = new Vegetable("yam","Orange", false, false, false);
        Vegetable eggplant = new Vegetable("eggplant","Purple", true, false, true);
        Vegetable orange = new Vegetable("orange","Orange", true, true, true);
        Vegetable tomato = new Vegetable("tomato","Red", false, false, true);
        Vegetable apple = new Vegetable("apple", "Red", true, true, false);
        Vegetable kumquat = new Vegetable("kumquat", "Orange", true, true, true);
        Vegetable sweetPotato = new Vegetable("sweet potato", "Orange", true, false, true);
        ArrayList<Vegetable> vegetables = new ArrayList<>();
        vegetables.add(carrot);
        vegetables.add(yam);
        vegetables.add(eggplant);
        vegetables.add(orange);
        vegetables.add(tomato);
        vegetables.add(apple);
        vegetables.add(kumquat);
        vegetables.add(sweetPotato);
        ListObjsData example = new ListObjsData(vegetables);
        TreeGenerator<Vegetable> treeGen = new TreeGenerator<Vegetable>(example);

        /*print(example.size());
        System.out.println(example.getData());
        System.out.println(example.getAttributes());
        System.out.println(example.allSameValue("highFiber"));
        System.out.println("allsameVal lowCarb:" + example.allSameValue("lowCarb"));
        System.out.println(example.mostCommonValue("likeToEat"));
        System.out.println(example.getSharedValue("color"));
        //System.out.println(example.partition("highFiber").get(0).getData().get(0).getName());
        //System.out.println(example.partition("color").get(2).getData().get(0).getName());
        System.out.println("Done");*/

        print(treeGen.buildClassifier("likeToEat"));

    }

    public static void main(String[] args) {
        test();
    }
}
