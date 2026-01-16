public class Treasure extends Item {
    public Treasure(String name, String desc, int value) {
        super(name, desc, value);
    }

    @Override
    public String use(Player player) {
        return "It's valuable!";
    }
}
