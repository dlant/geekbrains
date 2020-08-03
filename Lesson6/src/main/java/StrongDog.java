
public class StrongDog extends Dog{

    public StrongDog(String name) {
        super(name);
        this.runLength=random.nextInt(100)+570;
        this.swimLength=random.nextInt(10)+15;
        this.jumpHeight=0.8;
    }
}
