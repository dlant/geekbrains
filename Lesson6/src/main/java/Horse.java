public class Horse extends Animal {

    public Horse(String name) {
        super(name);
        this.type="Конь";
        this.runLength=1500;
        this.swimLength=100;
        this.jumpHeight=3;
    }
    @Override
    public void run(int dist) {
        if (dist<=this.runLength) System.out.println(type + " " + name + " проcкакал " + dist + "м "+
                "из максимальных "+runLength);
        else System.out.println(type + " " + name + " не сможет проскакать столько "+",максимум " +
                runLength);}
}
