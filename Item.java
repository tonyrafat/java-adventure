public abstract class Item {
    private String name;
    private String description;
    private int value;

    public Item(String name, String description, int value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public String getName() { return name; }

    public abstract String use(Player player);

    @Override
    public String toString() {
        return name;
    }
}

