public class Thunder extends Lightning{

    public Thunder(String name){
        super(name);
        this.runLength=random.nextInt(700)+1900;
        this.swimLength=random.nextInt(100)+100;
    }
}
