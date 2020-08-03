public class Road extends Barrier {
    private int length;

    public Road(String name, int length) {
        super(name);
        this.length = length;
    }

    boolean action(Human human) {
        human.run(length);
        return (human.runDistance > length);
    }

    boolean action(Cat cat) {
        cat.run(length);
        return (cat.runDistance > length);
    }

    boolean action(Robot robot) {
        robot.run(length);
        return (robot.runDistance > length);
    }
}
