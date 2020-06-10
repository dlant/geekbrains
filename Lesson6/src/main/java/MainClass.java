public class MainClass {

    public static void main(String[] args) {
        StrongDog dog1=new StrongDog("Пауэр");
        Dog dog=new Dog("Бобик");
        Horse horse=new Horse("Огонь");
        Thunder horse2=new Thunder("Гром");
        Lightning horse1=new Lightning("Молния");
        Cat cat= new Cat("Васька");
        Bird bird=new Bird("Ара");

            dog1.swim(17);
            dog.swim(10);
            horse.run(1300);
            cat.jump(1.7);
            bird.swim(2);
            horse2.run(1950);
            dog1.run(600);
            horse1.run(1800);

        Animal[] zoo={dog1,dog,horse,cat,bird,horse1,horse2} ;
        int sum=zoo.length;
        int dogCounter=0; int catCounter=0; int horseCounter=0; int birdCounter=0;
        for (int i = 0; i <zoo.length; i++) {
            if(zoo[i] instanceof Dog){
                dogCounter++;
            }
            if(zoo[i] instanceof Cat){
                catCounter++;
            }
            if(zoo[i] instanceof Horse){
                horseCounter++;
            }
            if(zoo[i] instanceof Bird){
                birdCounter++;
            }

        }
        System.out.println("Всего "+sum+" животных ");
        System.out.println("Из них "+dogCounter+" собаки, "+catCounter+" кот, "+horseCounter+" лошади, "
        +birdCounter+" птица");
    }
}
