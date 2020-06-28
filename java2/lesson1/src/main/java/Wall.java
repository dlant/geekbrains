public class Wall extends Barrier {
    private double height;

    public Wall(String name, double height) {
        super(name);
        this.height = height;
    }

    boolean action(Human human) {
        human.jump(height);
        return (human.jumpHeight > height);
    }

    boolean action(Cat cat) {
        cat.jump(height);
        return (cat.jumpHeight > height);
    }

    boolean action(Robot robot) {
        robot.jump(height);
        return (robot.jumpHeight > height);
    }
}
