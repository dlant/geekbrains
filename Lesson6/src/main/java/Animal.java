import java.util.Random;

public class Animal {
    public int swimLength = 0;
    public int runLength =0;
    public double jumpHeight =0;
    public String name;
    public String type;
    public Random random = new Random();

    public Animal(String name){
        this.name=name;
    }
    public void run(int dist) {
        if (dist<=this.runLength) System.out.println(this.type + " " + this.name + " пробежал " + dist + "м.");
        else System.out.println(this.type + " " + this.name + " не сможет пробежать столько "+dist);}

    public void swim(int dist) {
        if ( dist<=this.swimLength) System.out.println(this.type + " " + this.name + " проплыл " + dist + " м.");
        else System.out.println(this.type + " " + this.name + " не сможет столько проплыть "+dist);

    }
    public void jump(double height) {
        if (this.jumpHeight >= height)
            System.out.println(this.type + " " + this.name + " подпрыгнул " + height + " м.");
        else System.out.println(this.type + " " + this.name + " не сможет прыгнуть на эту высоту "+height);
    }
}

