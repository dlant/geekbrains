public class Robot implements Actions{
    String type;
    public final int runDistance=1100;
    private int distance;
    public final double jumpHeight=2;
    public double height;



    public Robot(String type, int distance, double jumpHeight) {
        this.type = type;
        this.distance = distance;
        this.height = jumpHeight;
    }
    public void run(int length) {
//        System.out.println(type +" is running " +distance+"m"+" "+isRun(distance));
        System.out.println(type +" is running " +length+"m");


    }

    public void jump(double wallHeight) {
        System.out.println(type +" jumps at " +wallHeight+"m");

    }
    public void jump() {
        System.out.println(type +" jumps");

    }

    public void run() {
        System.out.println(type +" is running");

    }

//    public boolean isRun(int length){
//        return (runDistance>length);
//    }
//    public boolean isJump(int height){
//        return(jumpHeight>height);
//    }
}
