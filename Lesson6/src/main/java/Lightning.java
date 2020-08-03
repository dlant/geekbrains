
public class Lightning extends Horse{

    public Lightning(String name) {
        super(name);
        this.runLength=random.nextInt(500)+1500;
        this.swimLength=random.nextInt(50)+100;
        this.jumpHeight=3;
    }
}
