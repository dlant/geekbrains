public abstract class Barrier {
    private String name;

    public Barrier(String name) {
        this.name = name;
    }

    abstract boolean action(Human human);

    abstract boolean action(Cat cat);

    abstract boolean action(Robot robot);
}
