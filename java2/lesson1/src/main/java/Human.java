public class Human implements Actions {

    String type;
    public final int runDistance = 500;
    private int distance;
    public final double jumpHeight = 1.7;
    public double height;


    public Human(String type, int distance, double jumpHeight) {
        this.type = type;
        this.distance = distance;
        this.height = jumpHeight;
    }

    public void run(int length) {
        System.out.println(type + " is running " + length + "m");
    }

    public void jump(double wallHeight) {
        System.out.println(type + " jumps at " + wallHeight + "m");


    }

    public void jump() {
        System.out.println(type + " jumps");

    }

    public void run() {
        System.out.println(type + " is running");

    }

}



