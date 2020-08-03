public class Main {
    public static void main(String[] args) {
        Human human = new Human("human", 500, 1.7);
        Cat cat = new Cat("cat", 100, 1);
        Robot robot = new Robot("robot", 1000, 2);
        robot.run();
        human.jump();

        Actions[] zoo = new Actions[3];
        zoo[0] = human;
        zoo[1] = cat;
        zoo[2] = robot;
        boolean result = true;

        Barrier[] barriers = new Barrier[2];
        barriers[0] = new Road("road", 400);
        barriers[1] = new Wall("wall", 0.8);

        for (int i = 0; i < zoo.length; i++) {
            for (int j = 0; j < barriers.length; j++) {

                if (Human.class.equals(zoo[i].getClass())) {
                    result = barriers[j].action((Human) zoo[i]);

                }
                if (Cat.class.equals(zoo[i].getClass())) {
                    result = barriers[j].action((Cat) zoo[i]);
                }
                if (Robot.class.equals(zoo[i].getClass())) {
                    result = barriers[j].action((Robot) zoo[i]);

                }
                if (result) {
//                    System.out.println("Success!!");
                    System.out.println(result);
                } else {
//                    System.out.println("unsuccessfully!!");
                    System.out.println(result);

                }
            }

        }


    }
}
