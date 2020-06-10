public class Cat extends Animal{

    public Cat(String name) {
        super(name);
        this.type="Кот";
        this.runLength=200;
//        this.swimLength=0;
        this.jumpHeight=2;

    }
    @Override
    public void swim(int swim){
//        if (swim > swimLength)
        System.out.println("кот не умеет плавать");
    }
}
