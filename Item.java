public abstract class Item {
    protected String name;
    protected String description;
    protected int value;

    public Item(String name, String desc, int value) {
        this.name = name;
        this.description = desc;
        this.value = value;
    }

    public String getName() { return name; }

    public abstract String use(Player player);

    @Override
    public String toString() { return name; }
}
