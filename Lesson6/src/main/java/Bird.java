public class Bird extends Animal{

    public Bird(String name) {
        super(name);
        this.type="Птица";
        this.runLength=5;
        this.swimLength=0;
        this.jumpHeight=0.1;
    }
    @Override
    public void swim(int swim){
        System.out.println(type+" "+name+" не умеет плавать");
    }
}
