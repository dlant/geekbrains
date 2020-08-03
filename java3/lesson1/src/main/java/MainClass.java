import java.util.ArrayList;
import java.util.Arrays;


public class MainClass {
    public static void main(String[] args) {
        taskOne();
        taskTwo();
        taskThree();

    }

    public static void taskOne(){
        Integer[] iArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String[] sArr = {" Jan ", " Feb ", " Mar ", " Apr ", " May ", " Jun ", " Jul "};
        swap(iArr,0,5);
        swap(sArr,0,4);

    }
    public static void taskTwo(){
        Integer[] iArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String[] sArr = {" Jan ", " Feb ", " Mar ", " Apr ", " May ", " Jun ", " Jul "};
        System.out.println(arrayToArrayList(iArr));
        System.out.println(arrayToArrayList(sArr));
    }
    public static void taskThree() {
        Box<Apple> boxWithApple = new Box<>();
        Box<Orange> boxWithOranges = new Box<>();
        boxWithApple.addFruit(new Apple(),9);
        boxWithOranges.addFruit(new Orange(),6);
        Box<Orange> anotherBoxWithOranges = new Box<>();
        System.out.println("A box of apples weighs " + boxWithApple.getWeight());
        System.out.println("A box of oranges weight " + boxWithOranges.getWeight());
        System.out.println("boxes are equals? "+boxWithApple.compare(boxWithOranges));

        boxWithOranges.addFruit(new Orange(),2);
        System.out.println("A box of oranges weight " + boxWithOranges.getWeight());

        boxWithOranges.replaceFruitsToAnotherBox(anotherBoxWithOranges);
        System.out.println(anotherBoxWithOranges.getWeight());
        System.out.println(boxWithOranges.getWeight());
    }


    public static void swap(Object[] arr, int n1, int n2){
        System.out.println("Task1: "+Arrays.toString(arr));
        Object sw = arr[n1];
        arr[n1]=arr[n2];
        arr[n2]=sw;
        System.out.println("Swap elements: "+Arrays.toString(arr)+"\n================================");
    }
    public static <T> ArrayList arrayToArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}
